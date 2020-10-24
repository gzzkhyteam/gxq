<template>
    <mu-container>
        <div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box" style="position:fixed">
            <div class="mu-appbar-left">
                <a @click="goback" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
                    <div class="mu-button-wrapper">
                        <div class="mu-ripple-wrapper"></div> 
                        <i class=" mu-icon  material-icons  " style="user-select: none;">keyboard_arrow_left</i>
                        返回
                    </div>
                </a>
            </div> 
            <div class="mu-appbar-title" :class="{ appbarRight : reviewDetail.applyId!=''}">
                <div class="mu-appbar-title">{{title}}</div> 
            </div>
            <!-- <mu-button v-if="reviewDetail.applyId==''" flat slot="right" @click="undo" style="font-size:1rem">
                撤销
            </mu-button> -->
        </div>
		<!-- <top-bar style="z-index:10000" :title="title"></top-bar> -->
        <mu-list style="padding-top:54px;">
            <div class="reviewItem">
                <div class="re-title">{{aprTypeMap[reviewDetail.aprType]}}人</div>
                <div class="re-content">{{reviewDetail.applyName}}</div>
            </div>
            <div class="reviewItem">
                <div class="re-title">申请时间</div>
                <div class="re-content">{{reviewDetail.createTime}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.aprType!='supply'">
                <div class="re-title">开始时间</div>
                <div class="re-content">{{reviewDetail.startTime}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.aprType!='supply'">
                <div class="re-title">结束时间</div>
                <div class="re-content">{{reviewDetail.endTime}}</div>
            </div>
            <div class="reviewItem" v-else>
                <div class="re-title">补签时间</div>
                <div class="re-content">{{reviewDetail.date}}</div>
            </div>
            <div class="reviewItem">
                <div class="re-title">审批类型</div>
                <div class="re-content">{{aprTypeMap[reviewDetail.aprType]}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.aprType=='supply' || reviewDetail.aprType=='business' || reviewDetail.aprType=='leave'">
                <div class="re-title">{{aprTypeMap[reviewDetail.aprType]}}类型</div>
                <div class="re-content" v-if="reviewDetail.aprType=='supply'">{{ supplyName }}</div>
                <div class="re-content" v-else-if="reviewDetail.aprType=='leave'">{{leaveName}}</div>
                <div class="re-content" v-else>{{businessName}}</div>
            </div>
            <div class="reviewItem">
                <div class="re-title" v-if='!reviewDetail.canceReasonl'>{{aprTypeMap[reviewDetail.aprType]}}原因</div>
                <div class="re-title" v-else>撤销{{aprTypeMap[reviewDetail.aprType]}}原因</div>
                <div class="re-content">{{reviewDetail.content}}</div>
            </div>
            <div class="reviewItem" v-if="!!reviewDetail.canceReasonl">
                <div class="re-title">撤销理由</div>
                <div class="re-content">{{reviewDetail.canceReasonl}}</div>
            </div>
            <div class="reviewItem">
                <div class="re-title">抄送人员</div>
                <div class="re-content">
                    <div class="contentItem" v-for="(item,idx) in reviewDetail.sendPersons" :key="idx">
                        <div class="itemText">{{item.apprUserName}}</div>
                    </div>
                </div>
            </div>
            <div class="reviewItem">
                <div class="re-title">审批记录</div>
                <div class="re-content">
                    <div class="contentItem" v-if="item.agree!=null" v-for="(item,idx) in reviewDetail.applyRecodes" :key="idx">
                        <div class="itemText">{{item.apprUserName}} {{agreeList[item.agree]}} {{item.apprTime}}</div>
                        <div class="itemText" style="color:#a7a7a7">{{item.apprOpinion}}</div>
                    </div>
                </div>
            </div>
            <div class="reviewItem">
                <div class="re-title">附件</div>
                <!-- <div class="re-content"><textarea style="height:30px;" ref="vTextarea" placeholder="审批意见" v-model="temp_value"  class="auto-textarea-input mu-text-field-input"></textarea></div> -->
                <div class="re-content">
                    <div class="contentItem" v-for="(item,idx) in reviewDetail.files" :key="idx">
                        <div class="itemImg" v-if="item.fileType.indexOf('image')>-1" @click="lookImg(item.fileUrl)">
                            <img :src="item.fileUrl">
                            <!-- <span>{{item.fileName}}</span> -->
                        </div>
                        <div class="itemImg" v-else>
                            <span>{{item.fileName}}</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="reviewItem" v-if="disabled">
                <div class="re-title">是否同意</div>
                <div class="re-content">
                    <mu-switch :disabled="!disabled" v-model="agreed"></mu-switch>
                </div>
            </div>
            <div class="reviewItem" v-if="disabled">
                <div class="re-title">审批意见</div>
                <div class="re-content">
                    <textarea style="height:30px;" :disabled="!disabled" ref="vTextarea" placeholder="审批意见" v-model="apprOpinion"  class="auto-textarea-input mu-text-field-input"></textarea>
                </div>
            </div>
        </mu-list>
        <mu-flex justify-content="center" align-items="center" style="margin:0 10px 20px 10px;" v-if="disabled">
            <mu-button full-width color="primary" @click="deal" style="font-size:1rem;">提交</mu-button>
        </mu-flex>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
        <mu-dialog width="360" transition="fade" fullscreen :open.sync="openFullscreen" style="background:#000;">
            <div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box">
                <div class="mu-appbar-left">
                    <a @click="closeFullscreen" class="mu-button mu-flat-button" style="font-size: 1rem;" tabindex="0">
                        <div class="mu-button-wrapper">
                            <i class=" mu-icon  material-icons  " style="user-select: none;">close</i>
                        </div>
                    </a>
                </div> 
                <div class="mu-appbar-title appbarRight">
                    <div class="mu-appbar-title">图片详情</div> 
                </div>
            </div>
            <img style="width:90%;margin:30% 5%;" :src="screenImg">
        </mu-dialog>
    </mu-container>
</template>

<script>
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import topBar from '@/components/topBar';
import autosize from 'autosize'
import FixeData from '@/public/leave' //请假类型

export default {
    data(){
        return {
            title:'审批详情',
            agreed:false,
            form: {
                switch: false,
            },
            openFullscreen:false,
            screenImg:'',
            apprOpinion:'',
            disabled:!this.$route.params.type,
            agreeList:{"0":"同意","1":"不同意"},
            aprTypeMap:{'overtime':'加班','leave':'请假','business':'出差','outside':'外勤','supply':'补签'},
            entourageTypes:[{name:"公务出差",type:"official"},{name:"外出培训",type:"train"},],//出差类型
            supplyTypes:[{name:"签到",type:"1"},{name:"签退",type:"2"},],//补签类型
            log:JSON.parse(this.$route.params.log),
            reviewDetail:{},
            msg:"",
            dialog:false
        }
    },
    mounted () {
        this.$store.dispatch('closeLoading', false);
        const textareas = this.$refs.vTextarea;
        autosize(textareas);
        this.getApprApplyInfo();
    },
    methods:{
        goback() {
            this.$store.dispatch('openLoading')
            this.$router.go(-1);
        },
        getApprApplyInfo(){
            api(ApiList.getApprApplyInfo,{id:JSON.parse(this.$route.params.log).id})
            .then((res)=>{
                if(res.data.errcode==0){
                    this.reviewDetail = res.data.data
                }else{
                    this.msg = res.data.errmsg;
                    this.dialog = true;
                }
            },(error)=>{})
        },
        lookImg(url){//图片放大
            this.screenImg = url;
            this.openFullscreen = true;
        },
        closeFullscreen(){
            this.openFullscreen = false;
        },
        deal(){
            if(this.apprOpinion){
                let data = {
                    id:JSON.parse(this.$route.params.log).id,
                    agree:(this.agreed) ? 0 : 1,
                    apprOpinion:this.apprOpinion
                }
                api(ApiList.dealApprApply,data)
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.msg = "处理成功";
                        this.dialog = true;
                        this.$store.dispatch('openLoading')
                        this.$router.go(-1);
                    }else{
                        this.msg = res.data.errmsg;
                        this.dialog = true;
                    }
                },(error)=>{})
            }else{
                this.msg = '请输入审批原因！';
                this.dialog = true;
            }
        },
        undo(){
            if(this.reviewDetail.applyId!=''){
                api(ApiList.dealApprApply,data)
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.msg = "处理成功";
                        this.dialog = true;
                        this.$store.dispatch('openLoading')
                        this.$router.go(-1);
                    }else{
                        this.msg = res.data.errmsg;
                        this.dialog = true;
                    }
                },(error)=>{})
            }
        },
        closeDialog(){
            this.dialog = false;
        }
    },
    computed:{
        supplyName:function () {
            let name = '';
            this.supplyTypes.forEach(item => {
                if(item.type==this.reviewDetail.supplyType){
                    name = item.name
                }
            });
            return name
        },
        businessName:function () {
            let name = '';
            this.entourageTypes.forEach(item => {
                if(item.type==this.reviewDetail.businessType){
                    name = item.name
                }
            });
            return name
        },
        leaveName:function () {
            let name = '';
            for(let i in FixeData){
                if(FixeData[i].type==this.reviewDetail.leaveType){
                    name = FixeData[i].name
                }
            }
            return name
        }
    },
    components:{
        topBar
    }
}
</script>

