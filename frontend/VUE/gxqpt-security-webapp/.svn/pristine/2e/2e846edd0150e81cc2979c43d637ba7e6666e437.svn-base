<template>
    <Modal @on-visible-change="openPoint" v-model="evalModal" title="同意" width="20%" :closable='false' :mask-closable='false'>
        <div style="text-align:center">
            <Form ref="evalData" :model="evalData" :rules="ruleValidate" :label-width="70" class="clearfix">
                <Row :gutter="40">
                    <Col span="24">
                        <FormItem label="处理意见：" prop="advice">
                            <Input v-model="evalData.advice" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入建议..."></Input>
                        </FormItem>
                    </Col>
                    <Col span="13">
                        <FormItem label="培训人" prop="trainMan">
                            <Select v-model="evalData.trainMan">
                                <Option value="王二">王二</Option>
                                <Option value="张三">张三</Option>
                                <Option value="李四">李四</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="协助人" prop="assistant">
                            <Select v-model="evalData.assistant" multiple>
                                <Option value="王二">王二</Option>
                                <Option value="张三">张三</Option>
                                <Option value="李四">李四</Option>
                            </Select>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
        </div>
        <div slot="footer">
            <Button class="modalBtn" type="primary" @click="handleSubmit" size="large">确定</Button>
            <Button class="modalBtn" type="default" @click="closeModal" size="large">取消</Button>
        </div>
    </Modal>
</template>

<script>
export default {
    data(){
        return{
            evalData: {
                dealMan: '',
                assistant: [],
                advice:''
            },
            ruleValidate: {
            }
        }
    },
    props:{
        evalModal:{
            type: Boolean,
            default: false
        },
        closeModal: Function,
    },
    methods:{
        openPoint(status) {
            if(!status){
                this.$refs['evalData'].resetFields();
            }
        },
        handleSubmit() {
            this.$refs['evalData'].validate((valid) => {
                if(valid) {
                    this.save();
                } else {
                    this.$Message.error('表单验证失败!');
                }
            })
        },
    }
}
</script>

<style scoped>
.ivu-input-wrapper >>> textarea{
    resize: none;
}
</style>
