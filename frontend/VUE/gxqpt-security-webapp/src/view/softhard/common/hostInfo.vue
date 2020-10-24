<!-- 主机信息组件 -->
<template>
    <Card>
        <p slot="title">主机信息：</p>
        <Table :columns="columns" :data="data" :border='true' class="access-list"></Table>
    </Card>
</template>

<script>
import api from '@/api/axiosApi'
import softhardApiList from '@/api/softhardApiList'
export default {
    data(){
        return{
            columns: [{ //列表表头数据
                    type: 'index',
                    title: '序号',
                    width: 60,
                    align: 'center'
                },
                {
                    title: '主机IP',
                    key: 'ip'
                },
                {
                    title: '所属集群',
                    key: 'cluster'
                },
                {
                    title: '型号',
                    key: 'model'
                },
                {
                    title: '处理器类型',
                    key: 'cpuType'
                },
                {
                    title: '处理器数量',
                    key: 'cpuCount',
                    width: 110
                },
                {
                    title: '网卡数量',
                    key: 'netcardCount',
                    width: 110
                },
                {
                    title: '内存',
                    key: 'memory',
                    width: 110
                },
                {
                    title: '磁盘大小',
                    key: 'diskSize',
                    width: 110
                },
            ],
            data: [], //表格数据
        }
    },
    mounted(){
        if(!this.$route.params.departData){//配置高新翼云跳转过来的数据
            this.$route.params.departData = {};
            this.$route.params.departData.id = this.$route.params.keyid;
        }
        this.getAddHostByApplyId();
    },
    methods:{
        getAddHostByApplyId() { // 审批列表数据查询
            this.data = [];
            let keyid = this.$route.params.departData.id;
            api(softhardApiList.getAddHostByApplyId, {
                "keyid": keyid
            }).then((res) => {
                if(res.status == 200 && res.data.data) {
                    this.data = res.data.data;
                }
            }, (err) => {
                //dong something...
            })
        },
    }
}
</script>

<style>

</style>
