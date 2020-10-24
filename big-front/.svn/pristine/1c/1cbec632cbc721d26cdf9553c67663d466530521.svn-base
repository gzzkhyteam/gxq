<template>
    <div>
        <li @click="_click(commentList.id)">
            <a class="mu-item-wrapper">
                <div class="mu-item  has-avatar">
                    <mu-list-item-action>
                        <mu-avatar>
                            <img v-if="!!commentList.photo" :src="commentList.photo">
                            <!-- <img v-if="!!commentList.photo" :src="commentList.photo"> -->
                        </mu-avatar>
                    </mu-list-item-action>
                    <mu-list-item-content style="position:relative">
                        <mu-list-item-title>{{commentList.createUser}}</mu-list-item-title>
                        <span class="dateP">{{commentList.createTime}}</span>
                        <mu-list-item-sub-title>{{commentList.content}}</mu-list-item-sub-title>
                    </mu-list-item-content>
                    <!-- <mu-list-item-action>
                        <mu-list-item-after-text>{{commentList.createTime}}</mu-list-item-after-text>
                    </mu-list-item-action> -->
                </div>
            </a>
        </li>
        <mu-divider></mu-divider>
    </div>
</template>

<script>
import approverHeader from '../../assets/approverHeader.png';
export default {
    props:{
        commentList:Object
    },
    beforeMount(){
        if(this.commentList.photo==''){
            this.commentList.photo=approverHeader;
        }
    },
    methods:{
        _click: function (id) {
            this.$emit('click', function (callback) {
                return callback(id);
            })
        }
    }
}
</script>

<style lang="less" scoped>
.mu-item{
    min-height: 88px;
    overflow: hidden;
    height: auto;
    padding:10px 16px;
    .mu-item-sub-title, .mu-item-title{
        overflow: inherit;
        white-space: normal;
        -webkit-line-clamp: none;
        -webkit-box-orient: initial;
    }
}
.dateP{
    position: absolute;
    font-size: 12px;
    color: #ccc;
    top: 3px;
    right: 1rem;
}
.mu-item-content{
    width: 30%;
}
</style>
