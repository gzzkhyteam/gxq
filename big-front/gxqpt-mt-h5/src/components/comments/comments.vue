<template>
    <mu-paper :z-depth="1" class="demo-list-wrap">
        <mu-list textline="three-line">
            <mu-sub-header style="text-align:left">评论</mu-sub-header>
            <comList @click="_click" :commentList="commentList" v-for="(commentList,index) in commentsArr" :key="index"></comList>
        </mu-list>
    </mu-paper>
</template>

<script>
import comList from "./commentsList"
export default {
    data (){
        return{
            returnId:''
        }
    },
    props:{
        commentsArr:Array,
    },
    methods:{
        _click: function (func) {
            var pro = '';
            func(function(rea){
                pro=rea;
            })
            this.$emit('click', function (callback) {
                return callback(pro)
            })
        }
    },
    components:{
        comList,
    }
}
</script>

<style scoped>
.mu-paper{
    padding-bottom:3.5rem;
}
</style>
