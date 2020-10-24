<!-- 具体需求信息 -->
<template>
    <Card :bordered="false">
        <p slot="title">具体需求信息</p>
        <div style="text-align:center">
            <Form ref="evalData" :model="evalData" :label-width="150" :rules="validate" class="clearfix">
                <Row :gutter="40">
                    <Col span="11">
                        <FormItem label="CPU核数(核)：" prop="cpuCount">
                            <Input v-model="evalData.cpuCount" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="CPU型号规格：" prop="cpuModel">
                            <Input v-model="evalData.cpuModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="内存大小(GB)：" prop="memorySize">
                            <Input v-model="evalData.memorySize" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="内存型号规格：" prop="memoryModel">
                            <Input v-model="evalData.memoryModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab' ></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="磁盘大小(GB)：" prop="diskSize">
                            <Input v-model="evalData.diskSize" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="磁盘型号规格：" prop="diskModel">
                            <Input v-model="evalData.diskModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="网卡数量(个)：" prop="netcardCount">
                            <Input v-model="evalData.netcardCount" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="网卡型号规格：" prop="netcardModel">
                            <Input v-model="evalData.netcardModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="交换机数量(个)：" prop="changeMachine">
                            <Input v-model="evalData.changeMachine" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="交换机型号规格：" prop="changeModel">
                            <Input v-model="evalData.changeModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="光模块数量(个)：" prop="lightCount">
                            <Input v-model="evalData.lightCount" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="模块型号规格：" prop="lightModel">
                            <Input v-model="evalData.lightModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="独显存储机数量(个)：" prop="videocardCount">
                            <Input v-model="evalData.videocardCount" :disabled='disab' :maxlength="8"></Input>
                        </FormItem>
                    </Col>
                    <Col span="11">
                        <FormItem label="独显型号规格：" prop="videocardModel">
                            <Input v-model="evalData.videocardModel" :maxlength="200" placeholder="限制输入200个字符以内" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                    <Col span="22">
                        <FormItem label="需求说明：" prop="remark">
                            <Input type="textarea" :maxlength="600" placeholder="限制输入600个字符以内" v-model="evalData.remark" :disabled='disab'></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
            <Row v-if="!disab" class="bottom-bar" style="text-align: center">
                <Col>
                    <Button type="default" @click="quit(-2)">取消</Button>
                    <Button type="primary" @click="goCreat()">上一步</Button>
                    <Button type="primary" @click="submit">提交</Button>
                </Col>
            </Row>
        </div>
    </Card>
</template>

<script>
import api from '@/api/axiosApi'
import softhardApiList from '@/api/softhardApiList'
export default {
    props: {
        disab: {
        type: Boolean,
        default:false
        }
    },
    data(){
        return{
            dialog:false,
            msg:'',
            evalData:{
                changeMachine: 0,
                changeModel: "",
                cpuCount: 0,
                cpuModel: "",
                diskModel: "",
                diskSize: 0,
                lightCount: 0,
                lightModel: "",
                memoryModel: "",
                memorySize: 0,
                netcardCount: 0,
                netcardModel: "",
                remark: "",
                videocardCount: 0,
                videocardModel: ""
            },
            validate: {
                cpuCount: [
                    {validator: (rule, value, cb) => {
                    let reg = /^\d+$/
                    if (!reg.test(this.evalData.cpuCount) || this.evalData.cpuCount > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}],
                memorySize: [
                    {validator: (rule, value, cb) => {
                    let reg = /^\d+$/
                    if (!reg.test(this.evalData.memorySize) || this.evalData.memorySize > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}],
                diskSize: [
                    {validator: (rule, value, cb) => {
                    let reg = /^\d+$/
                    if (!reg.test(this.evalData.diskSize) || this.evalData.diskSize > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}],
                netcardCount: [
                    {validator: (rule, value, cb) => {
                    let reg = /^\d+$/
                    if (!reg.test(this.evalData.netcardCount) || this.evalData.netcardCount > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}],
                changeMachine: [
                    {validator: (rule, value, cb) => {
                    let reg = /^\d+$/
                    if (!reg.test(this.evalData.changeMachine) || this.evalData.changeMachine > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}],
                lightCount: [
                    {validator: (rule, value, cb) => {
                    let reg = /^\d+$/
                    if (!reg.test(this.evalData.lightCount) || this.evalData.lightCount > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}],
                videocardCount: [
                    {validator: (rule, value, cb) => {
                        let reg = /^\d+$/
                    if (!reg.test(this.evalData.videocardCount) || this.evalData.videocardCount > 99999999) {
                        cb(new Error('请输入不超过八位数的正整数'))
                        return
                    }
                    cb()
                }}]
            }
        }
    },
    mounted(){
        console.log(this.$route.params.id)
        if(this.$route.params.id != 1){//1:新建,2:重新提交,3:修改,4:审批,5:处理,6:查看详情
            this.getApplyResByApplyId();
        }
        console.log(this.$route.params.departData);
    },
    methods:{
        getApplyResByApplyId() { // 根据ApplyId查询申请新增所需资源
            api(softhardApiList.getApplyResByApplyId, {
                "keyid": this.$route.params.departData.id
            }).then((res) => {
                if(res.status == 200 && res.data.data) {
                    this.evalData = res.data.data;
                }else{
                    this.evalData = {
                        changeMachine: 0,
                        changeModel: "",
                        cpuCount: 0,
                        cpuModel: "",
                        diskModel: "",
                        diskSize: 0,
                        lightCount: 0,
                        lightModel: "",
                        memoryModel: "",
                        memorySize: 0,
                        netcardCount: 0,
                        netcardModel: "",
                        remark: "",
                        videocardCount: 0,
                        videocardModel: ""
                    };
                }
            }, (err) => {
                //dong something...
            })
        },
        quit (n) {// 取消
            this.$router.go(n)
        },
        submit(){//提交
            let test = this.evalData.cpuCount + this.evalData.memorySize + this.evalData.diskSize + this.evalData.netcardCount + this.evalData.changeMachine + this.evalData.lightCount + this.evalData.videocardCount;
            if(!!test && typeof test != 'number'){
                if(this.dataDeal(this.evalData)){
                    api(softhardApiList.uYApplyReseSubmit,this.evalData).then((res) => {
                        if(res.data.errcode == 0){
                            this.$router.go(-2);
                        }else{
                            this.$Message.error(res.data.errmsg);
                        }
                    }, (err) => {
                        //dong something...
                    })
                }
            }else{
                this.$Message.error('请填写至少一个模块的数量，并且不能为0！');
            }
        },
        dataDeal(data){
            data.stepCode = 'YOUYI_HANDLER';//this.$route.params.departData.stepCode;假数据
            data.applyKeyid = this.$route.params.departData.id;
            if(data.changeMachine == 0 && data.cpuCount == 0 && data.diskSize == 0 && data.lightCount == 0 && data.memorySize == 0 && data.netcardCount == 0 && data.videocardCount == 0){
                this.$Message.error('不能全部为空');
                return false;
            }
            return true;
        },
        goCreat(){
            this.$router.push({//审批申请服务器
                name: 'applyCreate',
                params: {id: 5,departData:this.$route.params.departData}
            })
        },
    },
    components: {
    },
}
</script>
<style>
.download /deep/ .ivu-form-item-content{
    position: absolute;
    left:0;
}
</style>

