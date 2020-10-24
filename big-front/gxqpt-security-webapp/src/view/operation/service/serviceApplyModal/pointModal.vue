<template>
    <Modal v-model="showModal" title="服务评价" width="30%" :closable='false' :mask-closable='false'>
        <div style="text-align:center">
            <Form ref="formData" :model="formData" :label-width="80" class="clearfix">
                <Row :gutter="40">
                    <Col span="24">
                        <FormItem label="服务态度">
                            <hy-rate :sglValue="20" show-text v-model="formData.serviceAttitude" style="float: left;">
                                <span style="color: #f5a623">{{formData.serviceAttitude}}</span>
                            </hy-rate>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="服务效率">
                            <hy-rate :sglValue="20" show-text v-model="formData.serviceEfficiency" style="float: left;">
                                <span style="color: #f5a623">{{formData.serviceEfficiency}}</span>
                            </hy-rate>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="服务质量">
                            <hy-rate :sglValue="20" show-text v-model="formData.serviceEvaluation" style="float: left;">
                                <span style="color: #f5a623">{{formData.serviceEvaluation}}</span>
                            </hy-rate>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="服务建议" prop="advice">
                            <Input v-model="formData.serviceAdvice" type="textarea" :autosize="{minRows: 5,maxRows: 5}" :maxlength="1000" placeholder="请输入建议..."></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
        </div>
        <div slot="footer">
            <Button class="modalBtn" type="primary" @click="handleSubmit" size="large">提交</Button>
            <Button class="modalBtn" type="default" @click="showModal = false" size="large">取消</Button>
        </div>
    </Modal>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
export default {
    data(){
        return{
            showModal: false,
            formData: {
                serviceAttitude: 80,
                serviceEfficiency: 80,
                serviceEvaluation: 80
            },
            id: ''
        }
    },
    methods:{
        handleSubmit() {
            const vm = this
            api(operationApiList.updateServiceEvaluation, {
                id: vm.id,
                score: Math.floor((vm.formData.serviceAttitude + vm.formData.serviceEfficiency + vm.formData.serviceEvaluation) / 3),
                ...vm.formData
            }).then(res => {
                if(res.data.errcode === 0) {
                    vm.$Message.success('评分成功！！！')
                    vm.showModal = false
                    vm.$emit('on-ok')
                }
            }, error => { console.log(error) })
        },
        open(id, rate) {
            this.$refs['formData'].resetFields()
            this.id = id
            this.formData.serviceAttitude = Number(rate.serviceAttitude) || 80
            this.formData.serviceEfficiency = Number(rate.serviceEfficiency) || 80
            this.formData.serviceEvaluation = Number(rate.serviceEvaluation) || 80
            this.showModal = true
        }
    }
}
</script>

<style scoped>
.ivu-input-wrapper >>> textarea{
    resize: none;
}
</style>
