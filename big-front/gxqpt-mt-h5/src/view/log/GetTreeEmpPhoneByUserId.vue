<template>
    <mu-container>
        <top-bar style="z-index:10000" :title="title"></top-bar>
        <mu-list>
            <mu-list-item @click="openSelect(item.deptList)" button :ripple="false" :z-depth="2" :key="index" v-for="(item,index) in firstData">
                <mu-list-item-title>{{item.name}}</mu-list-item-title>
                <div class="mu-item-action">
                    <div class="openSelect"><i class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_right</i></div>
                </div>
            </mu-list-item>
        </mu-list>
        <!-- <div class="select-control-group" > -->
            <!-- 包含选项框的单位列表 -->
            <!-- <mu-flex class="select-control-row" :key="index" v-for="(item,index) in firstData">
                <mu-checkbox :value="item.name" v-model="chance" :label="item.name"></mu-checkbox>
                <div class="openSelect" @click="openSelect(item)"><i data-v-73d7c3cd="" class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_right</i></div>
            </mu-flex> -->
        <!-- </div> -->
    </mu-container>
</template>

<script>
import topBar from '@/components/topBar'
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
export default {
    data () {
        return {
            title:"抄送人",
            open:'',
            open1:'',
            chance:[],
            firstData:[],
            department:[],
            empList:[]

        }
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        this.getPhoneByUserId();
    },
    created(){
        console.log(this.$route.params.backUrl);
    },
    methods:{
        getPhoneByUserId(){
            api(ApiList.getTreeEmpPhoneByUserId,{userId:this.$store.state.userInfo.userId})
                .then((res)=>{
                    if(res.data.errcode==0){
                        this.firstData = res.data.data;
                    }
                },(error)=>{}
            ) 
        },
        openSelect(item){
            this.$router.push({
                name:'getTreeEmpPhoneByUserIdItem',
                params:{item:JSON.stringify(item),backUrl:this.$route.params.backUrl}
            });
        }
    },
    components:{
        topBar,
    }
}
</script>

<style lang="less" scoped>
.container{
    padding:0;
}
.mu-list{
    padding: 8px 0 30px 0;
    width: 100%;
    position: relative;
    overflow-x: hidden;
    overflow-y: visible;
    li{
        background: #fff;
        border-top: 1px solid #eee;
        border-bottom: 1px solid #eee;
    }
    .mu-item{
        height:auto;
        min-height:48px;
        background: #fff;
        padding:0;
    }
    .mu-item-title{
        font-size:1rem;
    }
    .mu-item-action{
        width:110px;
        min-width:110px;
        position:relative;
        line-height: 32px;
        .mu-item-after-text{
            font-size:1rem;
        }
    }
}
.select-control-group{
    background: #fff;
    margin: 60px 0;
    .select-control-row{
        position: relative;
        padding:16px;
        border-bottom:1px solid #ccc;
    }
}
.openSelect{
    position: absolute;
    top:12px;
}
</style>
