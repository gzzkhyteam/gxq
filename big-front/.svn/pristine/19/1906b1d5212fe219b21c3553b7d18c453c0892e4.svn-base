<template>
    <mu-container>
        <div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box">
            <div class="mu-appbar-left">
                <a @click="goback" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
                    <div class="mu-button-wrapper">
                        <div class="mu-ripple-wrapper"></div> 
                        <i class=" mu-icon  material-icons  " style="user-select: none;">keyboard_arrow_left</i>
                        返回
                    </div>
                </a>
            </div> 
            <div class="mu-appbar-title">
                <div class="mu-appbar-title">{{title}}</div> 
            </div>
            <mu-button flat slot="right" to="clockInList" style="font-size:1rem">
                打卡记录
            </mu-button>
        </div>
        <!-- <top-bar style="z-index:10000"  right-act='{"name":"打卡记录","url":"clockInList"}' :title="title"></top-bar> -->
        <div class="signItem signDate" :z-depth="2" v-bind:style="{height: fullHeight*0.4}">
            <div class="signDate-item">
                <div class="signDate-item-m">
                    <p>上班时间</p>
                    <div class="signDate-time">{{signData.inTime}}</div>
                </div>
                <div class="signDate-item-m">
                    <p>签到时间</p>
                    <div class="signDate-time">{{ signTodayData.signInTime || '未签到' }}</div>
                </div>
            </div>
            <div class="signDate-item">
                <div class="signDate-item-m">
                    <p>下班时间</p>
                    <div class="signDate-time">{{signData.outTime}}</div>
                </div>
                <div class="signDate-item-m">
                    <p>签退时间</p>
                    <div class="signDate-time">{{ signTodayData.signOffTime || '未签退' }}</div>
                </div>
            </div>
        </div>
        <div class="signItem signAddress" v-bind:style="{height: fullHeight*0.2}">
            <div class="addrL">
                <div class="addr-state" v-if="gpsOk">
                    <img src="../../assets/gpsOk.png">
                    <span>已进入考勤范围内</span>
                </div>
                <div class="addr-state" v-else>
                    <img src="../../assets/delete.png">
                    <span>不在考勤范围内</span>
                </div>
                <p class="signAddress-addr">考勤点：{{signData.location}}</p>
            </div>
            <div class="addrR">
                <button @click="refGps" tabindex="0" type="button" class="mu-button mu-flat-button " style="user-select: none; outline: none; -webkit-appearance: none;">
                    <div class="mu-button-wrapper" style="padding:0 0.2rem;color:#585858">
                        <div class="mu-ripple-wrapper"></div>
                        <img src="../../assets/gpsRef.png">
                        重新定位
                    </div>
                </button>
                <!-- <img src="../../assets/gpsRef.png">
                <span>重新定位</span> -->
            </div>
        </div>
        <mu-flex class="flex-wrapper" align-items="center" v-bind:style="{height: fullHeight*0.4}">
            <div class="signBtn">
                <mu-flex class="flex-demo" justify-content="center" fill>
                    <div class="singBtn-work" @click="Sign(1)">
                        <img src="../../assets/goWork.png" :class="{gray:!gpsOk}">
                        <!-- <span v-if="gpsOk"></span>
                        <span v-if="gpsOk"></span> -->
                    </div>
                    <div class="singBtn-work" @click="Sign(2)">
                        <img src="../../assets/afterWork.png" :class="{gray:!gpsOk}">
                        <!-- <span v-if="gpsOk"></span>
                        <span v-if="gpsOk"></span> -->
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
export default {
    data () {
        return{
            title:"签到打卡",
            signData:{},
            signTodayData:{},
            signAddress:{},
            gpsOk:false,
            msg:'',
            dialog:false,
            clockData:{
                "adceType": 1,
                "autoSignInFlag": 1,
                "autoSignOffFlag": 1,
                "clockType": 1,
            },
            fullHeight:document.documentElement.clientHeight,//获取屏幕高度
        }
    },
    beforeRouteEnter (to, from, next) {
        console.log(to);
        console.log(from);
        if(from.name == "MyAttendance"){
            next(vm=>{
                vm.$store.state.signBack = true;//保存来源地址
            })
        }
       next();
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        const _this = this
        window.onresize = () => {//获取屏幕高度
            return (() => {
            window.fullHeight = document.documentElement.clientHeight
            _this.fullHeight = window.fullHeight
            })()
        }
        this.init();
    },
    methods:{
        init(){
            this.getMyUnityPunchClockRule();
            this.getTodayPunchClock();
        },
        goback() {
            console.log(this.$store.state.signBack);
            if(!this.$store.state.signBack){
                Android.closeActivity();
            }else{
                this.$store.dispatch('openLoading')
                this.$router.isBack=true;
                this.$router.go(-1);
            }
        },
        getMyUnityPunchClockRule(){//获取单位考勤地点
            api(ApiList.getMyUnityPunchClockRule)
            .then((res)=>{
                if(res.data.errcode == 0){
                    this.signData = res.data.data;
                    this.getAndroidClock();
                }else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
                    this.getMyUnityPunchClockRule();
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
                    if(this.signTodayData.signInTime)this.signTodayData.signInTime = this.signTodayData.signInTime.substring(10);
                    if(this.signTodayData.signOffTime)this.signTodayData.signOffTime = this.signTodayData.signOffTime.substring(10);
                }else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
                    this.getTodayPunchClock();
                }else{
                    this.msg = res.data.errmsg;
                    this.dialog = true;
                }
            },(error)=>{})
        },
        getAndroidClock(){
            let lng = parseFloat(this.signData.lng),lat = parseFloat(this.signData.lat),distanceRange = this.signData.distanceRange;
            let _this = this;
            Android.checkLocationInfo(lng,lat,function (msg) {
                _this.signAddress = msg;
                _this.count(msg);
            });
        },
        createPunchClock(type){
            if(this.gpsOk){//判断打卡位置的距离
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
                }else{//签退
                    // if(this.signTodayData.signInTime==null){
                    //     this.msg = "您还未签到，无法进行签退操作！";
                    //     this.dialog = true;
                    //     return;
                    // }
                    // if(this.signTodayData.signOffTime!=null){
                    //     this.msg = "今天已签退，请不要重复签到！";
                    //     this.dialog = true;
                    //     return;
                    // }
                    this.clockData.signOffLat = this.signAddress.lat;
                    this.clockData.signOffLng = this.signAddress.lon;
                    this.clockData.signOffLocation = this.signAddress.address;
                }
                api(ApiList.createPunchClock,this.clockData)
                .then((res)=>{
                    if(res.data.errcode == 0){
                        this.msg = "打卡成功！";
                        this.dialog = true;
                        this.init();
                        // this.signData = res.data.data;
                    }else{
                        this.msg = res.data.errmsg;
                        this.dialog = true;
                    }
                },(error)=>{})
            }else{
                let msg = '';
                if(this.signAddress.distance == -1){
                    (this.signAddress.address == '') ?　 msg = '不在考勤地址范围内，请检查定位后重拾！'　:　 msg = this.signAddress.address;
                }   
                this.msg = msg;
                this.dialog = true;
            }
        },
        refGps(){
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
        Sign(type){
            if(this.gpsOk){
                this.createPunchClock(type);
            }
        },
        count(signAddress){//计算是否在考勤点
            (signAddress.distance > 0 && signAddress.distance <= this.signData.distanceRange) ?　this.gpsOk = true :　this.gpsOk = false;
        },
        closeDialog(){
            this.dialog = false;
        }   
    },
    components:{
        topBar,
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
.container{
    padding:0;
    .signItem{
        background: #fff;
        overflow: hidden;
        border-bottom:1px solid #e3e3e3;
        border-top:1px solid #e3e3e3;
        width:100%;
    }
    .signDate{
        // height:300px;
        .signDate-item:first-child{
            // border-bottom:1px #e3e3e3 dashed;
        }
        .signDate-item{
            padding: 20px 0 10px 0;
            margin:0 10%;
            // height: 150px;
            .signDate-item-m{
                float: left;
                width:50%;
                height:100%;
                text-align: center;
                p{  
                    margin:0;
                    line-height: 30px;
                    height:30px;
                }
                .signDate-time{
                    line-height: 100px;
                    font-size:30px;
                    font-weight: bold;
                    height:80px;
                }
            }
        }
    }
    .signAddress{
        height:auto;
        margin:10px 0;
        .addrL{
            float: left;
            width:70%;
            height:100%;
            .addr-state{
                width:100%;
                padding:10px 20px;
                text-align: left;
                img{
                    width:30px;
                    height:30px;
                }
                span{
                    position: relative;
                    bottom: 8px;
                    font-size:16px;
                    font-weight: bold;
                    padding:0 0.4rem;
                }
            }
            .signAddress-addr{
                margin:0 0 0 1rem;
                text-align: left;
            }
        }
        .addrR{
            float: right;
            width:30%;
            height:100%;
            padding:10px 0;
            .mu-flat-button{
                height:auto;
                line-height: 20px;
            }
            img{
                width:30px;
                height:30px;
            }
            span{
                position: relative;
                bottom: 8px;
                color:#ccc;
                font-weight: bold;
            }
        }
    }
    .signBtn{
        width: 100%;
        height: 25%;
        position: fixed;
        bottom: 0;
        // height: 250px;
        .singBtn-work{
            width: 50%;
            height: 60%;
            padding:5% 0;
            margin: 0 auto;
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
