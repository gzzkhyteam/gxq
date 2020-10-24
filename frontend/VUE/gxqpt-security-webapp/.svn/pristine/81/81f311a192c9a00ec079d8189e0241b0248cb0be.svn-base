<template>
    <Layout>
		<Content>
			<Breadcrumb>
				<BreadcrumbItem>预警分析</BreadcrumbItem>
				<BreadcrumbItem>部门预警分析</BreadcrumbItem>
			</Breadcrumb>
			<Card>
				<Form ref="formValidate" :rules="ruleValidate" inline :label-width="100">
                    <FormItem label="时间">
                        <DatePicker v-model="defaultDate" type="year" placeholder="选择时间"  :options="pickerOptions" style="width: 200px"></DatePicker>
					</FormItem>
                    <FormItem label="部门选择" v-if="!$route.params.id">
                        <Select
                            v-model="dpmIndex"
                            style="width:180px">
                            <Option
                                v-for="(item, index) in dpmList"
                                :key="index"
                                :value="index">
                                {{item.name}}
                            </Option>
                        </Select>
                    </FormItem>
					<FormItem>
						<Button type="primary" @click="refreshAnalyze">查看分析</Button>
					</FormItem>
					<FormItem class="rt" v-if="$route.params.id">
						<router-link to="/departmentWarnAnalyze"><Button type="primary">返回</Button></router-link>
					</FormItem>
				</Form>
			</Card>
            <Layout>
                <Layout style="background:#fff;">
                    <Row>
                        <Col span="3" style="padding: 15px;background-color: #59d4d4;font-size: 16px;">
                            {{$route.query.app ? `${$route.query.app}的` : ''}}预警分析
                        </Col>
                    </Row>
                    <Row type="flex" justify="space-between">
                      <Col span="11" class="bgWhite">
                          <div class="level-container">
                          	<div class="lt lt_tle">预警级别</div>
                          	<div class="lt lt_item" v-for="item in warnlevel" :class="item.className">
                          		<h3>{{item.title}}</h3>
                          		<p><span class="fontSize">{{item.num}}</span>{{item.quantifier}}</p>
                          	</div>
                          </div>
                      </Col>
                      <Col span="13" class="bgWhite">
                      <!-- 预警类型 -->
                      	<!-- <Col span="8">
							<div class="warning-level">
								<unit-warning-level ref="warnType"></unit-warning-level>
							</div>
						</Col> -->
                      	<Col span="12"><!-- 预警级别 -->
							<div class="warning-level">
								<level-warning ref="warnLevel"></level-warning>
							</div>
						</Col>
                      	<Col span="12"><!-- 预警处理情况 -->
							<div class="warning-level">
								<back-warning ref="warnBack"></back-warning>
							</div>
						</Col>
                      </Col>
                    </Row>
                    <Row type="flex" justify="space-between" style="margin-top: 30px;">
                      <Col style="background-color: #fff;width: 49%;"><!-- 对比分析 -->
                        <chart-card title="预警类型对比分析">
                            <contrast-analyze ref="contrastAnalyze"></contrast-analyze>
                        </chart-card>
                      </Col>
                      <Col style="width: 49%;"><!-- 预警产生处理情况 -->
                        <chart-card :title="`${$route.query.app || ''}预警产生处理情况`">
                            <deal-state ref="dealState"></deal-state>
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
import {mapState} from 'vuex'
import superviseApiList from '@/api/superviseApiList'
// echart图外层容器，包括卡片样式
import chartCard from './echarts/chartCard.vue'
// 对比分析
import contrastAnalyze from './echarts/contrastAnalyze.vue'
// 单位预警处理情况
import unitWarnDealState from './echarts/unitWarnDealState.vue'
// 预警类型
import unitPieCharts from './echarts/unitPieCharts'
// 预警级别
import levelPieCharts from './echarts/levelPieCharts'
// 退出理由
import backPieCharts from './echarts/backPieCharts'
// 顶部滑动列表模块
import carouseList from "./modal/carouseList.vue";

