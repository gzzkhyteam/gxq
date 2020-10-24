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
            <div class="mu-appbar-title appbarRight">
                <div class="mu-appbar-title">{{title}}</div> 
            </div>
        </div>
         <mu-load-more v-if="ClockInListData.length!=0" :class="{refH:ClockInListData.length==0}" @refresh="refresh" :refreshing="refreshing" :loading="loading" @load="loadFuc">
            <mu-list textline="two-line" style="padding-top:50px;">
                <mu-list-item avatar :ripple="true" button v-for="(item,index) in ClockInListData" :key="index">
                    <mu-list-item-content>
                        <mu-list-item-title>{{ adceType[item.adceType] }}{{ clockType[item.clockType] }}</mu-list-item-title>
                        <mu-list-item-sub-title>{{ item.location }}</mu-list-item-sub-title>
                    </mu-list-item-content>
                    <mu-list-item-action >
                        <mu-list-item-after-text>{{ item.clockTime }}</mu-list-item-after-text>
                    </mu-list-item-action>
                </mu-list-item>
            </mu-list>
         </mu-load-more>
         <nullModal v-if="ClockInListData.length==0"></nullModal>
         <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </mu-container>
</template>

<script>
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import nullModal from '@/components/nullModal';
export default {
    data () {
        return{
            title:"打卡记录",
            ClockInListData:[],
            clockType:{1:'签到',2:'签退'},
            adceType:{1:'内勤',2:'外勤'},
            loading: false,
            refreshing: false,
            pageNo:1,
            pages:1,
            msg:'',
            dialog:false
        }
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        this.getFindPunchclockPage();//获取列表
    },
    methods:{
        goback() {
            this.$router.go(-1);
        },
        getFindPunchclockPage(){
            let openApiReq = {
                "data": {
                    "fromApp": true,
                },
                "pageNo": this.pageNo,
                "pageSize": 20
            };
            api(ApiList.getFindPunchclockPage,openApiReq)
				.then((res)=>{
					if(res.data.errcode==0){
                        this.ClockInListData = this.ClockInListData.concat(res.data.data.list);
                        this.pages = res.data.data.pages;
					}else{
                        this.msg = res.data.data.errmsg;
                        this.dialog = true;
					}
				},(error)=>{})
				this.$nextTick(function(){
                    this.refreshing = false;
                    this.loading = false;
                })
        },
        refresh(){
            this.refreshing = true;
            this.pageNo = 1;
            this.ClockInListData = [];
            this.getFindPunchclockPage();
        },
        loadFuc(){
            if(document.documentElement.scrollTop == 0){
                if((document.body.scrollTop + document.documentElement.scrollHeight + 100) >= document.body.scrollHeight){
                    console.log("进来");
                    this.load();
                }
            }else{
                this.load();
            }
        },
        load () {
            if(this.pageNo < this.pages){
                this.loading = true;
                this.pageNo ++;
                this.getFindPunchclockPage();
            }else{
                this.$toast.warning('已没有更多数据')
            }
        },
        closeDialog(){
            this.dialog = false;
        }
    },
    components:{
        nullModal
    }
}
</script>

<style lang="less" scoped>
.container{
    padding:0;
    .mu-list{
        padding:0;
        background: #fff;
        margin: 10px 0;
        li{
            border-bottom: 1px solid #ccc;
        }
    }
    .refH{
        height:350px;
    }
}
.mu-list-two-line /deep/ .mu-item{
    height:auto;
    min-height:72px;
    padding:1rem;
}
.mu-item-sub-title, .mu-item-title{
    white-space: unset;
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
