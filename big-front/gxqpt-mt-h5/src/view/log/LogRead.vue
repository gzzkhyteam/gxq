<template>
    <mu-container>
        <top-bar style="z-index:10000" :title="title"></top-bar>
        <mu-tabs style="background:#fff;" :value.sync="isRead" inverse color="blue" full-width indicator-color="blue" text-color="rgba(0, 0, 0, .54)" center>
            <mu-tab>已读 {{getchance1.length}}</mu-tab>
            <mu-tab>未读 {{getchance2.length}}</mu-tab>
        </mu-tabs>
        <div class="readBox" v-if="isRead === 0">
            <Approver :addPeo='false' :chance="getchance1" :name='false'></Approver>
        </div>
        <div class="readBox" v-if="isRead === 1">
            <Approver :addPeo='false' :chance="getchance2" :name='false'></Approver>
        </div>
    </mu-container>
</template>

<script>
import topBar from '@/components/topBar';
import Approver from '@/components/approver/approver'
export default {
    data(){
        return{
            title:"日志详情",
            isRead:0,
            getchance1:JSON.parse(this.$route.params.getchance1),
            getchance2:JSON.parse(this.$route.params.getchance2)
        }
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
    },
    components:{
        topBar,
        Approver
    }
}
</script>

<style lang="less" scoped>
.container {
    padding: 0;
}
</style>
