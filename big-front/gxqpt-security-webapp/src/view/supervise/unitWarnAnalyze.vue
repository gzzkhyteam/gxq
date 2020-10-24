<template>
    <Layout>
		<Content>
			<Breadcrumb>
				<BreadcrumbItem>预警分析</BreadcrumbItem>
				<BreadcrumbItem>单位预警分析</BreadcrumbItem>
			</Breadcrumb>
			<Card style="margin-bottom: 20px;">
				<Form ref="formValidate" :model='formData' :rules="ruleValidate" inline :label-width="100">
					<FormItem label="时间">
                        <DatePicker :options="dateOptions" v-model="defaultDate" type="year" placeholder="选择时间"  style="width: 200px"></DatePicker>
                        <Button v-if="checkButton('supervise_analysis_company_view')" type="primary" @click="refreshAnalyze">查看分析</Button>
					</FormItem>
					<FormItem>
					</FormItem>
				</Form>
			</Card>
        <Layout style="background:#fff;">
            <carouseList :data='unitList' :arrowType='arrowType'></carouseList>
            <Layout>
                <Col span="14"></Col>
                <Col span="9"></Col>
                <Row type="flex" justify="space-between">
                  <Col style="width: 49%;">
                    <chart-card title="各单位预警状态">
                      <unitWarnState ref="unitWarnState" />
                    </chart-card>
                  </Col>
                  <Col style="width: 49%;">
                    <chart-card title="各单位预警类别情况">
                      <unit-category ref="unitCategorye" />
                    </chart-card>
                  </Col>
                </Row>
                <Row type="flex" justify="space-between">
                  <Col style="width: 49%;">
                    <chart-card title="各单位预警处理对比分析">
                      <unit-manage ref="unitManageData" />
                    </chart-card>
                  </Col>
                  <Col style="width: 49%;">
                    <chart-card title="各单位预警级别情况">
                      <unit-level ref="unitLevel" />
                    </chart-card>
                  </Col>
                </Row>
            </Layout>
        </Layout>
		</Content>
	</Layout>
</template>

