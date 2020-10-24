<template>
  <mu-container>
    <mu-appbar class="top-bar-box" color="primary">
      <mu-button icon slot="left" @click="goback" style="font-size:1rem">
        <mu-icon value="keyboard_arrow_left"></mu-icon>
        返回
      </mu-button>
      <div style="text-align:center;">{{title}}</div>
      <mu-button flat slot="right" @click="openMenu" style="font-size:1rem">
        <mu-icon value="more_horiz"></mu-icon>
      </mu-button>
    </mu-appbar>
    <mu-list :z-depth="2" textline="two-line">
      <mu-list-item button :ripple="true" @click="openBotttomSheet">
        <mu-list-item-content>
          <mu-list-item-title>选择考勤月份</mu-list-item-title>
          <mu-list-item-sub-title>{{dateYear}}{{dateMonth}}</mu-list-item-sub-title>
        </mu-list-item-content>
        <mu-list-item-action>
          <mu-icon value="expand_more"></mu-icon>
        </mu-list-item-action>
      </mu-list-item>
    </mu-list>
    <mu-list toggle-nested textline="two-line">
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('overtime')" :open="overtime === 'send'" @toggle-nested="overtime = arguments[0] ? 'send' : ''">
        <mu-list-item-title>加班</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.workHous)? GetMyStatics.workHous : 0 }}小时</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in overtimeData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，加班{{ item.value.toFixed(2) }}小时</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
      <mu-divider></mu-divider>
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('leave')" :open="leave === 'send'" @toggle-nested="leave = arguments[0] ? 'send' : ''">
        <mu-list-item-title>请假</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.leaveHous)? GetMyStatics.leaveHous : 0 }}小时</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in leaveData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，{{leaveType[item.ext]}}{{ item.value.toFixed(2) }}小时</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
      <mu-divider></mu-divider>
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('business')" :open="business === 'send'" @toggle-nested="business = arguments[0] ? 'send' : ''">
        <mu-list-item-title>出差</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.travelHous)? GetMyStatics.travelHous : 0 }}小时</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in businessData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，出差{{ item.value.toFixed(2) }}小时</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('outside')" :open="outside === 'send'" @toggle-nested="outside = arguments[0] ? 'send' : ''">
        <mu-list-item-title>外勤</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.outHous)? GetMyStatics.outHousTime : 0 }}次</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in outsideData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，外勤{{ item.value.toFixed(0) }}小时</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('lateHour')" :open="lateHour === 'send'" @toggle-nested="lateHour = arguments[0] ? 'send' : ''">
        <mu-list-item-title>迟到</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.lateHour)? (GetMyStatics.lateHour*60).toFixed(0) : 0 }}分钟</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in lateHourData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，迟到{{ (item.value*60).toFixed(0) }}分钟</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('earlyHour')" :open="earlyHour === 'send'" @toggle-nested="earlyHour = arguments[0] ? 'send' : ''">
        <mu-list-item-title>早退</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.earlyHour)? (GetMyStatics.earlyHour*60).toFixed(0) : 0 }}分钟</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in earlyHourData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，早退{{ (item.value*60).toFixed(0) }}分钟</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
      <mu-list-item button :ripple="true" nested @click="GetMyStaticsByType('minerCount')" :open="minerCount === 'send'" @toggle-nested="minerCount = arguments[0] ? 'send' : ''">
        <mu-list-item-title>旷工</mu-list-item-title>
        <div class="mu-item-action" style="min-width:110px;">
          <mu-list-item-after-text>{{ (GetMyStatics.minerCount)? GetMyStatics.minerCount : 0 }}次</mu-list-item-after-text>
          <i class="mu-icon material-icons" style="user-select: none;">expand_more</i>
        </div>
        <mu-list-item button :ripple="true" slot="nested" v-for="(item,idx) in minerCountData" :key="idx">
          <mu-list-item-title>{{ item.attDay }}，旷工{{ item.value.toFixed(0) }}次</mu-list-item-title>
        </mu-list-item>
      </mu-list-item>
    </mu-list>
    <mu-bottom-sheet :open.sync="dateSheet">
      <mu-sub-header style="border-bottom:1px solid #ccc;">
        <mu-row>
          <mu-col span="6">
            <mu-flex class="flex-wrapper" justify-content="start">
              <mu-button flat @click="closeBotttomSheet">取消</mu-button>
            </mu-flex>
          </mu-col>
          <mu-col span="6">
            <mu-flex class="flex-wrapper" justify-content="end">
              <mu-button flat @click="getMyAttendanceData">确定</mu-button>
            </mu-flex>
          </mu-col>
        </mu-row>
      </mu-sub-header>
      <mu-slide-picker :slots="dateSlots" :visible-item-count="7" @change="dateChange" :values="date"></mu-slide-picker>
    </mu-bottom-sheet>
    <div class="mu-dialog-wrapper" style="z-index: 100001;" v-if="openScroll" @click="closeMenu">
      <div class="mu-dialog  mu-scale" style="width: 360px;border-radius:15px;">
        <div class="mu-dialog-body">
          <mu-list class="mu-dialog-cus-list">
            <mu-list-item class="mu-dialog-cus-item" button :ripple="true" :key="index" v-for="(option,index) in options" @click.stop="goTo(option.to)">
              <mu-list-item-title class="mu-dialog-cus-item-title">{{option.name}}</mu-list-item-title>
            </mu-list-item>
          </mu-list>
        </div>
      </div>
    </div>
    <div class="mu-overlay mu-overlay-cus" v-if="openScroll"></div>
    <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
  </mu-container>
