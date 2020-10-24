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
			<div class="mu-appbar-title appbarRight">
				<div class="mu-appbar-title">{{title}}</div> 
			</div>
		</div>
        <mu-load-more v-if="findApprApplyPage.length!=0" style="padding-top:54px;" :class="{refH:findApprApplyPage.length==0}" @refresh="refresh" :refreshing="refreshing" :loading="loading" @load="loadFuc" :loaded-all='findApprApplyPageNo'>
            <mu-list textline="two-line">
                <mu-list-item v-for="(item,idx) in findApprApplyPage" :key="idx" avatar :ripple="true" button @click="goTo(item)">
                    <mu-list-item-content>
                        <mu-list-item-title>{{aprTypeMap[item.aprType]}}申请</mu-list-item-title>
                        <mu-list-item-sub-title>{{curStateMap[item.curState]}}</mu-list-item-sub-title>
                    </mu-list-item-content>
                    <mu-list-item-action >
                        <mu-list-item-title>{{item.createTime}}</mu-list-item-title>
                        <mu-list-item-after-text>审批人：{{item.curAprUserName}}</mu-list-item-after-text>
                    </mu-list-item-action>
                </mu-list-item>
            </mu-list>
            <!-- <p class="noContent" v-if="findApprApplyPage.length==0">暂无内容</p> -->
        </mu-load-more>
        <nullModal v-if="noContent"></nullModal>
        <p class="noContent" v-if="findApprApplyPageNo">没有数据了</p>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </mu-container>
</template>

<script>
import ApiList from "@/api/apiList";
import api from "@/api/axiosApi";
import nullModal from "@/components/nullModal";
export default {
  data() {
    return {
      title: "申请记录",
      openApiReq: {
        data: {
          isFromMe: true
        },
        pageNo: 1,
        pageSize: 20
      },
      pageNo: 1,
      refreshing: false,
      loading: false,
      findApprApplyPageNo: false,
      msg: "",
      dialog: false,
      scrollTops: true,
      Pages: 1,
      findApprApplyPage: [],
      noContent: false,
      aprTypeMap: {
        overtime: "加班",
        leave: "请假",
        business: "出差",
        outside: "外勤",
        supply: "补签"
      },
      curStateMap: {
        1: "审批中",
        2: "已驳回",
        3: "已结束",
        4: "撤销中",
        5: "已撤销"
      }
    };
  },
  updated() {
    console.log(this.$store.state.positionY);
    if (this.scrollTops) {
      this.$nextTick(function() {
        let position = this.$store.state.positionY; //返回页面取出来
        console.log(position);
        window.scroll(0, position);
      });
    }
  },
  beforeRouteLeave(to, from, next) {
    let position = document.documentElement.scrollTop;
    console.log(position);
    this.$store.commit("save", position);
    // 设置列表缓存
    next();
  },
  mounted() {
    this.$store.dispatch("closeLoading", false);
    this.getFindApprApplyPage(); //获取列表
  },
  methods: {
    getFindApprApplyPage() {
      api(ApiList.getFindApprApplyPage, this.openApiReq).then(
        res => {
          if (res.data.errcode == 0) {
            this.findApprApplyPage = this.findApprApplyPage.concat(
              res.data.data.list
            );
            if(this.findApprApplyPage.length === 0){
              this.noContent = true;
            }
            this.Pages = res.data.data.pages;
          } else {
            this.msg = res.data.errmsg;
            this.dialog = true;
          }
        },
        error => {
          this.noContent = true;
        }
      );
      this.$nextTick(function() {
        this.refreshing = false;
        this.loading = false;
      });
    },
    refresh() {
      this.openApiReq.pageNo = 1;
      this.findApprApplyPage = [];
      this.refreshing = true;
      this.noContent = false;
      this.getFindApprApplyPage();
    },
    loadFuc() {
      if (document.documentElement.scrollTop == 0) {
        if (
          document.body.scrollTop +
            document.documentElement.scrollHeight +
            100 >=
          document.body.scrollHeight
        ) {
          console.log("进来");
          this.load();
        }
      } else {
        this.load();
      }
    },
    load() {
      this.scrollTops = false;
      console.log(this.openApiReq.pageNo);
      if (this.openApiReq.pageNo < this.Pages) {
        (this.loading = true), this.openApiReq.pageNo++;
        this.getFindApprApplyPage();
      } else {
        this.findApprApplyPageNo = true;
      }
    },
    goTo(item) {
      this.$store.dispatch("openLoading");
      this.$router.push({
        name: "ApplyDetail",
        params: { detail: JSON.stringify(item) }
      });
    },
    closeDialog() {
      this.dialog = false;
    },
    goback() {
      this.$store.dispatch("openLoading");
      this.$router.go(-1);
    }
  },
  components: {
    nullModal
  }
};
</script>

<style lang="less" scoped>
.container {
  padding: 0;
  height: 100%;
  background: #e6e6e6;
}
.refH {
  height: 350px;
  background: #fff;
}
.mu-list {
  padding: 0;
  background: #fff;
  padding: 10px 0;
  li {
    border-bottom: 1px solid #ccc;
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
