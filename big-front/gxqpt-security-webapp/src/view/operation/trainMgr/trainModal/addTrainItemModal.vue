<template>
    <Modal @on-visible-change="openModal" v-model="evalModal" title="新增培训" width="40%" :closable='false' :mask-closable='false'>
        <div style="text-align:center">
            <Form ref="evalData" :model="evalData" :rules="ruleValidate" :label-width="90" class="clearfix">
                <Row :gutter="40">
                    <Col span="13">
                        <FormItem label="培训类别" prop="results">
                            <Select v-model="evalData.type">
                                <Option value="类别1">类别1</Option>
                                <Option value="类别2">类别2</Option>
                            </Select>
                        </FormItem>
                    </Col>
                    <Col span="13">
                        <FormItem label="培训名称" prop="name">
                            <Input v-model="evalData.name"></Input>
                        </FormItem>
                    </Col>
                    <Col span="13">
                        <FormItem label="培训地点" prop="address">
                            <Input v-model="evalData.address"></Input>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="培训开始时间" prop="beginDate">
                            <DatePicker type="daterange" v-model="evalData.beginDate" placement="bottom-end" placeholder="请选择培训开始时间" style="float: left"></DatePicker>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="培训内容" label-position="left" prop="content">
                            <Input v-model="evalData.content" type="textarea" :autosize="{minRows: 2,maxRows: 5}"></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
        </div>
        <div slot="footer">
            <Button type="primary" @click="handleSubmit" size="large">确定</Button>
            <Button type="default" @click="closeModal" size="large">取消</Button>
        </div>
    </Modal>
</template>

<script>
export default {
    data(){
        return{
            evalData: {
            },
            ruleValidate: {//表单验证
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
                this.$refs['evalData'].resetFields();
            }
        },
        handleSubmit() {//验证并新建/修改内容
            this.$refs['evalData'].validate((valid) => {
                if(valid) {
                    this.save();
                } else {
                    this.$Message.error('表单验证失败!');
                }
            })
        },
        validForm() {
            this.$refs['evalData'].validate();
        },
    }
}
</script>

<style scoped>
.ivu-form-item >>> .ivu-form-item-content{
    height:auto;
}
.ivu-input-wrapper >>> textarea{
    resize: none;
}
</style>