</template>
<script>
  import topBar from '@/components/topBar';
  import ApiList from '@/api/apiList'
  import api from '@/api/axiosApi'
  import { allDate } from "@/public/date.js";
  const date = allDate();
  const year = new Date().getFullYear();
  const month = new Date().getMonth()+1;
  export default {
    data() {
      return {
        title: "我的考勤",
        panel: '',
        dateSheet: false,
        overtime: '',
        overtimeData:{},
        leave: '',
        leaveData:{},
        leaveType:{leave:'事假', sick:'病假', year:'年假', relatives:'探亲假', marriage:'婚假', maternity:'产假', funeral:'丧假', expatriate:'外派'},
        business: '',
        businessData:{},
        outside: '',
        outsideData:{},
        lateHour: '',
        lateHourData:{},
        earlyHour:'',
        earlyHourData:{},
        minerCount: '',
        minerCountData:{},
        dateSlots: [{
          width: '100%',
          textAlign: 'right',
          values: Object.keys(date)
        }, {
          width: '100%',
          textAlign: 'left',
          values: ['01月', '02月', '03月', '04月', '05月', '06月', '07月', '08月', '09月', '10月', '11月', '12月']
        }],
        date: [year.toString()+'年', (month>=10) ? month+'月' : "0"+month+'月'],
        dateYear: year.toString()+'年',
        dateMonth: (month>=10) ? month+'月' : "0"+month+'月',
        openScroll: false,
        GetMyStatics:{
          earlyHour:0,//早退（单位小时）
          lateHour:0,// 迟到（单位小时）
          leaveHous:0,//请假（单位小时）
          minerCount:0,//矿工(单位次数)
          outHous:0,//外勤（单位小时）
          travelHous:0,//出差（单位小时）
          workHous:0,//加班（单位小时）
        },
        options: [{
            name: '签到打卡',
            to: 'sign'
          },
          {
            name: '外勤打卡',
            to: 'fieldSign'
          },
          {
            name: '外勤申报',
            to: 'fieldForm'
          },
          {
            name: '加班申请',
            to: 'overtimeForm'
          },
          {
            name: '请假申请',
            to: 'askLeave'
          },
          {
            name: '考勤补签',
            to: 'supplementSign'
          },
          {
            name: '考勤审批',
            to: 'myReview'
          },
          {
            name: '出差申请',
            to: 'businessApply'
          },
          {
            name: '申请记录',
            to: 'ApplyList'
          },
        ],
        msg:'',
        dialog:false
      }
    },
    activated(){
      this.$store.dispatch('closeLoading', false);
      // this.$setgoindex()
    },
    mounted(){
      this.$store.dispatch('closeLoading', false);
      this.getMyAttendanceData();
    },
    methods: {
      getMyAttendanceData(){
        this.resetOpenColumns()
        let attMonth = this.dateYear.substr(0,4) + '-' +this.dateMonth;
        attMonth = attMonth.substr(0,attMonth.length-1);//传递时间处理
        api(ApiList.h5GetMyStatics,{attMonth:attMonth})
        .then((res)=>{
          if(res.data.errcode==0){
            this.GetMyStatics = res.data.data;
          }else if(res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005){
            this.getMyAttendanceData();
          }else{
            if(res.data.data){
              this.msg = res.data.errmsg;
              this.dialog = true;
            }
          }
        },(error)=>{})
        this.dateSheet = false;
      },
      resetOpenColumns () {
        this.overtime = '';
        this.leave = '';
        this.business = '';
        this.outside = '';
        this.lateHour = '';
        this.earlyHour = '';
        this.minerCount = '';
        this.overtimeData = [];
        this.leaveData = [];
        this.businessData = [];
        this.outsideData = [];
        this.lateHourData = [];
        this.earlyHourData = [];
        this.minerCountData = [];
      },
      GetMyStaticsByType(type){// type类型：overtime:加班，leave:请假，business:出差，outside:外勤， :supply:补签 : lateHour: 迟到 : earlyHour :早退 : minerCount:矿工
        switch (type) {
          case 'overtime':
            if(this.overtime!=''){
              return;
            }
            break;
          case 'leave':
            if(this.leave!=''){
              return;
            }
            break;
          case 'business':
            if(this.business!=''){
              return;
            }
            break;
          case 'outside':
            if(this.outside!=''){
              return;
            }
            break;
          case 'lateHour':
            if(this.lateHour!=''){
              return;
            }
            break;
          case 'earlyHour':
            if(this.earlyHour!=''){
              return;
            }
          case 'minerCount':
            if(this.minerCount!=''){
              return;
            }
            break;
          default:
            break;
        }
        let attMonth = this.dateYear.substr(0,4) + '-' +this.dateMonth;
        attMonth = attMonth.substr(0,attMonth.length-1);//传递时间处理
        // const loading = this.$loading();
        api(ApiList.h5GetMyStaticsByType,{attMonth:attMonth,type:type})
        .then((res)=>{
          if(res.data.errcode==0){
            let resp = res.data.data;
            switch (type) {
              case 'overtime':
                this.overtimeData = resp;
                break;
              case 'leave':
                this.leaveData = resp;
                break;
              case 'business':
                this.businessData = resp;
                break;
              case 'outside':
                this.outsideData = resp;
                break;
              case 'lateHour':
                this.lateHourData = resp;
                break;
              case 'earlyHour':
                this.earlyHourData = resp;
                break;  
              case 'minerCount':
                this.minerCountData = resp;
                break;
              default:
                break;
            }
          }else{
            this.msg = res.data.errmsg;
                        this.dialog = true;
          }
        },(error)=>{})
        // loading.close();
      },
      goback() {
        Android.closeActivity();//返回安卓上一页
      },
      toggle(panel) {
        this.panel = panel === this.panel ? '' : panel;
      },
      closeDialog(){
        this.dialog = false;
      },
      dateChange(value, index) {
        switch(index) {
          case 0:
            this.dateYear = value
            const arr = date[value]
            this.dateSlots[1].values = arr
            this.dateMonth = arr[0]
            break
          case 1:
            this.dateMonth = value
            break
        }
        this.date = [this.dateYear, this.dateMonth]
      },
      openBotttomSheet() {
        this.$store.commit('save', 0);
        this.dateSheet = true;
      },
      closeBotttomSheet() {
        this.dateSheet = false;
      },
      openMenu() {
        this.openScroll = true;
      },
      closeMenu() {
        this.openScroll = false;
      },
      goTo(name) {
        this.openScroll = false;
        this.$store.dispatch('openLoading')
        this.$router.push(name);
      }
    },
    components: {
      topBar,
    }
  }
