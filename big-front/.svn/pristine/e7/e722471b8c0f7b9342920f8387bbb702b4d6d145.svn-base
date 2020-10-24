// import Vue from 'vue'
// import Vuex from 'vuex'
import actions from './actions'
import mutations from './mutations'
import loading from './modules/loading'
import alert from './modules/alert'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        msg: {
            type: null,
            text: ''
        },
        tabActive:0,
        userInfo:{
            // 默认
            account:'admin',
            // token: '123',//全局token
            userName:'空',//用户姓名
            positionY: '',
            appId: '35kj6351', //请求token时候需要
            appSecret: 'sso35kj6351',//请求token时候需要
            // 日志测试数据
            // userId:'1',
            userId: '',
            // 考勤开发测试数据
            // userId: '1899403190657',//全局用户id
            // unitId: '1979849935009',
            // userId: '1987609365697',//全局用户id郑天艳
            unitId: '',//全局单位id
          token: ""//全局token
        },
        applyData: {
            "address": "",
            "apprPersons": [],
            "aprType": "",
            "businessHour": 0,
            "businessReason": "",
            "city": "",
            "content": "",
            "date": "",
            "description": "",//申报内容
            "endTime": "",//结束时间
            "entourage": "",
            "entouragePhone": "",
            "images": [],
            "leaveHour": 0,
            "leaveReason": "",
            "leaveType": "",
            "province": "",
            "reason": "",
            "sendPersons": [
                {
                    "apprUserId": 0,
                    "apprUserIndex": 0,
                    "apprUserName": "",
                    "userType": 0
                }
            ],
            "startTime": "",
            "supplyType": 0,
            "vehicle": ""
        },
        alerts:false,
        isAlert:false,
        signBack: false,
        myReviewBack:false,
        alertText:'网络延迟，请重试！',
    },
    mutations: {    
    	setMsg(state,msg){
    		state.msg.type = msg.type;//0:默认，1:成功，2:正常，3:警告，4:错误
    		state.msg.text = msg.text;
    	},
      getUserInfo(state) {
        let count = 0;
        const timeInterval = setInterval(() => {
          count++;
          if (Android && Android.pushUserBaseInfo) {
            Android.pushUserBaseInfo(function (msg) {//org_id 单位id;token;user_account 用户账号；user_id 用户id；user_name 用户名称
              state.userInfo.userId = msg.user_id;
              state.userInfo.token = msg.token;
              state.userInfo.unitId = msg.org_id;
              state.userInfo.userName = msg.user_name;
              state.userInfo.account = msg.user_account;
            });
            clearInterval(timeInterval);
          } else if (count > 100) {
            alert('页面初始化失败，请返回重新进入~');
            clearInterval(timeInterval);
          }
        }, 100);
          // console.log("重新从安卓获取用户信息数据");
          // console.log(Android);
          // console.log(new Date().getTime());
          // Android.pushUserBaseInfo(function (msg) {//org_id 单位id;token;user_account 用户账号；user_id 用户id；user_name 用户名称
          //   console.log(new Date().getTime());
          //   console.log("安卓传过来的数据 ：");
          //   console.log(msg);
          //   state.userInfo.userId = msg.user_id;
          //   state.userInfo.token = msg.token;
          //   state.userInfo.unitId = msg.org_id;
          //   state.userInfo.userName = msg.user_name;
          //   state.userInfo.account = msg.user_account;
          // });
          // state.userInfo.userId = '565474631742398881';
          // state.userInfo.token = 'dpZ.fRhxpST.pex3J4L6b6d_za6iJGziJHv1lWh5hI5qJL0yJP5YnndIx3nJ5h5df1Lq6ILK6Y4I6xLJVC6FtQnVBh0MxbDNBIhAJsZAdyBFr_jsDC63Hj6jNwxElQ4oxkLtznR85Afv8djIpkxbfnVyDrlZnvRuvPzWPlvQbpxP8Dj5vCDIdkNpBgHJhfvEHFDIlknObnTEpqNjTVFktYLW8FfWv.tMTLdRt7nbDgHmZzTDvS2xhaz6lLzsjvr3f3bn5tPGhHjSF_xRdHDpl969riRbb3N_JHD9huzqppzLt85eVeP75tzLNAzbNMNWh4ZXJCTOrhdxDanYP2VNZDn8zElHLDHwDDFEhn5MxpZmznRxlH4PpWd5jnnwx7nUF5t2pT67LUjcD.fEV9DqD4foJdxHpiTAxX5Y8rh8TSrPvafcFCdvpqvWLvNkt_b2z6TNdoTXlA6KHqH4JrfxNTDlPwLQVBzuXHrdjPHH8vhUxxxID08cBxLs4qDmXjZFhNfohaDHvrrr2HfArBZETFpelgvuVG6btwzhPUX8H55s8r4Epk8M8ubY05FAjsjqHp2GdWVv8W8tbw50vvpsxQTkLv8RrkJ9x2XpXxburan_hlrmxWd85e2SryLbl5loFcjOxWDpFT6lTifWBxjzbNTiTljlhf0bpGD7Jalctqdnd4Jbzbrjl8xEpynrltbFr5j_dlVezSrBJpbbphVjp3LQZ71772C1y7K1_1Y3i8km3.mw_ykaggowdw.upofNn7jFmnW5ROw._W4Wwfq25NR18.jrZ4wYUw1.O9W157mki87jo5uSvMDHRXP0R9RNn.wKoB5fjUCt_aX0y';
          // state.userInfo.unitId = '565108404666761793';
          // state.userInfo.userName = 'lyy';
          // state.userInfo.account = 'lyy';
      },
      getLocUser(state){//从本地获取
          var locInfo = JSON.parse(localStorage.getItem('userInfo'));
          console.log("获取本地数据");
          console.log(locInfo);
          if(locInfo){
              state.userInfo.userId = locInfo.userId;
              state.userInfo.unitId = locInfo.unitId;
              state.userInfo.token = locInfo.token;
          }else{
              this.commit('getUserInfo', state);
          }
      },
      save(state,positionY){
          state.positionY = positionY
      },
      // // H5 plus事件处理
      // plusReady() {
      //     // 设置系统状态栏背景为红色
      //     var type = plus.os.name;
      //     if(type == "iOS") {
      //         plus.navigator.setStatusBarBackground("#38ADFF");
      //     } else {
      //         plus.navigator.setStatusBarBackground("#38ADFF");
      //     }
      // }
    },
    getters: {
        getUserInfo: state => { // 导出表格数据
            return state.tableData
        }
    },
    modules: {
        loading,
        alert
    }
})