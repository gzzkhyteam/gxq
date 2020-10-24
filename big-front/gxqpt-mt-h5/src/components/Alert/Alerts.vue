<template>
    <mu-dialog title="消息" width="360" :open.sync="this.$store.state.isAlert">
        {{this.$store.state.alertText}}
        <mu-button slot="actions" flat color="primary" @click="btn">确定</mu-button>
    </mu-dialog>
</template>

<script>
export default {
    props: {
        msg: {
            type: String,
            default: ''
        },
        onBtn: {
            type: Function,
            default: null
        },
    },
    data(){
        return{
            alertShow:this.$store.state.isAlert,
            alertMsg: this.$store.state.alertText
        }
    },
    created(){},
    methods:{
        btn(){
            if(this.onBtn){
                this.onBtn()
            }else{
                // this.$store.getters.isAlert=false;
                this.$store.state.isAlert = false;
            }
        }
    }
}
</script>

<style>

</style>