<style lang="less" scoped>
.container{
    padding:0;
    height:100%;
    background:#e6e6e6;
    .reviewItem{
        padding:0 16px;
        background: #fff;
        border-bottom:1px solid #ccc;
        width:100%;
        min-height: 60px;
        height:auto;
        font-size:1rem;
        line-height: 60px;
        text-align: left;
        overflow: hidden;
        .re-title{
            width:30%;
            min-height: 60px;
            height:auto;
            color:#a7a7a7;
            float: left;
        }
        .re-content{
            width:70%;
            min-height: 60px;
            height:auto;
            color:#5b5b5b;
            float: left;
            .auto-textarea-input{
                font-family: Menlo, "Ubuntu Mono", Consolas, "Courier New", "Microsoft Yahei", "Hiragino Sans GB", "WenQuanYi Micro Hei", sans-serif;
                width: 100%;
                height: 100%;
                font-size:1rem;
                top: 0;
                left: 0;
                margin: 0;
                padding: 0;
                overflow-y: hidden;
                color: #2C3E50;
                resize:none;
                text-align: left;
            }
        }
    }
    .contentItem{
        margin-top:1rem;
    }
    .itemText{
        font-size: 14px;
        min-height: 30px;
        line-height: 20px;
        padding-bottom: 1rem;
        height: auto;
    }
    .itemImg{
        width: 30%;
        padding-bottom: 1rem;
        line-height: 20px;
        img{
            width:100%;
        }
        span{
            font-size:12px;
            line-height: 13px;
        }
    }
}
.mu-appbar{
    /* position: fixed; */
    top: -2px;
    left: 0;
    z-index: 1000;
    width:100%;
}
.mu-primary-color{
    background-color: #38ADFF;
}
.mu-appbar-title{
    width: 100%;
    font-size: 1rem;
    text-align: center;
}
.mu-button-wrapper{
    font-size: 1rem;
    color: #fff;
}
.mu-icon-button{
    /*padding:0;
    width: 80px;*/
}
.appbarRight{
    margin-right: 6rem;
}
</style>