<script>
import api from '@/api/axiosApi'
import superviseApiList from '@/api/superviseApiList'
// echart图外层容器，包括卡片样式
import chartCard from './echarts/chartCard.vue'
import countUp from '@/components/hengyun/countUp.vue'
// 各单位预警状态
import unitWarnState from './echarts/unitWarnState.vue'
// 各单位预警类别情况
import unitCategory from './echarts/unitCategory.vue'
// 各单位预警处理对比分析
import unitManage from './echarts/unitManage.vue'
// 各单位预警级别情况
import unitLevel from './echarts/unitLevel.vue'
// 顶部滑动列表模块
import carouseList from "./modal/carouseList.vue";
import { mapState } from 'vuex'
// 保存单位的信息
const allUnitList = new Map()
export default {
    components: {
      'chart-card': chartCard,
      countUp,
      unitWarnState,
      carouseList,
      'unit-category': unitCategory,
      'unit-manage': unitManage,
      'unit-level': unitLevel
    },
    data(){
        return{
            arrowType:'never',
            unitList:[],//单位列表
            defaultDate:new Date(),//获取今年年份
            orgIds:[],//初始化单位集合
            ruleValidate:{},
            formData:{},
            dateOptions: {
            // disabledDate是一个函数,参数是当前选中的日期值,这个函数需要返回一个Boolean值,
                disabledDate: (year) => {
                    var myYear = year.getFullYear()
                    var myDate = new Date();
                    // 如果函数处理比较简单,可以直接在这里写逻辑方法
                    return !(myYear <= myDate.getFullYear() && myYear >= 1900)
                //return this.dealDisabledDate(time)
                }
            }
        }
    },
    mounted(){
        this.init();
    },
    methods:{
        init(){
            this.getUnitData(this.defaultDate.getFullYear().toString());
        },
        getUnitData(year){//获取基本单位id
            api(superviseApiList.findOrgByUser).then((res) => {
                if(res.data.errcode == 0) {
                    allUnitList.clear()
                    for(var i = 0;i<res.data.data.length;i++){
                        this.orgIds.push(res.data.data[i].id);
                        allUnitList.set(res.data.data[i].id, res.data.data[i]);
                    }
                    this.getFindSurvey(year);
                    this.getFindPublicSuperviseStatus(year);
                    this.getFindTypeLists(year);
                    this.getFindPublicHandle(year);
                    this.getFildLevelList(year);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        getFindSurvey(y){//获取所有单位关联未处理预警的数量
        	let _this = this;
            let data = {};
            data['orgIds'] = this.orgIds;
            if(y)data.date=y;
            api(superviseApiList.findSurvey,data).then((res) => {
                if(res.data.errcode == 0) {
                    // 两层数组的里面一层，每满8个就push一次
                    let subArr = []
                    let unitListTemp = []
                    // 遍历所有的应用信息
                    res.data.data.map((data, idx) => {
                        subArr.push({
                            color: "#F7645D",
                            idName: data.name,
                            count: data.num,
                            countSize: "#50",
                            introText: data.name,
                            link: `/unitWarnAnalyzeView/${data.id}`
                        })
                        allUnitList.delete(data.id)
                        if(subArr.length === 8) {
                          unitListTemp.push(subArr)
                          subArr = []
                        }
                    })
                    // 遍历剩余没有数字的人员
                    let size = allUnitList.size
                    allUnitList.forEach((value, key, map) => {
                      subArr.push({
                        color: "#F7645D",
                        idName: value.name,
                        count: 0,
                        countSize: "#50",
                        introText: value.name
                      })
                      size--
                      if(subArr.length === 8 || size === 0) {
                        unitListTemp.push(subArr)
                        subArr = []
                      }
                    })
                    // 如果没有为0的就需要判断这个条件
                    if (subArr.length > 0) {
                      unitListTemp.push(subArr)
                    }
                    this.unitList = unitListTemp;
                    if(_this.unitList.length>1){
                        _this.arrowType='always';
                    };
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        getFindPublicSuperviseStatus(y){//各单位预警状态
            const vm = this
            let data = {};
            data['orgIds'] = vm.orgIds;
            if(y)data.date=y;
            api(superviseApiList.findPublicSuperviseStatus,data).then((res) => {
                if(res.data.errcode == 0) {
                    vm.$refs.unitWarnState.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        getFindTypeLists(y){//各单位预警类别情况
            let data = {};
            data['ids'] = this.orgIds;
            if(y)data.date=y;
            api(superviseApiList.findTypeList,data).then((res) => {
                if(res.data.errcode == 0) {
                    this.$refs.unitCategorye.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        getFindPublicHandle(y){//各单位预警处理时长对比分析
            let data = {};
            data['orgIds'] = this.orgIds;
            if(y)data.date=y;
            api(superviseApiList.findPublicHandle,data).then((res) => {
                if(res.data.errcode == 0) {
                    this.$refs.unitManageData.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        getFildLevelList(y){//各单位预警级别情况
            let data = {};
            data['ids'] = this.orgIds;
            if(y)data.date=y;
            api(superviseApiList.fildLevelList,data).then((res) => {
                if(res.data.errcode == 0) {
                    this.$refs.unitLevel.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        // getUnit(val){//获取选项卡单位
        //     this.formData.year = val;
        //     console.log(val);
        // },
        changeYear(val){//选取年份
            this.init(val);//初始化界面
        },
        refreshAnalyze(){//查看刷新的分析
            this.unitList = [];
            const year = this.defaultDate.getFullYear().toString()
            this.getUnitData(year)
        },
        checkButton(code){
			if(this.authButton.indexOf(code) >= 0){
				return true;
			}else{
				return false;
			}
		}
    },
    computed: {
		...mapState([
			'authButton'
		])
	},
}
</script>

<style lang="less" scoped>
.radioMod{
    width:80%;
    height:100%;
    padding:10px 0;
    border:1px solid #ccc;
    border-radius: 50%;
    margin: 30px auto;
}
.mf{
    margin-left:2%;
}
.radioTxt{
    width:100px;
    height:100px;
    margin:35px auto;
    font-size:20px;
    text-align: center
}
.card-title{
    text-align: center;
    background-color: #888;
}
</style>
