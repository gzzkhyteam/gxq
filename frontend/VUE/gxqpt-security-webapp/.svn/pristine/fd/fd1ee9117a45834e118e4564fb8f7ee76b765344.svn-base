<template>
	<div class="ivu-layout" id="serviceDetail">
        <Card :bordered="false">
          <Row style="margin: -54px 0 15px; text-align: right;">
              <Col span="24">
                  <Button type="default" @click="goBack">返回</Button>
              </Col>
          </Row>
	        <p slot="title">
	          <span>故障详情</span>
	        </p>
			<Form :model="dataView" :label-width="100" class="clearfix">
                <Row :gutter="40">
                    <Col span="12">
                        <FormItem label="故障名称：">
                            <Input :value="dataView.faultName" type="text" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="故障级别：">
                            <Input :value="dataView.faultLevel | filtersFaultLevel" type="text" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="故障主机：">
                            <Input :value="dataView.faultHost" type="text" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="系统名称：">
                            <Input :value="dataView.systemName" type="text" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="故障简述：">
                            <Input :value="dataView.faultInfo" type="textarea" :autosize="{minRows: 5, maxRows: 5}" disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
	    </Card>
	    <Card :bordered="false" v-if="isShowDeal" style="margin-top: 20px;">
	        <p slot="title">处理详情</p>
			<Form :model="dataView" :label-width="100" class="clearfix">
                <Row :gutter="40">
                    <Col span="12">
                        <FormItem label="是否属实：">
                            <Input :value="dataView.isTrue|filterIsTrue" type="text" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="24" v-if="dataView.isTrue=='2'">
                        <FormItem label="理由：">
                            <Input :value="dataView.dealOpinion" type="textarea" disabled :rows="2"></Input>
                        </FormItem>
                    </Col>
                    <template v-if="dataView.isTrue != '2' && dataView.status == '3'">
                        <Col span="12">
                            <FormItem label="故障类别：">
                                <Input :value="dataView.faultType" type="text" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="故障级别：">
                                <Input :value="dataView.faultLevel | filtersFaultLevel" type="text" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="故障简述：">
                                <Input :value="dataView.faultInfo" type="textarea" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="处理时间：">
                                <Input :value="dataView.dealTime" type="text" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="处理流程：">
                                <Input :value="dataView.dealProcess" type="textarea" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="结果：">
                                <Input :value="dataView.result" type="textarea" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="建议：">
                                <Input :value="dataView.advice" type="textarea" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="附件：">
                                <p v-for="fileItem in dataView.fileList">
                                    <a class="downloadMain" href="javascript:" @click="downloadFile(fileItem.fileUrl,fileItem.fileName)">
                                        {{fileItem.fileName}}
                                        <Icon class="downloadIcon" type="archive"></Icon>
                                    </a>
                                </p>
                            </FormItem>
                        </Col>
                        <Col span="12">
                            <FormItem label="是否加入知识库：">
                                <Input :value="dataView.isJoinKnowledge | filterIsknow" type="text" disabled></Input>
                            </FormItem>
                        </Col>
                    </template>
                </Row>
            </Form>
	    </Card>
    </div>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
export default {
	data() {
		return {
			dataView: {}
		}
	},
	computed: {
		isShowDeal () {
			return this.dataView.status == 2 || this.dataView.status == 3
		},
        systemNames () {
            const systemNames = []
            this.dataView.chargeSystemDTOS = this.dataView.chargeSystemDTOS || []
            this.dataView.chargeSystemDTOS.map(system => {
                systemNames.push(system.systemName)
            })
            return systemNames.join(',')
        }
	},
	filters:{
        // 是否加入知识库
        filterIsknow(val){
            if(val==1){
                return "是";
            }else{
                return "否";
            };
        },
        // 是否属实
		filterIsTrue(val){
			if(val=="1"){
				return "属实";
			}else{
				return "不属实";
			}
		},
        // 故障级别
		filtersFaultLevel(val){
            let faultLevelText = ''
            switch (val){
                case '1':
                    faultLevelText = '一级'
                    break;
                case '2':
                    faultLevelText = '二级'
                    break;
                case '3':
                    faultLevelText = '三级'
                    break;
                default:
                    break;
            }
            return faultLevelText;
        }
	},
	mounted () {
		this.faultGetById()
	},
	methods:{
		faultGetById() { // 根据Id查询详情信息
			const vm = this
			api(operationApiList.faultGetById, {
				id: vm.$route.params.id
			}).then((res) => {
				if(res.status == 200 && res.data.data) {
					vm.dataView = res.data.data
				}
			}, err => {})
		},
		goBack() {
			this.$router.go(-1)
		}
	}
}
</script>

<style lang="less" scoped>
#serviceDetail{
    margin-top: 20px;
    padding: 0 16px 16px;
}
.downloadMain{
    position: relative;
}
.downloadIcon{
    position: absolute;
    bottom: -1px;
    right: -20px;
}
</style>
