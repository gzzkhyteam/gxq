<template>
	<div class="main">
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
			<div class="mu-appbar-title appbarRight">
				<div class="mu-appbar-title">{{title}}</div> 
			</div>
		</div>
		<mu-container ref="container">
			<mu-tabs @change="zd" :value.sync="tabActive" inverse color="#2196F3" indicator-color="#2196F3" center full-width style="position:fixed;top:54px;">
				<mu-tab>待审批({{applyTotal}})</mu-tab>
				<mu-tab>已审批({{isApplyTotal}})</mu-tab>
			</mu-tabs>
			<div class="demo-text" v-if="tabActive === 0">
                <mu-load-more v-if="applyArr.length!=0" :class="{refH:applyArr.length==0}" @refresh="refresh(apply)" :refreshing="refreshing" :loading="loading" @load="loadFuc(apply)" :loaded-all='applyNo'>
                    <mu-list v-if="!!applyArr" class="demoList" textline="three-line" style="background:#fff;">
                        <mu-list-item avatar :ripple="false" button @click="GoTo_Detalis(item,false)" v-for="(item, index) in applyArr" :key="index">
                            <mu-list-item-action>
                                <mu-avatar>
                                    <img v-if="!item.photo" src="../../assets/approverHeader.png">
                                    <img v-else :src="item.photo">
                                </mu-avatar>
                            </mu-list-item-action>
                            <mu-list-item-content>
                                <mu-list-item-title>{{item.applyUserName}}-{{aprTypeMap[item.aprType]}}申请</mu-list-item-title>
                                <mu-list-item-content>
                                    <mu-list-item-sub-title>
                                        <span style="color: rgba(0, 0, 0, .87)">申请时间：</span>{{item.createTime}}
                                    </mu-list-item-sub-title>
                                    <mu-list-item-sub-title>
                                        <span :class="{reviewTrue:review}">{{curStateMap[item.curState]}}</span>
                                    </mu-list-item-sub-title>
                                </mu-list-item-content>
                                <!-- <mu-list-item-action >
                                    <mu-list-item-after-text>{{item.createTime}}</mu-list-item-after-text>
                                </mu-list-item-action> -->
                            </mu-list-item-content>
                        </mu-list-item>
						<mu-divider></mu-divider>
                    </mu-list>
                </mu-load-more>
				<nullModal v-if="applyNoContent"></nullModal>
				<p class="noContent" v-if="applyNo">没有数据了</p>
			</div>
			<div class="demo-text" v-if="tabActive === 1">
				<mu-load-more v-if="isApplyArr.length!=0" :class="{refH:isApplyArr.length==0}" @refresh="refresh(isApply)" :refreshing="refreshing" :loading="loading" @load="loadFuc(isApply)" :loaded-all='isApplyNo'>
                    <mu-list v-if="!!isApplyArr" class="demoList" textline="three-line" style="background:#fff;">
                        <mu-list-item avatar :ripple="false" button @click="GoTo_Detalis(item,true)" v-for="(item, index) in isApplyArr" :key="index">
                            <mu-list-item-action>
                                <mu-avatar>
                                    <img v-if="!item.photo" src="../../assets/approverHeader.png">
                                    <img v-else :src="item.photo">
                                </mu-avatar>
                            </mu-list-item-action>
                            <mu-list-item-content>
                                <mu-list-item-title>{{item.applyUserName}}-{{aprTypeMap[item.aprType]}}申请</mu-list-item-title>
                                <mu-list-item-content>
                                    <mu-list-item-sub-title>
                                        <span style="color: rgba(0, 0, 0, .87)">申请时间：</span>{{item.createTime}}
                                    </mu-list-item-sub-title>
                                    <mu-list-item-sub-title>
                                        <span :class="{reviewTrue:review}">{{curStateMap[item.curState]}}</span>
                                    </mu-list-item-sub-title>
                                </mu-list-item-content>
                                <!-- <mu-list-item-action >
                                    <mu-list-item-after-text>{{item.createTime}}</mu-list-item-after-text>
                                </mu-list-item-action> -->
                            </mu-list-item-content>
                        </mu-list-item>
                    </mu-list>
                </mu-load-more>
				<nullModal v-if="isApplyNoContent"></nullModal>
				<p class="noContent" v-if="isApplyNo">没有数据了</p>
			</div>
			<mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
		</mu-container>
	</div>
