<template>
  <Layout>
    <hengyun-header :title="{chinese: '运维管理平台', english: 'Broadview COSS'}"></hengyun-header>
    <Layout class="ivu-layout-has-sider" v-if="menus.length > 0">
      <hengyun-sidebar :menus="menus"/>
      <router-view></router-view>
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
//   name: '运维人员管理',
//   subMenu: [{
//     name: '人员管理',
//     link: '/operationPplMgr'
//   }]
// }, {
//   name: '运维文档管理',
//   subMenu: [{
//     name: '运维文档查询',
//     link: '/docQuery/0'
//   }, {
//     name: '运维文档管理',
//     link: '/docQuery/1'
//   }, {
//     name: '文档分类管理',
//     link: '/docClassify'
//   }]
// }, {
//   name: '接入管理',
//   subMenu: [{
//     name: '我的应用',
//     link: '/accessList'
//   }]
// }, {
//   name: '运维服务管理',
//   subMenu: [{
//     name: '服务申请',
//     link: '/serviceApply'
//   }, {
//     name: '服务审核',
//     link: '/serviceAudit'
//   }, {
//     name: '服务处理',
//     link: '/serviceDeal'
//   },{
//     name: '服务目录管理',
//     link: '/serviceListMgr'
//   }]
// }, {
//   name: '故障管理',
//   subMenu: [{
//     name: '故障台账',
//     link: '/ledger'
//   }, {
//     name: '我的任务',
//     link: '/myTask'
//   }, {
//     name: '故障监控',
//     link: '/monitor'
//   }, {
//     name: '知识库',
//     link: '/repository'
//   }]
// }, {
//   name: '运维分析',
//   link: '/analyzeRate'
// }, {
//   name: '培训管理',
//   subMenu: [{
//     name: '培训课程目录',
//     link: '/trainCourseList'
//   }, {
//     name: '培训列表',
//     link: '/trainList'
//   }, {
//     name: '培训审核',
//     link: '/trainAudit'
//   }, {
//     name: '培训处理',
//     link: '/trainDeal'
//   }, {
//     name: '培训课程管理',
//     link: '/trainCourseMgr'
//   }]
// }, {
//   name: '咨询管理',
//   subMenu: [{
//     name: '咨询申请',
//     link: '/referApply'
//   }, {
//     name: '咨询审核',
//     link: '/referCheck'
//   }, {
//     name: '咨询处理',
//     link: '/referHandle'
//   }]
// }]

export default {
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
