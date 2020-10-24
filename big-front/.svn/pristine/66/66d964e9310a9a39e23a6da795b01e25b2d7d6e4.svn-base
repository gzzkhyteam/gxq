<template>
    <mu-container>
        <top-bar style="z-index:10000"  right-act='{"name":"打卡记录","url":"clockInList"}' :title="title"></top-bar>
        <div class="signItem"><!-- 时间列表 -->
            <div class="signItem-L">
                <img src="../../assets/dateIcon.png">
                <span>时间：</span>
            </div>
            <div class="signItem-R">{{date | formatDate}}</div>
        </div>
        <div class="signItem"><!-- 地址列表 -->
            <div class="signItem-L">
                <img src="../../assets/addressIcon.png">
                <span>地址：</span>
            </div>
            <div class="signItem-R" style="line-height:30px;">{{signAddress.address}}</div>
            <div class="signRef">
                <button @click="refGps" tabindex="0" type="button" class="mu-button mu-flat-button " style="user-select: none; outline: none; -webkit-appearance: none;">
                    <div class="mu-button-wrapper" style="padding:0 0.2rem;color:#585858">
                        <div class="mu-ripple-wrapper"></div>
                        <img src="../../assets/gpsRef.png">
                    </div>
                </button>
            </div>
        </div>
        <div class="signItem">
            <textarea class="signItem-content" ref="vTextarea" placeholder="备注内容" v-model="content">
            </textarea>
        </div>
        <div class="signItem">
            <Upload style="width: 100%;" :imgArr="imgFile" :action="url" :onSuccess="UploadSuccess" :onError="UploadError"></Upload>
        </div>
        <mu-flex class="flex-wrapper" align-items="center">
            <div class="signBtn">
                <mu-flex class="flex-demo" justify-content="center" fill>
                    <div class="singBtn-work" @click="fieldSign(1)">
                        <img src="../../assets/goWork.png">
                        <!-- <span></span>
                        <span></span> -->
                    </div>
                    <div class="singBtn-work" @click="fieldSign(2)">
                        <img src="../../assets/afterWork.png">
                        <!-- <span></span>
                        <span></span> -->
                    </div>
                </mu-flex>
            </div>
        </mu-flex>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </mu-container>
</template>

<script>
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import topBar from '@/components/topBar';
import autosize from 'autosize'
import Upload from '@/components/HY/Upload'
import { formatDate } from "@/public/date.js";
var root = process.env.API_ROOT;
export default {
    data () {
        return{
            title:"外勤打卡",
            content:'',
            date:new Date(),
            imgFile:[],
            url:root+ApiList.fileUpload.url,
            msg:"",
            dialog:false,
            signTodayData:{},
            signAddress:{},
            gpsOk:false,
            clockData:{
                "adceType": 2,
                "autoSignInFlag": 1,
                "autoSignOffFlag": 1,
                "clockType": 1,
            }
        }
    },
    mounted () {
        this.$store.dispatch('closeLoading', false);
        var _this = this; 
        const textareas = this.$refs.vTextarea;
        autosize(textareas);
        this.init();
        this.timer = setInterval(function(){
            _this.date = new Date();  //修改数据date
        },1000)
    },
    beforeDestroy:function(){
        if(this.timer){
            clearInterval(this.timer);  //在Vue实例销毁前，清除我们的定时器
        }
    },
    filters: {
        formatDate(time) {
            var date = new Date(time);
            return formatDate(date, 'yyyy-MM-dd  hh:mm:ss');
        }
    },
    methods:{
        init(){
            this.getMyUnityPunchClockRule();
            this.getTodayPunchClock();
        },
        refGps(){//刷新定位点
            this.getAndroidClock();
            let msg = '';
            if(this.signAddress.distance == -1){
                (this.signAddress.address == '') ?　 msg = '不在考勤地址范围内，请检查定位后重拾！'　:　 msg = this.signAddress.address;
            }else{
                msg = "定位刷新成功！"
            }
            this.msg = msg;
            this.dialog = true;
        },
        getMyUnityPunchClockRule(){//获取单位考勤地点
            api(ApiList.getMyUnityPunchClockRule)
            .then((res)=>{
                if(res.data.errcode == 0){
                    this.signData = res.data.data;
                    this.getAndroidClock();
                }else{
                    this.msg = res.data.errmsg;
                    this.dialog = true;
                }
            },(error)=>{})
        },
        getTodayPunchClock(){//获取今天的打卡记录
            api(ApiList.getTodayPunchClock)
            .then((res)=>{
                if(res.data.errcode == 0){
                    this.signTodayData = res.data.data;
                }else{
                    this.msg = res.data.errmsg;
                    this.dialog = true;
                }
            },(error)=>{})
        },
        getAndroidClock(){//获取安卓位置信息数据
            let lng = parseFloat(this.signData.lng),lat = parseFloat(this.signData.lat),distanceRange = this.signData.distanceRange;
            let _this = this;
            Android.checkLocationInfo(lng,lat,function (msg) {
                _this.signAddress = msg;
                _this.count(msg);
            });
            // this.count();
        },
        UploadSuccess(res){
            this.imgFile=res;
        },
        UploadError(res){
            this.msg = res.errmsg;
            this.dialog = true;
        },
        closeDialog(){
            this.dialog = false;
        },
        fieldSign(type){
            // if(this.gpsOk){//判断打卡位置的距离
                this.clockData.clockType = type;
                if(type==1){//签到
                    // if(this.signTodayData.signInTime!=null){
                    //     this.msg = "今天已签到，请不要重复签到！";
                    //     this.dialog = true;
                    //     return;
                    // }
                    this.clockData.signInLat = this.signAddress.lat;
                    this.clockData.signInLng = this.signAddress.lon;
                    this.clockData.signLocation = this.signAddress.address;
                    // this.clockData.signInLat = 26.625034;
                    // this.clockData.signInLng = 106.653579;
                    // this.clockData.signLocation = '中国贵州省贵阳市乌当区毕节路（在高科一号附近）';
                }else{//签退
                    // if(this.signTodayData.signOffTime!=null){
                    //     this.msg = "今天已签退，请不要重复签到！";
                    //     this.dialog = true;
                    //     return;
                    // }
                    this.clockData.signOffLat = this.signAddress.lat;
                    this.clockData.signOffLng = this.signAddress.lon;
                    this.clockData.signOffLocation = this.signAddress.address;
                    // this.clockData.signOffLat = 26.625034;
                    // this.clockData.signOffLng = 106.653579;
                    // this.clockData.signOffLocation = '中国贵州省贵阳市乌当区毕节路（在高科一号附近）';
                }
                api(ApiList.createPunchClock,this.clockData)
                .then((res)=>{
                    if(res.data.errcode == 0){
                        this.msg = "打卡成功！";
                        this.dialog = true;
                        this.init();
                    }else{
                        this.msg = res.data.errmsg;
                        this.dialog = true;
                    }
                },(error)=>{})
            // }
        },
        count(signAddress){//计算是否在考勤点
            (signAddress.distance > 0 && signAddress.distance <= this.signData.distanceRange) ?　this.gpsOk = true :　this.gpsOk = false;
        },
    },
    components:{
        topBar,
        Upload
    }
}
</script>

