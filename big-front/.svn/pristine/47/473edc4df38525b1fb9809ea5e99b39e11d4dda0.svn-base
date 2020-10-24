<template>
    <mu-container>
        <div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box" style="position:fixed">
            <div class="mu-appbar-left">
                <a @click="goback" class="mu-button mu-flat-button" style="font-size: 1rem;" tabindex="0">
                    <div class="mu-button-wrapper">
                        <div class="mu-ripple-wrapper"></div> 
                        <i class=" mu-icon  material-icons  " style="user-select: none;">keyboard_arrow_left</i>
                        返回
                    </div>
                </a>
            </div> 
            <div class="mu-appbar-title" :class="{ appbarRight : (reviewDetail.curState != 1 || reviewDetail.curState != 3)}">
                <div class="mu-appbar-title">{{title}}</div> 
            </div>
            <mu-button v-if="reviewDetail.curState == 1 || reviewDetail.curState == 3" flat slot="right" @click="getUndo" style="font-size:1rem">
                撤销
            </mu-button>
        </div>
		<!-- <top-bar style="z-index:10000" :title="title"></top-bar> -->
        <mu-list style="padding-top:54px;">
            <div class="reviewItem">
                <div class="re-title">{{aprTypeMap[reviewDetail.aprType]}}人</div>
                <div class="re-content">{{reviewDetail.applyName}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.startTime">
                <div class="re-title">开始时间</div>
                <div class="re-content">{{reviewDetail.startTime}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.endTime">
                <div class="re-title">结束时间</div>
                <div class="re-content">{{reviewDetail.endTime}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.supplyType">
                <div class="re-title">补签类型</div>
                <div class="re-content">{{(reviewDetail.supplyType==1)?'签到' : '签退'}}</div>
            </div>
            <div class="reviewItem" v-if="reviewDetail.date">
                <div class="re-title">补签时间</div>
                <div class="re-content">{{reviewDetail.date}}</div>
            </div>
            <div class="reviewItem">
                <div class="re-title">{{aprTypeMap[reviewDetail.aprType]}}原因</div>
                <div class="re-content">{{reviewDetail.content}}</div>
            </div>
            <div class="reviewItem">
                <div class="re-title">抄送人员</div>
                <div class="re-content">
                    <div class="contentItem" v-if="sendPersonsN" v-for="(item,idx) in reviewDetail.sendPersons" :key="idx">
                        <div class="itemText" style="float:left;padding-right: 10px;">{{item.apprUserName}}</div>
                        <!-- <div class="itemText" style="color:#a7a7a7">{{item.apprOpinion}}</div> -->
                    </div>
                    <div class="contentItem" v-if="!sendPersonsN">
                        <div class="itemText">无</div>
                    </div>
                </div>
            </div>
            <div class="reviewItem">
                <div class="re-title">审批记录</div>
                <div class="re-content">
                    <div class="contentItem" v-if="applyRecodesN" v-for="(item,idx) in reviewDetail.applyRecodes" :key="idx">
                        <div class="itemText">{{item.apprUserName}} <b class="greenB" :class="{ redB:!item.agree }">{{agreeList[item.agree]}}</b> {{item.apprTime}}</div>
                        <div class="itemText" style="color:#a7a7a7">{{item.apprOpinion}}</div>
                    </div>
                    <div class="contentItem"  v-if="!applyRecodesN">
                        <div class="itemText">无</div>
                    </div>
                </div>
            </div>
            <div class="reviewItem">
                <div class="re-title">附件</div>
                <!-- <div class="re-content"><textarea style="height:30px;" ref="vTextarea" placeholder="审批意见" v-model="temp_value"  class="auto-textarea-input mu-text-field-input"></textarea></div> -->
                <div class="re-content">
                    <div class="contentItem" v-if="filesN" v-for="(item,idx) in reviewDetail.files" :key="idx">
                        <div class="itemImg" v-if="item.fileType.indexOf('image')>-1" @click="lookImg(item.fileUrl)">
                            <img :src="item.fileUrl">
                            <!-- <span>{{item.fileName}}</span> -->
                        </div>
                        <div class="itemImg" v-else>
                            <span>{{item.fileName}}</span>
                        </div>
                    </div>
                    <div class="contentItem"  v-if="!filesN">
                        <div class="itemText">无</div>
                    </div>
                </div>
            </div>
        </mu-list>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
        <mu-dialog title="撤销理由" width="360" :open.sync="undoDialog">
            <textarea spellcheck="false" placeholder="请输入撤销理由" v-model="undoReason"  class="auto-textarea-input mu-text-field-input">
            </textarea>
            <mu-button slot="actions" flat color="primary" @click="closeUndoDialog">关闭</mu-button>
            <mu-button slot="actions" flat color="primary" @click="agreeUndoDialog">确定</mu-button>
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
            <img style="width:85%;margin:5% 7.5%;" :src="screenImg">
        </mu-dialog>
    </mu-container>
</template>

<script>
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import topBar from '@/components/topBar';
import autosize from 'autosize'
export default {
    data(){
        return {
            title:'申请详情',
            agreeList:{"0":"同意","1":"不同意"},
            aprTypeMap:{'overtime':'加班','leave':'请假','business':'出差','outside':'外勤','supply':'补签'},
            detail:JSON.parse(this.$route.params.detail),
            reviewDetail:{
                files:[],
            },
            openFullscreen:false,
            screenImg:'',
            msg:"",
            dialog:false,
            undoDialog:false,
            filesN:true,
            undoReason:'',
            applyRecodesN:true,
            sendPersonsN:true,
            CancellApprApp:{//撤销条件
                id:'',
                canceReasonl:''
            }
        }
    },
    mounted () {
        // this.reviewDetail = JSON.parse(this.$route.params.detail)
        // const textareas = this.$refs.vTextarea;
        // autosize(textareas);
        this.$store.dispatch('closeLoading', false);
        this.getApprApplyInfo();
    },
    methods:{
        goback() {
            this.$router.go(-1);
        },
        getApprApplyInfo(){
            api(ApiList.getApprApplyInfo,{id:JSON.parse(this.$route.params.detail).id})
            .then((res)=>{
                if(res.data.errcode==0){
                    this.reviewDetail = res.data.data;
                    this.CancellApprApp.id = this.reviewDetail.id;
                    (this.reviewDetail.files == 0) ? this.filesN = false : this.filesN = true;
                    (this.reviewDetail.applyRecodes == 0) ? this.applyRecodesN = false : this.applyRecodesN = true;
                    (this.reviewDetail.sendPersons == 0) ? this.sendPersonsN = false : this.sendPersonsN = true;
                }else{
                    this.msg = res.data.errmsg;
                    this.dialog = true;
                }
            },(error)=>{})
        },
        undo(){
            api(ApiList.cancellApprApply,this.CancellApprApp)
            .then((res)=>{
                if(res.data.errcode==0){
                    this.msg = "撤销成功";
                    this.dialog = true;
                    this.$router.go(-1);
                }else{
                    this.msg = res.data.errmsg;
                    this.dialog = true;
                }
            },(error)=>{})
        },
        getUndo(){
            this.undoDialog = true;
        },
        closeUndoDialog(){
            this.undoDialog = false;
            this.undoReason=''
        },
        agreeUndoDialog(){
            if(this.undoReason==''){
                this.msg = "撤销理由不能为空";
                this.dialog = true;
            }else{
                this.undoDialog = false;
                this.CancellApprApp.canceReasonl = this.undoReason;
                this.undo();
            }
        },
        lookImg(url){//图片放大
            this.screenImg = url;
            this.openFullscreen = true;
        },
        closeFullscreen(){
            this.openFullscreen = false;
        },
        closeDialog(){
            this.dialog = false;
        }
    },
    components:{
        topBar
    }
}
</script>

<style lang="less" scoped>
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
        .redB{
            color:red;
        }
        .greenB{
            color:#04be02;
        }
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
.auto-textarea-input{
    font-family: Menlo, "Ubuntu Mono", Consolas, "Courier New", "Microsoft Yahei", "Hiragino Sans GB", "WenQuanYi Micro Hei", sans-serif;
    width: 100%;
    height: 100%;
    font-size:1rem;
    padding: 18px 0 0;
    overflow-y: hidden;
    color: #2C3E50;
    resize:none;
    
}
.mu-text-field-input{
    overflow-x:visible;
    overflow-y:visible;
    height: auto;
    min-height: 32px;
    line-height: 25px;
}
</style>