</template>
<script>
import ApiList from "@/api/apiList";
import api from "@/api/axiosApi";
import nullModal from "@/components/nullModal";
import logInfo from "@/components/logInfo";
import imgObj from "../../assets/logo.png";
export default {
  name: "index",
  data() {
    return {
      tabActive: 0,
      apply: false,
      isApply: true,
      applyArr: [],
      isApplyArr: [],
      applyNoContent:false,
      isApplyNoContent:false,
      title: "我的审批",
      aprTypeMap: {
        overtime: "加班",
        leave: "请假",
        business: "出差",
        outside: "外勤",
        supply: "补签"
      },
      curStateMap: {
        "1": "审批中",
        "2": "已驳回",
        "3": "已结束",
        "4": "撤销中",
        "5": "已撤销"
      },
      showBack: false,
      loading: false,
      refreshing: false,
      review: true,
      applyPages: 1, //总页数
      isApplyPages: 1,
      applyPageNum: 1, //当前页
      isApplyPageNum: 1,
      applyTotal: 0,
      isApplyTotal: 0,
      scrollTops: true,
      applyNo: false,
      isApplyNo: false,
      msg: "",
      dialog: false
    };
  },
  updated() {
    if (this.scrollTops) {
      this.$nextTick(function() {
        let position = this.$store.state.positionY; //返回页面取出来
        window.scroll(0, position);
      });
    }
  },
  beforeRouteLeave(to, from, next) {
    let position = document.documentElement.scrollTop;
    this.$store.commit("save", position);
    // 设置列表缓存
    next();
  },
  beforeRouteEnter(to, from, next) {
    if (from.name == "MyAttendance") {
      next(vm => {
        vm.$store.state.myReviewBack = true; //保存来源地址
      });
    }
    next();
  },
  mounted() {
    this.$store.dispatch("closeLoading", false);
    //初始化
    this.init();
  },
  methods: {
    init() {
      this.getApplyData(this.apply); //未审批数据
      this.getApplyData(this.isApply); //已审批数据
    },
    GoTo_Detalis(item, type) {
      this.$store.dispatch("openLoading");
      this.$router.push({
        name: "ReviewDetail",
        params: { log: JSON.stringify(item), type: type }
      });
    },
    zd() {
      //切换标签置顶
      window.scroll(0, 0);
    },
    refresh(type) {
      if (type) {
        this.isApplyArr = [];
        this.isApplyPageNum = 1;
        this.isApplyNoContent = false;
      } else {
        this.applyArr = [];
        this.applyPageNum = 1;
        this.applyNoContent = false;
      }
      this.refreshing = true;
      this.getApplyData(type);
    },
    loadFuc(type) {
      if (document.documentElement.scrollTop == 0) {
        if (
          document.body.scrollTop +
            document.documentElement.scrollHeight +
            100 >=
          document.body.scrollHeight
        ) {
          console.log("进来");
          this.load(type);
        }
      } else {
        this.load(type);
      }
    },
    load(type) {
      this.scrollTops = false;
      if (type) {
        //判断不同类型，类型不同总页数
        if (this.isApplyPageNum < this.isApplyPages) {
          this.loading = true;
          this.isApplyPageNum++;
          this.getApplyData(type);
        } else {
          this.isApplyNo = true;
        }
      } else {
        if (this.applyPageNum < this.applyPages) {
          this.loading = true;
          this.applyPageNum++;
          this.getApplyData(type);
        } else {
          this.applyNo = true;
        }
      }
    },
    getApplyData(type) {
      let openApiReq = {
        data: {
          aprType: "",
          curState: "",
          endCreateTime: "",
          isFromMe: false,
          startCreateTime: ""
        },
        pageNo: 1,
        pageSize: 10
      };
      type
        ? (openApiReq.pageNo = this.isApplyPageNum)
        : (openApiReq.pageNo = this.applyPageNum);
      openApiReq.data = { ...openApiReq.data, isPassMe: type };
      setTimeout(() => {
        api(ApiList.findPageCurSendMeApplyList, openApiReq).then(
          res => {
            if (res.data.errcode == 0) {
              if (type) {
                this.isApplyArr = this.isApplyArr.concat(res.data.data.list);
                if(this.isApplyArr.length === 0){
                  this.isApplyNoContent = true
                }
                this.isApplyPages = res.data.data.pages;
                this.isApplyPageNum = res.data.data.pageNum;
                this.isApplyTotal = res.data.data.total;
              } else {
                this.applyArr = this.applyArr.concat(res.data.data.list);
                if(this.applyArr.length === 0){
                  this.applyNoContent = true
                }
                this.applyPages = res.data.data.pages;
                this.applyPageNum = res.data.data.pageNum;
                this.applyTotal = res.data.data.total;
              }
            } else if (
              res.data["errcode"] == 40001 ||
              res.data["errcode"] == 40003 ||
              res.data["errcode"] == 40005
            ) {
              this.getApplyData(type);
            } else {
              this.msg = res.data.errmsg;
              this.dialog = true;
            }
          },
          error => {
            if (type) {
              this.isApplyNoContent = true
            }else{
              this.applyNoContent = true
            }
          }
        );
        this.loading = false;
        this.refreshing = false;
      }, 500);
    },
    closeDialog() {
      this.dialog = false;
    },
    goback() {
      console.log(this.$store.state.myReviewBack);
      if (!this.$store.state.myReviewBack) {
        Android.closeActivity();
      } else {
        this.$store.dispatch("openLoading");
        this.$router.isBack = true;
        this.$router.go(-1);
      }
    }
  },
  components: {
    nullModal,
    logInfo
  }
};
</script>
<style lang=less scoped>
.container {
  padding: 0;
  height: 100%;
  .demo-text {
    padding: 0;
    padding-top: 104px;
    height: 100%;
    .noContent {
      padding: 7px 0;
      background: #fff;
      color: #797979;
      margin-top: 0;
    }
  }
  .demoList li {
    background: #fff;
    padding: 8px 0;
  }
  .mu-item-content {
    position: relative;
    .mu-item-action {
      position: absolute;
      right: 0;
      top: -40%;
    }
  }
  .reviewTrue {
    color: #1ad517;
  }
  .refH {
    height: 350px;
  }
}
.mu-appbar {
  /* position: fixed; */
  top: -2px;
  left: 0;
  z-index: 1000;
  width: 100%;
}
.mu-primary-color {
  background-color: #38adff;
}
.mu-appbar-title {
  width: 100%;
  font-size: 1rem;
  text-align: center;
}
.mu-button-wrapper {
  font-size: 1rem;
  color: #fff;
}
.mu-icon-button {
  /*padding:0;
		width: 80px;*/
}
.appbarRight {
  margin-right: 6rem;
}
</style>