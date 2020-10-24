<template>
    <div class="loadBox" v-show="loading.show">
        <mu-circular-progress class="demo-circular-progress" :size="45" :stroke-width="5">加载中…</mu-circular-progress>
    </div>
</template>

<script>
export default {
    name:"loading",
    data(){
        return{}
    },
    created(){},
    computed: {
      loading () {
        return {
          show: this.$store.getters.isLoading,
        }
      }
    },
}
</script>

<style lang="less" scoped>
.loadBox{
    width:100%;
    height:100%;
    background: #fbfbfb;
    opacity: 0.7;
    position: fixed;
    top:0;
    z-index: 10000;
}
.loadBox /deep/ .mu-circle-spinner{
    position: fixed;
}
.mu-circular-progress{
    top:30%;
}
</style>
