<template>
    <div class="detail">
        <top-bar style="z-index:10000;position:fixed;" :title="title"></top-bar>
        <!-- <scroller 
            :on-refresh="refresh"
            refreshText="刷新中……"
            noDataText="没有更多数据"
            :snapping=false
            refreshLayerColor='#000'
            loadingLayerColor='#000'
            style="overflow:hidden;position:absolute;top:56px;"> -->
            <log-info style="padding-top:70px;" :dataLog="logDetail"></log-info>
            <div class="imgBox" v-if="imgList.length!=0">
                <div class="picList" v-if="!!imgList && imgItem.fileType.indexOf('image')>-1" v-for="(imgItem,index) of imgList" :key="index"  @click="lookImg(imgItem.fileUrl)">
                    <img :src="imgItem.fileUrl">
                </div>
                <div class="picList" v-if="!!imgList && (txtItem.fileType.indexOf('text')>-1 || txtItem.fileType.indexOf('application')>-1)" v-for="(txtItem,s) of imgList" :key="s">
                   {{txtItem.fileName}}
                </div>
            </div>
            <div class="ccPeople">
                <mu-tabs style="background:#fff;" :value.sync="isRead" inverse color="black" indicator-color="white" text-color="rgba(0, 0, 0, .54)" >
                    <mu-tab>已读 {{getchance2.length}}</mu-tab>
                    <mu-tab>未读 {{getchance1.length}}</mu-tab>
                    <a class="more" @click="lookMore(getchance2,getchance1)">查看全部 〉</a>
                </mu-tabs>
                <div class="readBox" v-if="isRead === 0">
                    <Approver :addPeo='false' :chance="getchance2" :name='false'></Approver>
                </div>
                <div class="readBox" v-if="isRead === 1">
                    <Approver :addPeo='false' :chance="getchance1" :name='false'></Approver>
                </div>
            </div>
            <comments @click="replyBtn" :commentsArr="commentsArr"></comments>
        <!-- </scroller> -->
        <!-- <div ref="ansBtn" class="ansBtn" :style="{top:(showHeight-50)+'px'}" v-if="logDetail.type==0" v-show="hidshow"> -->
        <div ref="ansBtn" class="ansBtn" v-if="logDetail.type==0" v-show="hidshow">
            <mu-button full-width color="primary" @click="openCommentsDialog">评论</mu-button>
        </div>
        <mu-dialog width="360" transition="slide-bottom" fullscreen :open.sync="openComments">
          <mu-appbar color="primary" title="评论内容">
            <mu-button slot="left" icon @click="openComments = false">
              <mu-icon value="close"></mu-icon>
            </mu-button>
          </mu-appbar>
          <div style="padding: 10px;">
            <mu-text-field style="width:100%" v-model="ansDetail" placeholder="评论内容" multi-line :rows="5" :rows-max="8"></mu-text-field>
            <mu-button full-width color="primary" @click="saveAns">发送</mu-button>
          </div>
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
    </div>
</template>

