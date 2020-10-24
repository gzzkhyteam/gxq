<template>
    <div class="container">
        <top-bar style="z-index:10000" :title="title" fixedTrue></top-bar>
        <mu-list style="padding-top:50px;">
            <inputModel name="申报人" :icon="!icon" :req="!icon" :content="userName"></inputModel>
            <mu-list-item button :ripple="false" :z-depth="2">
                <mu-list-item-title><img src="../../assets/reqIcon.png">开始时间</mu-list-item-title>
                <div class="mu-item-action" @click="getNowTime(1)">
                    <mu-date-input v-model="begTime" class="dateClass" container="bottomSheet" actions solo type="dateTime"></mu-date-input>
                    <mu-list-item-after-text v-if="!begTime">请选择</mu-list-item-after-text>
                    <i v-if="!begTime" class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_right</i>
                </div>
            </mu-list-item>
            <mu-list-item button :ripple="false" :z-depth="2">
                <mu-list-item-title><img src="../../assets/reqIcon.png">结束时间</mu-list-item-title>
                <div class="mu-item-action" @click="getNowTime(2)">
                    <mu-date-input v-model="endTime" class="dateClass" container="bottomSheet" actions solo type="dateTime"></mu-date-input>
                    <mu-list-item-after-text v-if="!endTime">请选择</mu-list-item-after-text>
                    <i v-if="!endTime" class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_right</i>
                </div>
            </mu-list-item>
            <inputModel v-if="dateLength" name="总时长" :icon="!icon" :req="!icon" :content="dateLength"></inputModel>
            <inputModel @test='getContent' name="外出描述" :clear="clear" :icon="!icon" :req='false' textare></inputModel>
            <div class="mu-item">
                <examination backUrl='FieldForm' :chance="chanceApproval"></examination>
            </div>
            <div class="mu-item">
                <Approver backUrl='FieldForm' :chance="chance" :req='false'></Approver>
            </div>
            <div class="mu-item">
                <Upload style="width: 100%;" :clear='clear' :imgArr="imgFile" :action="url" :onSuccess="UploadSuccess" :onError="UploadError"></Upload>
            </div>
        </mu-list>
        <mu-flex justify-content="center" align-items="center" style="margin:0 10px 20px 10px;">
            <mu-button full-width color="primary" @click="createApprApply" style="font-size:1rem;">提交</mu-button>
        </mu-flex>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </div>
