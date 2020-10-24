<template>
    <Modal @on-visible-change="openModal" v-model="evalModal" title="处理" width="20%"  :closable='false' :mask-closable='false'>
        <div style="text-align:center;padding:15px;">
            <Row :gutter="40">
                <Col span="24">
                    <RadioGroup v-model="radioChange" @on-change="changeModal(radioChange)">
                        <Radio label="同意"></Radio>
                        <Radio label="驳回"></Radio>
                    </RadioGroup>
                </Col>
            </Row>
        </div>
        <div style="text-align:center">
            <Form v-if="changeT" ref="evalData" :model="evalData" :rules="ruleValidate" :label-width="70" class="clearfix">
                <Row :gutter="40">
                    <Col span="24">
                        <FormItem label="处理意见：" prop="advice">
                            <Input v-model="evalData.advice" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="请输入建议..."></Input>
                        </FormItem>
                    </Col>
                    <Col span="13">
                        <FormItem label="处理人" prop="dealMan">
                            <Select v-model="evalData.dealMan">
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
            <Form v-if="!changeT" ref="evalData" :model="evalData" :rules="ruleValidate" :label-width="70" class="clearfix">
                <Row :gutter="40">
                    <Col span="24">
                        <FormItem label="驳回理由：" prop="advice">
                            <Input v-model="evalData.advice" type="textarea" :autosize="{minRows: 5,maxRows: 8}" placeholder="请输入建议..."></Input>
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
            radioChange:'同意',
            changeT:true,
            evalData: {
                safetyLevel: '3',
            },
            ruleValidate: {
                results: [{
                    required: true,
                    message: '处理意见不可以为空',
                }]
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
        openModal(status) {
            if(!status){
                // this.$refs['evalData'].resetFields();
            }
        },
        handleSubmit() {
            console.log("验证表单");
            this.$refs['evalData'].validate((valid) => {
                if(valid) {
                    this.save();
                } else {
                    this.$Message.error('表单验证失败!');
                }
            })
        },
        changeModal(radioChange){
            console.log(radioChange);
            (radioChange=='同意') ? this.changeT=true : this.changeT=false
        },
    }
}
</script>

<style lang="less" scoped>
.modalBtn{
    margin:0 20px;
}
.ivu-form-item  /deep/ .ivu-form-item-content{
    height:auto;
}
.ivu-input-wrapper /deep/ textarea{
    resize: none;
}
</style>
