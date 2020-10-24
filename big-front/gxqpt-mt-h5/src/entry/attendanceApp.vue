<template>
  <div id="atten">
    <!-- <transition name="router-fade" mode="out-in"> -->
    <transition :name="transitionName"> 
      <keep-alive>
        <router-view class="router" v-if="$route.meta.keepAlive"></router-view>
      </keep-alive>
    </transition>
    <!-- <transition name="router-fade" mode="out-in"> -->
    <transition :name="transitionName"> 
      <router-view class="router" v-if="!$route.meta.keepAlive"></router-view>
    </transition>
    <Alerts></Alerts>
    <Loading></Loading>
    <mu-snackbar :color="snackbarColor" position="top" :open.sync="!!this.msg.text.trim()">
        {{this.msg.text}}
        <mu-button flat slot="action" color="#fff" @click="closeSnackbar">关闭</mu-button>
    </mu-snackbar>
  </div>
</template>
<script>
import ApiList from '@/api/apiList'
import Alerts from '@/components/Alert/Alerts'
import Loading from '@/components/loading/Loading';
import { mapState,mapMutations } from 'vuex'
export default {
  data(){
    return{
      transitionName: 'slide-left',
    }
  },
  watch: {
    '$route' (to, from) {
      let isBack = this.$router.isBack  //  监听路由变化时的状态为前进还是后退
      if(isBack) {
        this.transitionName = 'slide-right'
      } else {
        this.transitionName = 'slide-left'
      }
　　this.$router.isBack = false
　　}
　},
  created (){
    this.getUserInfo();//获取userid和token
  },
  methods:{
    isAndr() {//判断设备是否为安卓
      var u = navigator.userAgent;
      if (u.indexOf('Android') > -1) {
        return true
      } else {
        return false
      }
    },
    closeSnackbar(){
      this.setMsg({text:'',type:0});
    },
    ...mapMutations([
      'setMsg',
      'getUserInfo'
    ])
  },
  computed: {
    snackbarColor:function(){
      var colors= ['','success','info','warning','error'];
      console.log(colors[this.msg.type]);
      setTimeout(()=>{
        this.msg.text && this.closeSnackbar();
      },3000);
      return colors[this.msg.type];
    },
    ...mapState([
      'msg'
    ])
  },
  components:{
    Alerts,
    Loading,
  }
}
</script>
<style lang="less">
#atten {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height:100%;
}
.container{
    padding:0;
}
.router {  
     position: absolute;  
     width: 100%; 
     height:100%;
    //  transition: all .8s ease;  
}  
.slide-left-enter-active {
  transition: all .5s ease;
}
.slide-left-leave-active {
  transition: all .5s ease  ;
}
.slide-left-enter, 
/* .slide-fade-leave-active for below version 2.1.8 */ {
  transform: translateX(95%);
  opacity: 0;
}
.slide-left-leave-to{
 transform: translateX(-95%);
  opacity: 0;
}

.slide-right-enter-active {
  transition: all .5s ease;
}
.slide-right-leave-active {
  transition: all .5s ease  ;
}
.slide-right-enter, 
/* .slide-fade-leave-active for below version 2.1.8 */ {
  transform: translateX(-95%);
  opacity: 0;
}
.slide-right-leave-to{
    transform: translateX(95%);
    opacity: 0;
}  
</style>
