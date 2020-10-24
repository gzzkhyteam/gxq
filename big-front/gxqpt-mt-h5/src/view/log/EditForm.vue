<template>
    <div class="container">
        <top-bar style="z-index:10000" :title="title"></top-bar>
        <form  class="mu-form mu-demo-form">
            <div class="mu-form-item mu-form-item__float-label mu-form-item__has-label">
                <autoTextarea :readonly='(logType==1)?false:true' v-model="workDes" :placeholder="inputP" :floatName="workDesName" lineHeight="30px" border="false" fontSize="18px" :montHeight="montHeight" :value="workDesName" />
            </div>
            <div class="mu-form-item mu-form-item__float-label mu-form-item__has-label">
                <Upload :imgArr="file" :action="url" :onSuccess="UploadSuccess" :onError="UploadError"></Upload>
            </div>
            <div class="mu-form-item mu-form-item__float-label mu-form-item__has-label">
                <Approver :chance="chance" :backUrl='backUrl'></Approver>
            </div>
            <mu-flex justify-content="center" align-items="center" style="margin:0 10px 20px 10px;">
                <mu-button full-width color="primary" @click="saveLog" style="font-size:1rem;">提交</mu-button>
            </mu-flex>
        </form> 
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </div>
</template>
<script>
import topBar from '@/components/topBar';
import autoTextarea from '@/components/autoTextarea/autoTextarea'
import Upload from '@/components/HY/Upload'
import Approver from '@/components/approver/approver'
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'

var root = process.env.API_ROOT;
export default {
    data () {
        return{
            title:"写日志",
            inputP:'',
            workDesName:'工作描述',
            type:1,
            logType:0,
            dialog:false,
            montHeight:"100px",
            logData:{},
            backUrl:'editForm',
            file:[],
            chance:[],
            addPeo:true,
            id:Number,
            msg:'',
            workDes:'',
            url:root+ApiList.fileUpload.url
        }
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        this.getHistoryData();
    },
    activated(){
        this.$store.dispatch('closeLoading', false);
        if(!!this.$route.params.log){//判断是否是编辑日志状态
            this.addPeo = false;
            var log = JSON.parse(this.$route.params.log);
            this.workDes = log.description;
            if(this.workDes.length>40)this.montHeight=30*(this.workDes.length/15)+'px';
            this.workDesName = '';
            this.logData.id = log.id;
            this.logData.logId = log.logId;
            this.type=2;
            this.logType=log.type;//日志类型
            console.log(log);
            this.file = log.workLogFileDTOS;
        }else if(!!this.$route.params.chance){//判断是否是选择抄送人回调状态
            // this.chance=[];
            var chanceItem = JSON.parse(this.$route.params.chance);
            (!!this.chance) ? this.chance = this.arrConcat(this.chance,chanceItem) : this.chance = chanceItem;
            this.chance = JSON.parse(JSON.stringify(this.chance).replace(/userId/g,"gxqptEmpId"));
            // this.logData.userIds.push(this.chance[i].id)
        }else{

        }
    },
    beforeRouteLeave(to, from, next) {
        // 设置下一个路由meta
        // if(to.name == "index"){
        //     from.meta.keepAlive = false; 
        // }
        // if(to.name == "logDetail")from.meta.keepAlive = false;
        console.log(from);
        console.log(to);
        if((to.name == 'getTreeEmpPhoneByUserId'  && from.name=='logForm') || (to.name == 'getTreeEmpPhoneByUserIdItem'  && from.name=='logForm')){
            console.log("修改返回地址");
            to.name == 'index';//判断选项回弹
        }
        console.log(to);
        next()
    },
    methods:{
        closeDialog(){
            this.dialog = false;
        },
        UploadSuccess(res){
            this.file=res;
        },
        UploadError(res){
            this.msg = res.errmsg;
            this.dialog = true;
        },
        saveLog(){
            this.logData.userIds=[];
            this.logData.description = this.workDes;
            var saveUrl = ApiList.logSave;//根据类型判断新增还是修改
            if(this.type==2){
                saveUrl = ApiList.logEdit;
                this.logData.workLogFileDTOS = this.file;
            }else{
                this.logData.files = this.file;
            }
            for(var i=0;i<this.chance.length;i++){
                this.logData.userIds.push(this.chance[i].gxqptEmpId);
            }
            if(this.auditData(this.logData)){
                api(saveUrl,this.logData)  
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.msg = "修改成功";
                        this.dialog = true;
                        this.$router.replace('/');
                    }
                },(error)=>{  
                }) 
            }
        },
        getHistoryData(){
            api(ApiList.getAuthorityList)
            .then((res)=>{
                if(res.data.errcode==0){
                    this.chance = JSON.parse(JSON.stringify(res.data.data).replace(/userId/g,"gxqptEmpId"));
                }
            },(error)=>{  
            }) 
        },
        auditData(data){
            if(data.description==""){
                this.msg="描述不能为空，请输入后重试提交！";
                this.dialog = true;
                return false;
            }
            else if(Array.isArray(data.userIds) && data.userIds.length === 0){
                this.msg="请选择至少一个审批人！";
                this.dialog = true;
                return false;
            }else{
                return true;
            }
        },
        arrConcat(arr1,arr2){//数组去重
            let arr = {};
            for(var i=0;i<arr1.length;i++){
                arr[arr1[i].gxqptEmpId]=true;
            }
            for (var i = 0; i < arr2.length; i++) {
                if(!arr[arr2[i].gxqptEmpId]){
                    arr1.push(arr2[i]);
                }
            }; 
            return arr1;  
        },
    },
    components: {
        autoTextarea,
        Upload,
        topBar,
        Approver,
        ApiList
    }
}
</script>
<style lang="less" scoped>
.container{
    padding:0;
    height:100%;
    background: #fafafa;
    .mu-form{
        padding-bottom:2rem;
        overflow: hidden;
    }
}
.mu-form-item{
    background: #fff;
    padding-top: 10px;
}
.appbarRight{
    position: relative;
    right:6rem;
}
</style>