<style lang="less" scoped>
.container{
    padding:0;
    .signItem{
        background: #fff;
        overflow: hidden;
        border-bottom:1px solid #e3e3e3;
        border-top:1px solid #e3e3e3;
        width:100%;
        min-height:60px;
        margin-top:0.5rem;
        position: relative;
        .signItem-L{
            width:30%;
            height:60px;
            line-height: 60px;
            float: left;
            img{
                margin:15px 5px;
                width:30px;
                height:30px;
                float: left;
            }
            span{
                float: left;
            }
        }
        .signItem-R{
            width: 55%;
            min-height: 60px;
            line-height: 60px;
            float: left;
            text-align: left;
            word-wrap: break-word;
        }
        .signRef{
            width: 15%;
            position: absolute;
            right: 10px;
            img{
                width: 30px;
                height: 30px;
            }
        }
    }
    .signItem-content{
        width:100%;
        height:100%;
        resize: none;
        border:none;
        outline:none;
        padding:10px 10px 10px 2rem;
    }
    .signBtn{
        width: 100%;
        height: 30%;
        bottom: 0;
        .singBtn-work{
            width: 50%;
            height: 60%;
            padding:5% 0;
            margin: 5% auto 0 auto;
            float: left;
            position: relative;
            img{
                width: 60%;
                height: 60%;
                margin: 0 10%;
            }
        }
    }
    @keyframes living {//涟漪动画效果和透明度设置
        0%{
            transform: scale(1);
            opacity: 0.5;  
        }
        50%{
            transform: scale(1.5);  
            opacity: 0;  
        }
        100%{
            transform: scale(1);
            opacity: 0.5;
        }
    }
    .singBtn-work span{
        position: absolute;
        width: 60%;
        height: 70%;
        right: 20%;
        top: 12%;
        background: #519fff;
        border-radius: 50%;
        -webkit-animation: living 3s linear infinite;
        z-index: -1;
    }
    .singBtn-work:nth-child(2) span{
        background: #4caf50;
    }
    .singBtn-work span:nth-child(2){
        -webkit-animation-delay: 1.5s; /*第二个span动画延迟1.5秒*/
    }
    .gray { 
        -webkit-filter: grayscale(100%);
        -moz-filter: grayscale(100%);
        -ms-filter: grayscale(100%);
        -o-filter: grayscale(100%);
        
        filter: grayscale(100%);
        
        filter: gray;
    }
}
</style>