</template>
<script>
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import topBar from '@/components/topBar';
import inputModel from '@/components/inputModel/inputModel'
import autoTextarea from '@/components/autoTextarea/autoTextarea'
import Approver from '@/components/approver/approver'
import examination from '@/components/examination/examination'
import Upload from '@/components/HY/Upload'
import eventBus from '@/public/eventBus.js';
import { validation } from '@/public/validation.js';
import { mapMutations } from 'vuex'
var root = process.env.API_ROOT;
export default {
    data () {
        return{
            title:"外勤申报",
            icon:true,
            begTime:null,
            endTime:null,
            dateLength:'',
            content:'',
            workDesName:'请输入',
            chanceApproval:[],
            chance:[],
            imgFile:[],
            url:root+ApiList.fileUpload.url,
            dialog:false,
            msg:'',
            clear:false,
            userName:this.$store.state.userInfo.userName
        }
    },
    watch:{
        "begTime":"countDateLength",
        "endTime":"countDateLength",
        '$route'(to,from) {
            if(from.name == 'MyAttendance'){
                this.clear =true;
            }else{
                this.clear =false;
            }
        },
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        this.getHistoryData();
    },
    activated(){
        this.$store.dispatch('closeLoading', false);
        //根据key名获取传递回来的参数，data就是map
        eventBus.$on('chance', function(data){//抄送人回调
            var chanceItem = JSON.parse(data);
            (!!this.chance) ? this.chance = this.arrConcat(this.chance,chanceItem) : this.chance = chanceItem;
            this.chance = JSON.parse(JSON.stringify(this.chance).replace(/userId/g,"gxqptEmpId"));
        }.bind(this));
        eventBus.$on('chanceApproval', function(data){//审批人回调
            var chanceItem = JSON.parse(data);
            (!!this.chanceApproval) ? this.chanceApproval = this.arrConcat(this.chanceApproval,chanceItem) : this.chanceApproval = chanceItem;
            this.chanceApproval = JSON.parse(JSON.stringify(this.chanceApproval).replace(/userId/g,"gxqptEmpId"));
        }.bind(this));
        if(this.clear){//清空其他值
            this.begTime = null;
            this.endTime = null;
            this.$store.state.applyData.description = '';
            this.chanceApproval = [];
            this.imgFile = [];
            this.chance = [];
            this.dateLength = '';
            this.getHistoryData();//获取历史抄送人和审批人
        }
    },
    methods:{
        getContent(val){//获取输入描述内容
            this.$store.state.applyData.description = val;
        },
        countDateLength(){
            if(!!this.begTime && !!this.endTime){
                if(this.endTime.getDate() != this.begTime.getDate()){
                    this.msg = "外勤申报时间不能跨天，请重新选择！";
                    this.dialog = true;
                    return;
                }
                if(this.endTime.getTime() < this.begTime.getTime()){
                    this.begTime = null;
                    this.endTime = null;
                    this.msg = "结束时间不能在开始时间前，请重新选择！";
                    this.dialog = true;
                    return;
                }
                this.dateLength = (parseInt(this.endTime.getTime() - this.begTime.getTime()) /1000 / 3600).toFixed(2) + '小时';
                let num = this.dateLength.charAt(this.dateLength.length-3);
                if(parseInt(num)==9){//判断是否是99
                    this.dateLength = parseFloat(this.dateLength).toFixed(0) + '.00小时'
                }
            }
        },
        createApprApply(){
            if(this.validate()){
                this.count();
                api(ApiList.createApprApply,this.$store.state.applyData)
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.msg = "添加成功";
                        this.dialog = true;
                        this.$router.replace('/');
                    }else{
                        this.msg = res.data.errmsg;
                        this.dialog = true;
                    }
                },(error)=>{})
            }   
        },
        count(){
            this.$store.state.applyData.aprType = "outside";
            this.$store.state.applyData.startTime = this.dateCrt(this.begTime);//赋值开始时间
            this.$store.state.applyData.endTime = this.dateCrt(this.endTime);//赋值结束时间
            let arr1 = [], arr2 = [];
            for(var i in this.chanceApproval){
                arr1.push({
                    "apprUserId":this.chanceApproval[i].gxqptEmpId,
                    "apprUserIndex": parseInt(i),
                    "apprUserName": this.chanceApproval[i].name,
                    "userType": 1
                })
            }
            for(var i in this.chance){
                arr2.push({
                    "apprUserId":this.chance[i].gxqptEmpId,
                    "apprUserIndex": 0,
                    "apprUserName": this.chance[i].name,
                    "userType": 2
                })
            }
            this.$store.state.applyData.apprPersons = [...arr1];
            this.$store.state.applyData.sendPersons = [...arr2];
        },
        validate(){//校验表单
            if(this.begTime == null){
                this.msg = "请选择开始时间！";
                this.dialog = true;
                return false;
            }else if(this.endTime == null){
                this.msg = "请选择结束时间！";
                this.dialog = true;
                return false;
            }else if(parseFloat(this.dateLength) > 24){
                this.msg = "外勤时间不能跨天，请重新选择后提交！";
                this.dialog = true;
                return false;
            }else if(this.chanceApproval.length == 0){
                this.msg = "审批人不能为空！";
                this.dialog = true;
                return false;
            }else if(parseFloat(this.dateLength) == 0){
                this.msg = "时长不能为0！";
                this.dialog = true;
                return false;
            }else{
                return true;
            }
        },
        getNowTime(type){
            let date = new Date();
            let now = this.dateCrt(date);
            (type==1)? this.begTime = this.begTime || now : this.endTime = this.endTime || now;
        },
        UploadSuccess(res){
            this.imgFile=res;
            this.$store.state.applyData.images = JSON.parse(JSON.stringify(res).replace(/id/g,"fileId"));
        },
        UploadError(res){
            this.msg = res.errmsg;
            this.dialog = true;
        },
        getHistoryData(){
            api(ApiList.getDefaultPerson,{aprType:"outside"})
            .then((res)=>{
                if(res.data.errcode==0){
                    if(res.data.data != null){
                        this.chance = JSON.parse(JSON.stringify(res.data.data.sendPersons).replace(/apprUserName/g,"name"));
                        this.chance = JSON.parse(JSON.stringify(this.chance).replace(/apprUserId/g,"gxqptEmpId"));
                        this.chanceApproval = JSON.parse(JSON.stringify(res.data.data.apprPersons).replace(/apprUserName/g,"name"));
                        this.chanceApproval = JSON.parse(JSON.stringify(this.chanceApproval).replace(/apprUserId/g,"gxqptEmpId"));
                    }
                }
            },(error)=>{  
            }) 
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
        closeDialog(){
            this.dialog = false;
        },
        dateCrt(date) {//时间格式化
            if(!!date){
                let fmt = "yyyy-MM-dd hh:mm";
                var date = new Date(date);
                var o = {
                    "M+": date.getMonth() + 1,                 //月份   
                    "d+": date.getDate(),                    //日   
                    "h+": date.getHours(),                   //小时   
                    "m+": date.getMinutes(),                 //分   
                };
                if (/(y+)/.test(fmt)){
                    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                for (var k in o){
                    if (new RegExp("(" + k + ")").test(fmt)){
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                fmt = fmt + ":00";//秒数补零
                return fmt;
            }
        },
        ...mapMutations([
            'setMsg',
        ])
    },
    components: {
        topBar,
        inputModel,
        autoTextarea,
        Approver,
        examination,
        Upload
    }
}
</script>
<style lang="less" scoped>
.container{
    padding:0;
    height:100%;
    background: #fafafa;
    .mu-item-title{
        position: relative;
        padding: 0 0.8rem;
        img{
            position: absolute;
            left:0;
            width:0.5rem;
            height:0.5rem;
        }
    }
}
.mu-list{
    padding: 8px 0 30px 0;
    width: 100%;
    position: relative;
    overflow-x: hidden;
    overflow-y: visible;
    margin:0;
    li{
        margin:1rem 0;
        background: #fff;
        border-top: 1px solid #eee;
        border-bottom: 1px solid #eee;
    }
    .mu-item    {
        height:auto;
        min-height:48px;
        background: #fff;
        padding:0;
    }
    .mu-item-title{
        font-size:1rem;
    }
    .mu-item-action{
        width:110px;
        min-width:110px;
        position:relative;
        line-height: 32px;
        .mu-item-after-text{
            font-size:1rem;
        }
    }
}
.mu-divider{
    width:95%;
    margin:0 2.5%;
}
.mu-dialog-body{
    padding:0;
}
// 自定义模板样式
.mu-dialog-cus-list{
    border:none;
    margin:0;
    padding:0;
    border-radius:10px;
    .mu-dialog-cus-item{
        border-bottom: 1px solid rgb(204, 204, 204); 
        height: 50px;
        .mu-dialog-cus-item-title{
            height:30px;
            line-height:30px;
            color: #2196f3;
            font-weight:bold;
            text-align:center;
        }
    }
}
.mu-overlay-cus{
    opacity: 0.4;
    background-color: rgb(0, 0, 0);
    position: fixed;
    z-index: 100000;
}
.dateClass{
    width:200px;
    left: -1rem;
    position: absolute;
}
</style>