<script>
import topBar from '@/components/topBar'
import logInfo from '@/components/logInfo'
import comments from '@/components/comments/comments'
import avatar from '../../assets/logo.png'
import Approver from '@/components/approver/approver'
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
export default {
    data () {
        return {
            title:"日志详情",
            showRpl:false,
            isRead:0,
            logDetail:{},
            imgList:[],
            getchance1:[],
            getchance2:[],
            ansDetail:'',
            docmHeight: document.documentElement.clientHeight,  //默认屏幕高度
            showHeight: document.documentElement.clientHeight,   //实时屏幕高度
            hidshow:true,  //显示或者隐藏footer
            ansData:{
                content:'',
                userId:this.$store.state.userInfo.userId,
                workLogId:''
            },
            openFullscreen:false, // 图片详情查看
            openComments:false, // 评论弹框
            screenImg:'',
            commentsArr:[]
        }
    },
    mounted(){
        // window.onresize监听页面高度的变化
        window.onresize = ()=>{
            return(()=>{
                this.showHeight = document.body.clientHeight;
            })()
        }
        this.$store.dispatch('closeLoading', false);
    },
    watch: {
        showHeight:function(newVal,oldVal) {
            if(this.docmHeight > this.showHeight){
                this.$refs.ansBtn.$set();
                // document.getElementsByClassName("ansBtn").style.top = this.showHeight;
                console.log("top值"+document.getElementsByClassName("ansBtn").style.top)
                this.showHeight = 0;
                this.hidshow=false
            }else{
                this.hidshow=true
            }
        }
    },
    activated(){
        this.$store.dispatch('closeLoading', false);
        window.scroll(0, 0);//默认置顶
        this.commentsArr=[];
        this.imgList=[];
        // 重新赋值
        if(!!this.$route.params.log){
            this.logDetail = JSON.parse(this.$route.params.log);
            if(this.logDetail.type==0){
                this.workLogLooks(this.logDetail.id);
            }
        }
        if(this.logDetail.workLogAnswerDTOS)this.commentsArr = this.logDetail.workLogAnswerDTOS.reverse();
        this.logDetail.isRead = true;
        if(!!this.logDetail.workLogDetailDTOS){
            for(var i = 0;i<this.logDetail.workLogDetailDTOS.length;i++){
                if(!!this.logDetail.workLogDetailDTOS[i].workLogFileDTOS){
                    for(var j = 0;j<this.logDetail.workLogDetailDTOS[i].workLogFileDTOS.length;j++){
                        this.imgList.push(this.logDetail.workLogDetailDTOS[i].workLogFileDTOS[j]);
                    }
                }
            }
            this.ansData.workLogId = this.logDetail.workLogDetailDTOS[0].logId;
            this.getLookUser1();
            this.getLookUser2();
        }
        // this.ansData.workLogId = this.logDetail.workLogDetailDTOS[0].logId;
        // this.getLookUser1();
        // this.getLookUser2();
    },
    methods:{
        replyBtn(fuc){
            fuc(function(id){
                console.log(id);
            })
            this.showRpl = !this.showRpl;
        },
        getId(e){
            console.log(e);
        },
        refresh(done) {//下拉刷新
            console.log("刷新");
            setTimeout(() => {
                done();
            }, 1000);
        },
        openCommentsDialog () { // 评论弹框
          this.openComments = true;
          this.ansDetail = '';
        },
        lookMore(getchance1,getchance2){
            this.$store.dispatch('openLoading')
            this.$router.push({
                name:'LogRead',
                params:{getchance1:JSON.stringify(getchance1),getchance2:JSON.stringify(getchance2)}
            });
        },
        getAns(){
            api(ApiList.getAns,{workLogId:this.ansData.workLogId})
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.commentsArr = res.data.data.reverse();
                    }
                },(error)=>{  
                }
            ) 
        },
        getLookUser1(){
            api(ApiList.getLookUser,{logId:this.ansData.workLogId,status:1})
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.getchance1 = res.data.data;
                    }
                },(error)=>{  
                }
            ) 
        },
        getLookUser2(){
            api(ApiList.getLookUser,{logId:this.ansData.workLogId,status:2})
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.getchance2 = res.data.data;
                    }
                },(error)=>{  
                }
            ) 
        },
        saveAns(){
          this.ansData.content = this.ansDetail;
          console.log(this.ansData.content)
          if(this.ansDetail!=''){
            api(ApiList.saveAns,this.ansData).then((res)=>{
              if(res.data.errcode==0){
                this.openComments = false;
                this.$store.dispatch('openAlert', '添加成功');
                this.ansDetail='';//初始化，后期全放在一个方法中
                this.getAns();//刷新
                window.scrollBy(0, -(window.scrollY-430));
              }else{
                this.$store.dispatch('openAlert', res.data.msg);
              }
              },(error)=>{
              }
            )
          }
        },
        workLogLooks(id){
            let data = {"logId":id};
            api(ApiList.workLogLook,data)  
                .then((res)=>{
                    if(res.data.errcode==0){
                        console.log("已读");
                    }
                },(error)=>{  
                }
            )
        },
        lookImg(url){//图片放大
            this.screenImg = url;
            this.openFullscreen = true;
        },
        closeFullscreen(){
            this.openFullscreen = false;
        },
    },
    components:{
        topBar,
        logInfo,
        comments,
        Approver
    }
}
</script>

<style lang="less" scoped>
.detail{
    position: relative;
    width:100%;
    height:90%;
    overflow:inherit;
    margin:0 0 56px 0;
}
.imgBox{
    margin:10px 0;
    background: #fff;
    min-height:80px;
    height:auto;
    overflow: hidden;
    .picList{
        height: 60px;
        width: 60px;
        margin: 0.5rem;
        float: left;
        background-size: contain;
        background-position: center;
        background-repeat: no-repeat;
        position: relative;
        img{
            width:60px;
            height:60px;
        }
    }
}
.ccPeople{
    margin:5px 0 10px 0;
    .more{
        font-size: 1rem;
        position: absolute;
        right:0.5rem;
        color:#000;
        padding: 10px;
    }
    .readBox{
        width:100%;
        min-height:80px;
        height:auto;
        overflow: hidden;
        background: #fff;
        padding-bottom:2rem;
    }
}
.ansBtn{
    position: fixed;
    bottom:2px;
    background: #fff;
    border-top:1px solid #ccc;
    width:100%;
    z-index: 101;
    input{
        height:40px;
        resize: none;
        border:none;
        background: #e0e0e0;
        margin:5px 0;
        width:70%;
        padding:0 10px;
        outline:none;
    }
}
</style>