export default {
    components: {
        carouseList,
        chartCard,
        'dealState': unitWarnDealState,
        'unitWarningLevel': unitPieCharts,
        'levelWarning': levelPieCharts,
        'backWarning': backPieCharts,
        'contrastAnalyze': contrastAnalyze,
    },
    data(){
        return{
            defaultDate: new Date(), // 获取今年年份
            orgIds:[],
            dpmList: [], // 部门列表，预警系统要用
            dpmIndex: 0, // 当前选中的部门的索引号
            unitLevel:[],
            GxqptPublicLevel:{1:'一般预警',2:'较重预警',3 :'严重预警 ',4:'特别严重预警'},
            value1: 0,
            ruleValidate:{},
            formData:{},
            warnlevel:[
                {
                    title:"特别严重预警",
                    num:0,
                    quantifier:"个",
                    className:"most",
                },
                {
                    title:"严重预警",
                    num:0,
                    quantifier:"个",
                    className:"danger",
                },
                {
                    title:"较重预警",
                    num:0,
                    quantifier:"个",
                    className:"serious",
                },
                {
                    title:"一般预警",
                    num:0,
                    quantifier:"个",
                    className:"normal",
                }
            ],
            caOptions:{
                legendData:[],
            },
            pickerOptions: {
                // disabledDate是一个函数,参数是当前选中的日期值,这个函数需要返回一个Boolean值,
                disabledDate: (year) => {
                    var myYear = year.getFullYear()
                    var myDate = new Date();
                    // 如果函数处理比较简单,可以直接在这里写逻辑方法
                    return !(myYear <= myDate.getFullYear() && myYear >= 1900)
                //return this.dealDisabledDate(time)
                }
            } // 日期设置对象
        }
    },
    computed: {
        ...mapState(['userInfo'])
    },
    mounted(){
        const vm = this
        vm.orgId = vm.$route.params.id; // 传递的部门id
        if (!vm.$route.params.id) {
            vm.getDpmList()
        } else {
            const year = vm.defaultDate.getFullYear().toString();
            vm.init(year)
        }
    },
    methods:{
        init(year){
            this.findPublicContrast(year);
            // this.warntype(year);
            this.warnlevels(year);
            this.warnHandleStatistical(year);
        },
        // 获取部门列表
        getDpmList () {
            const vm = this
            api(superviseApiList.findDpmByUser)
            .then((res) => {
                if(res.data.errcode == 0) {
                    vm.dpmList = res.data.data || [{id: ''}]
                    vm.orgId = vm.dpmList[0].id
                    const year = vm.defaultDate.getFullYear().toString();
                    vm.init(year)
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        warnlevels(y){ // 该部门各预警级别情况
            let data = {};
            if (this.orgId) {
                data['id'] = this.orgId;
            }
            if(y)data.year=y;
            api(superviseApiList.depanalysisWarnlevel,data).then((res) => {
                if(res.data.errcode == 0) {
                    const data = res.data.data
                    const num = data.length
                    for (var i = 0 ; i < num; i++) {
                        let level = data[i].level
                        if (1 === Number(level)) {
                        this.warnlevel[3].num = data[i] ? data[i].count : 0;
                        }
                        if (2 === Number(level)) {
                        this.warnlevel[2].num = data[i] ? data[i].count : 0;
                        }
                        if (3 === Number(level)) {
                        this.warnlevel[1].num = data[i] ? data[i].count : 0;
                        }
                        if (4 === Number(level)) {
                        this.warnlevel[0].num = data[i] ? data[i].count : 0;
                        }
                    }
                  this.$refs.warnLevel.refresh(res.data.data);
                }else{
                  this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        warntype(y){ // 该部门各预警类型情况
            let data = {};
            if (this.orgId) {
                data['id'] = this.orgId;
            }
            if(y)data.year=y;
            api(superviseApiList.depanalysisWarntype,data).then((res) => {
                if(res.data.errcode == 0) {
                    this.$refs.warnType.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        warnHandleStatistical(y){//各部门预警处理时长对比分析
            let data = {};
            if (this.orgId) {
                data['id'] = this.orgId;
            }
            if(y)data.year=y;
            api(superviseApiList.depanalysisWarnHandleStatistical,data).then((res) => {
                if(res.data.errcode == 0) {
                    this.$refs.warnBack.refresh(res.data.data);
                    this.$refs.dealState.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        findPublicContrast(y){//公用查询对比分析
            let data = {};
            if (this.orgId) {
                data['dpmId'] = this.orgId;
            }
            if(y)data.date=y;
            api(superviseApiList.findPublicContrast,data).then((res) => {
                if(res.data.errcode == 0) {
                    res.data.data.legendData=["平均水平", this.$route.query.app || this.dpmList[this.dpmIndex].name];
                    this.$refs.contrastAnalyze.refresh(res.data.data);
                }else{
                    this.$Message.error(res.data.errmsg);
                }
            }, (error) => {})
        },
        refreshAnalyze(){
            this.init(this.defaultDate.getFullYear().toString());
        },
    },
    watch: {
        dpmIndex () {
            this.orgId = this.dpmList[this.dpmIndex].id
        }
    }
}
</script>

<style lang="less" scoped>
.bgWhite{
    background-color: #fff;
}
.level-container{
    margin-top: 83px;
}
.lt{
	float: left;
}
.rt{
	float: right;
}
.lt_tle{
	width: 1em;
	padding: 1em 2em;
	line-height: 30px;
}
.lt_item{
	width: 110px;
	height: 110px;
	border: 1px solid #0066CC;
	border-radius: 50%;
	text-align: center;
	margin: 1.3em;
	h3{
		margin: 2.5em 0 1em;
	}
}
.most{
    color: #FD7F7F;
    border-color: #FD7F7F;
}
.danger{
    color: #FFA358;
    border-color: #FFA358;
}
.serious{
    color: #FFD851;
    border-color: #FFD851;
}
.normal{
    color: #55CFF4;
    border-color: #55CFF4;
}
.fontSize{
	font-size: 18px;
}
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
.warning-level,
.app-warning-analysis,
.warning-occur-handle{
	height: 300px;
}
</style>
