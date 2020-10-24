<template>
    <mu-list-item avatar :ripple="false" button>
        <mu-list-item-action>
            <mu-avatar>
                <img src="../assets/approverHeader.png">
            </mu-avatar>
        </mu-list-item-action>
        <mu-list-item-content>
            <mu-list-item-title>张三-加班申请</mu-list-item-title>
            <mu-list-item-content>
                <mu-list-item-sub-title>
                    <span style="color: rgba(0, 0, 0, .87)">加班人：</span>张三
                </mu-list-item-sub-title>
                <mu-list-item-sub-title>
                    <span style="color: rgba(0, 0, 0, .87)">开始时间：</span>2018-06-01 18:30
                </mu-list-item-sub-title>
                <mu-list-item-sub-title>
                    <span style="color: rgba(0, 0, 0, .87)">结束时间：</span>2018-06-01 23:30
                </mu-list-item-sub-title>
                <mu-list-item-sub-title>
                    <span :class="{reviewTrue:review}">审批通过</span>
                </mu-list-item-sub-title>
            </mu-list-item-content>
            <mu-list-item-action >
                <mu-list-item-after-text>2018/06/01</mu-list-item-after-text>
            </mu-list-item-action>
        </mu-list-item-content>
    </mu-list-item>
</template>

<script>
export default {

}
</script>

<style lang="less" scoped>

</style>