</script>

<style lang="less" scoped>
  .container {
    padding: 0;
    height: 100%;
    background: #e6e6e6;
  }
  
  .mu-sub-header {
    padding: 5px 0;
  }
  .mu-appbar /deep/ .mu-appbar-title{
    font-size:1rem;
  }
  .mu-list {
    padding: 8px 0;
    width: 100%;
    position: relative;
    overflow-x: hidden;
    overflow-y: visible;
    background: #fff;
    margin: 10px 0;
    border-bottom: 1px solid #ccc;
    .mu-item-action {
      line-height: 32px;
      .mu-item-after-text {
        font-size: 16px;
      }
    }
  }
  
  .mu-divider {
    width: 95%;
    margin: 0 2.5%;
  }
  
  .mu-dialog-body {
    padding: 0;
  }
  
  // 自定义模板样式
  .mu-dialog-cus-list {
    border: none;
    margin: 0;
    padding: 0;
    border-radius: 10px;
    .mu-dialog-cus-item {
      border-bottom: 1px solid rgb(204, 204, 204);
      height: 50px;
      .mu-dialog-cus-item-title {
        height: 30px;
        line-height: 30px;
        color: #2196f3;
        font-weight: bold;
        text-align: center;
      }
    }
  }
  .mu-primary-color{
    background-color: #38ADFF;
  }
  .mu-overlay-cus {
    opacity: 0.4;
    background-color: rgb(0, 0, 0);
    position: fixed;
    z-index: 100000;
  }
  .mu-icon-button{
    padding: 0;
    width: 80px;
  }
</style>