<template>
  <Layout>
    <hengyun-header :title="{chinese: '预警管理系统', english: 'WARN MANAGEMENT SYSTEM'}"></hengyun-header>
    <Layout class="ivu-layout-has-sider" v-if="menus.length > 0">
      <hengyun-sidebar :menus="menus"/>
      <router-view v-if="isRouterAlive"></router-view>
    </Layout>
  </Layout>
</template>
<script>
import api from '@/api/axiosApi'
import apiList from '@/api/comApiList'
import {mapState} from 'vuex'
// 头部
import header from '@/components/hengyun/header'
// 侧边栏
import siderBar from '@/components/hengyun/sideBar'

// const menus = [{
//   name: '首页',
//   link: '/home'
// }, {
//   name: '预警台账',
//   link: '/ledgerList'
// }, {
//   name: '预警处理台账',
//   link: '/ledgerDeal'
// }, {
//   name: '预警处理结果台账',
//   link: '/ledgerResult'
// }, {
//   name: '预警类型维护',
//   link: '/ledgerMaintenance'
// }, {
//   name: '预警情况分析',
//   subMenu: [{
//     name: '个人预警分析',
//     link: '/personnelAnalyzeView'
//   }, {
//     name: '部门预警分析',
//     link: '/departmentWarnAnalyzeView'
//   }, {
//     name: '应用预警分析',
//     link: '/applicationWarnAnalyze'
//   }]
// }]

export default {
  name: 'warnapp',
  components: {
    'hengyun-sidebar': siderBar,
    'hengyun-header': header
  },
  provide(){
    return {
      reload:this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true,
      isCollapsed: false,
      menus: []
    }
  },
  computed: {
    rotateIcon() {
      return [
        'menu-icon',
        this.isCollapsed ? 'rotate-icon' : ''
      ]
    },
    menuitemClasses() {
      return [
        'menu-item',
        this.isCollapsed ? 'collapsed-menu' : ''
      ]
    },
    ...mapState(['userInfo'])
  },
  mounted() {
    this.$store.dispatch('getAuthButton')
    this.getOperateMenu()
  },
  methods: {
    reload(){
      this.isRouterAlive = false;
      this.$nextTick(function(){
        this.isRouterAlive = true;
      })
    },
    getOperateMenu() {
      const vm = this
      function buildMenu(data) {
        let arr = []
        data.forEach(function(item, index) {
          var obj = {
            name: item.name,
            link: item.url,
            icon: item.icon,
            subMenu: item.children ? buildMenu(item.children) : null
          }
          arr.push(obj)
        })
        return arr
      }
      api(apiList.getOperateMenu, {
        userId: vm.userInfo.userId,
        group: ''
      }).then((res) => {
        if(res.status == 200) {
          vm.menus = buildMenu(res.data.data)
          if (vm.menus.length > 0) {
            var obj = {}
            if(vm.menus[0].subMenu && vm.menus[0].subMenu.length) {
              obj = vm.menus[0].subMenu[0]
            } else {
              obj = vm.menus[0]
            }
            //自动跳到一级菜单的一级目录
            vm.$router.push({
              path: obj.link
            })
            // if(vm.$route.matched && vm.$route.matched.length === 0) {
            //   vm.$router.push({
            //     path: obj.link
            //   })
            // }
          }
        }
      })
    },
    collapsedSider() {
      this.$refs.side1.toggleCollapse()
    }
  }
}
</script>
