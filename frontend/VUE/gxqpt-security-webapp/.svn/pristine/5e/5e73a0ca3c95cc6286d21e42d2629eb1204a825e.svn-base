<template>
    <div class="ivu-layout serviceDetail">
        <Row style="margin-bottom: 15px; text-align: right;">
            <Col span="24">
                <Button type="primary" @click="$router.go(-1)">返回</Button>
            </Col>
        </Row>
        <trainDetailCard :detail="detail"></trainDetailCard>
        <dealDetailCard :detail="detail" v-if="detail.status === 2 || detail.status === 3 || detail.status === 5"></dealDetailCard>
        <overDetailCard :detail="detail" v-if="detail.status === 3 || detail.status === 5"></overDetailCard>
        <trainPointCard :detail="detail" v-if="detail.status === 5"></trainPointCard>
        <trainFilesCard :detail="detail" v-if="showFile"></trainFilesCard>
    </div>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
import trainDetailCard from "./trainCard/trainDetailCard.vue";
import dealDetailCard from "./trainCard/dealDetailCard.vue";
import trainPointCard from "./trainCard/trainPointCard.vue";
import trainFilesCard from "./trainCard/trainFilesCard.vue";
export default {
    components: {
        trainDetailCard,
        dealDetailCard,
        trainPointCard,
        trainFilesCard
    },
    data(){
        return{
            detail: {},
            showFile: false
        }
    },
    mounted () {
        this.getDetail()
    },
    methods:{
        getDetail() {
            const vm = this
            api(operationApiList.trainDetail, {
                id: vm.$route.params.id
            })
            .then(res => {
                if (res.data.errcode === 0) {
                    vm.detail = res.data.data
                    if (vm.detail.files.length > 0) {
                      vm.showFile = true
                    }
                }
            }, error => {console.log(error)})
        },
        goback(){
            this.$router.go(-1)
        }
    }
}
</script>

<style lang='less' scoped>
.serviceDetail{
    background:#eee;
    padding: 20px;
    width:80%;
    height:auto;
}
</style>
