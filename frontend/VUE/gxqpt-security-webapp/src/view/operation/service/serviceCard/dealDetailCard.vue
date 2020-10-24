<template>
    <Card :bordered="false">
        <p slot="title">处理详情</p>
        <Form ref="detail" :model="detail" :label-width="100" class="clearfix">
            <Row :gutter="40">
                <Col span="24">
                <FormItem label="时间：">
                    <Input v-model="detail.reportTime" disabled></Input>
                </FormItem>
                </Col>
                <Col span="24">
                <FormItem label="服务过程：">
                    <Input v-model="detail.serviceProcess" type="textarea" :autosize="{minRows: 2,maxRows: 5}" disabled></Input>
                </FormItem>
                </Col>
                <Col span="24">
                <FormItem label="结果：">
                    <Input v-model="detail.result" type="textarea" :autosize="{minRows: 2,maxRows: 5}" disabled></Input>
                </FormItem>
                </Col>
                <Col span="24">
                <FormItem label="备注：">
                    <Input v-model="detail.remark" type="textarea" :autosize="{minRows: 2,maxRows: 5}" disabled></Input>
                </FormItem>
                </Col>
                <Col span="24">
                <FormItem label="服务报告：">
                    <Row class="marginBottom" v-for="fileItem in detail.fileDTOS" :key="fileItem.id" v-if="fileItem.bussType=='service_report'">
                        <Col span="20">
                            <Input :value="fileItem.fileName" disabled></Input>
                        </Col>
                        <Col span="4">
                        <Button type="primary" @click="downloadFile(fileItem.fileUrl,fileItem.fileName)" style="float: right;">下载</Button>
                        </Col>
                    </Row>
                    <Input v-if="isShowReport" value="无附件" disabled></Input>
                </FormItem>
                </Col>
                <Col span="24">
                    <FormItem label="服务成果：">
                        <Row class="marginBottom" v-for="fileItem in detail.fileDTOS" :key="fileItem.id" v-if="fileItem.bussType=='service_result'">
                            <Col span="20">
                                <Input :value="fileItem.fileName" disabled></Input>
                            </Col>
                            <Col span="4">
                                <Button type="primary" @click="downloadFile(fileItem.fileUrl,fileItem.fileName)" style="float: right;">下载</Button>
                            </Col>
                        </Row>
                        <Input v-if="isShowResult" value="无附件" disabled></Input>
                    </FormItem>
                </Col>
            </Row>
        </Form>
    </Card>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
export default {
    props: ['serverData'],
    computed: {
        detail () {
            return this.serverData || {}
        },
        isShowReport () {
            const vm = this
            if(vm.detail.fileDTOS.length>0){
                let fileArray = vm.detail.fileDTOS;
                for(let file of fileArray){
                    if(file.bussType=='service_report'){
                        return false
                    }
                }
            }
            return true
        },
        isShowResult () {
            const vm = this
            if(vm.detail.fileDTOS.length>0){
                let fileArray = vm.detail.fileDTOS;
                for(let file of fileArray){
                    if(file.bussType=='service_result'){
                        return false
                    }
                }
            }
            return true
        }
    },
    methods: {
        downloadFile(url,filename){
            let urlDownload = "/api/file/file/download?url=" + url + "&filename=" + filename
            window.open(urlDownload)
        }
    }
}
</script>

<style lang="less" scoped>
.download,
.download:hover {
    width: 100px;
    height: 32px;
    line-height: 30px;
    color: #fff;
    float: left;
    background: #5cadff;
}
.marginBottom{
    margin-bottom: 10px;
}
</style>
