<template>
    <mu-container>
        <top-bar style="z-index:10000" :title="title"></top-bar>
        <mu-list v-if="department.length!=0" toggle-nested>
            <mu-list-item button :ripple="false" nested :key="index" v-for="(item,index) in department" :open="open === item.id" @toggle-nested="open = arguments[0] ? item.id : ''">
                <mu-list-item-action>
                    <mu-icon value="supervisor_account"></mu-icon>
                </mu-list-item-action>
                <mu-list-item-title>{{item.name}}（{{item.empList.length}}人）</mu-list-item-title>
                <mu-list-item-action>
                    <mu-icon class="toggle-icon" size="24" value="keyboard_arrow_down"></mu-icon>
                </mu-list-item-action>
                <mu-list-item button :ripple="false" slot="nested" :key="index" v-for="(empItem,index) in item.empList">
                   <mu-flex class="select-control-row">
                        <mu-checkbox :value="empItem" v-model="chance" :label="empItem.name" @change="changeItem"></mu-checkbox>
                    </mu-flex>
                </mu-list-item>
            </mu-list-item>
        </mu-list>
        <nullModal v-if="department.length==0"></nullModal>
        <!-- <div class="select-control-group" >
            <mu-flex class="select-control-row">
                <mu-checkbox label="全选"></mu-checkbox>
            </mu-flex>
            <mu-flex class="select-control-row" :key="index" v-for="(item,index) in firstData">
                <mu-checkbox :value="item.name" v-model="chance" :label="item.name"></mu-checkbox>
                <div class="openSelect" @click="openSelect"><i data-v-73d7c3cd="" class="mu-icon material-icons" style="user-select: none;">keyboard_arrow_right</i></div>
            </mu-flex>
        </div> -->
        <div class="chanceUser">
            <div class="list">已选择:{{this.chance.length}}</div>
            <mu-button color="primary" @click="returnLogForm">发送</mu-button>
        </div>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </mu-container>
</template>

<script>
import topBar from '@/components/topBar'
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import eventBus from '@/public/eventBus.js';
import nullModal from '@/components/nullModal';
export default {
    data () {
        return {
            title:"抄送人",
            open:'',
            chance:[],
            department:[],
            msg:'',
            dialog:false,
        }
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        (this.$route.params.type==1)? this.title= '审批人' : this.title='抄送人'
        this.getPhoneByUserId();
    },
    methods:{
        getPhoneByUserId(){
            const byUserId = this.$store.state.userInfo.userId;
            api(ApiList.getTreeEmpPhoneByUserId,{userId:byUserId})
                .then((res)=>{
                    if(res.data.errcode==0){
                        for(var i = 0;i<res.data.data.length;i++){
                            this.department = this.department.concat(res.data.data[i].deptList);
                            this.department.map(item=>{//排除自己
                                item.empList.forEach((element,index) => {
                                    if(byUserId == element.gxqptEmpId){
                                        item.empList.splice(index,1)
                                    }
                                });
                            })
                        }
                    }else{
                        this.msg = res.data.errmsg;
                        this.dialog = true;
                    }
                },(error)=>{
                    this.msg = error.message;
                    this.dialog = true;
                }
            ) 
        },
        returnLogForm(){
            //传递一个map，historyData是key
            eventBus.$emit('chance',JSON.stringify(this.chance));
            this.$store.dispatch('openLoading')
            //调用router回退页面
            this.$router.go(-1);
            // console.log(this.$route.params.backUrl);
            // this.$router.push({
            //     name:this.$route.params.backUrl,
            //     params:{chance:JSON.stringify(this.chance)}
            // });
        },
        closeDialog(){
            this.dialog = false;
        },
        changeItem(){
            if(this.$route.params.type==1){
                //传递一个map，historyData是key
                eventBus.$emit('chanceApproval',JSON.stringify(this.chance));
                this.$store.dispatch('openLoading')
                //调用router回退页面
                this.$router.go(-1);
                // this.$router.push({
                //     name:this.$route.params.backUrl,
                //     params:{chanceApproval:JSON.stringify(this.chance)}
                // });
            }else{
            }
        }
    },
    components:{
        topBar,
        nullModal
    }
}
</script>

<style lang="less" scoped>
.container{
    padding:0;
}
.select-control-group{
    background: #fff;
    margin: 60px 0;
    .select-control-row{
        position: relative;
        padding:16px;
        border-bottom:1px solid #ccc;
        .openSelect{
            position: absolute;
            right:1rem;
            top: 0;
            padding: 1rem 0 1rem 6rem;
        }
    }
}
.mu-list{
    background: #fff;
}
.chanceUser{
    position: fixed;
    bottom:0;
    width:100%;
    height:50px;
    background: #fff;
    border-top:1px solid #ccc;
    .list{
        min-width:50%;
        height:50px;
        line-height: 50px;
        text-align: left;
        padding:0 10px;
        float: left;
    }
    button{
        float: right;
        height:40px;
        margin:5px 0;
        margin-right:10px;
    }
}
</style>
