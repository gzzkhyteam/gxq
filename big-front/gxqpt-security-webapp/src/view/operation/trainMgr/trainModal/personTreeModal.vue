<!-- 单位->部门->人员选择 -->
<template>
  <Modal v-model="showModal" title="选择人员" width="40%" :mask-closable="false">
    <Tree
      ref="personTree"
      :data="treeData"
      :render="renderContent"
      :load-data="loadData"
      :show-checkbox="showCheckbox"></Tree>
    <div slot="footer">
      <Button type="primary" @click="submit" size="large">确定</Button>
      <Button type="default" @click="showModal = false" size="large">取消</Button>
    </div>
  </Modal>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'

// 处理单位和部门的数据
function handleUnitData(data) {
  const treeData = []
  data.map(item => {
    const children = []
    if (item.dpms) {
      item.dpms.map(value => {
        children.push({
          id: value.id,
          title: value.name,
          loading: false,
          parentId: item.id,
          systemCode: item.systemCode,
          children: []
        })
      })
    }
    treeData.push({
      title: item.name,
      id: item.id,
      children: children
    })
  })
  return treeData
}

// 处理人员列表数据
function handlePersonData(data) {
  const personList = []
  data.map(item => {
    personList.push({
      title: item.name,
      id: item.gxqptEmpId
    })
  })
  return personList
}

export default {
  props: {
    multiple: {
      type: Boolean,
      default: false
    },
    showCheckbox: {
      type: Boolean,
      default: false
    },
    id: {
      type: String,
      default: ''
    },
    // 判断是否需要传参过滤树结构的数据
    dontFilter: {
      type: Boolean,
      default: true
    }
  },
  data () {
    return {
      showModal: false,
      titleClass: '',
      treeData: [],
      // 当前选中的节点的信息
      nodeList: new Set(),
      // 处理人可选的id数组
      filterIds: []
    }
  },
  methods: {
    // 树结构渲染
    renderContent(h, { root, node, data }) {
      const vm = this
      let title = data.title
      const titleClass = data.selected ? 'ivu-tree-title ivu-tree-title-selected' : 'ivu-tree-title'
      return h('span', {
        attrs: {
          class: titleClass
        },
        on: {
          click: (e) => {
            // 点击的是倒数第二层，需要从后端拉取数据
            if ('loading' in data) {
              Vue.set(data, 'loading', true)
              vm.getPerson(data, (list) => {
                Vue.set(data, 'children', list)
                // 点击文字也可以展开树结构
                Vue.set(data, 'expand', !data.expand)
                Vue.set(data, 'loading', false)
              })
            } else {
              // 点击的是最后一层
              if (!('children' in data)) {
                // 只能选择一个节点
                if (!vm.multiple && !vm.nodeList.has(data) && vm.nodeList.size > 0) {
                  for (let lastNode of vm.nodeList.values()) {
                    Vue.set(lastNode, 'selected', !lastNode.selected)
                  }
                  vm.nodeList.clear()
                }
                Vue.set(data, 'selected', !data.selected)
                vm.nodeList.add(data)
              }
              // 点击文字也可以展开树结构
              Vue.set(data, 'expand', !data.expand)
            }
          }
        }
      }, title)
    },
    loadData (data, callback) {
      const vm = this
      vm.getPerson(data, (list) => {
        Vue.set(data, 'children', list)
        // 点击文字也可以展开树结构
        Vue.set(data, 'expand', !data.expand)
        Vue.set(data, 'loading', false)
      })
    },
    // 获取运维单位树
    findOrgTreeByLoginInOperation() {
      const vm = this
      const method = vm.dontFilter ? 'findOrgTreeByLoginInOperation' : 'findOrgTreeByUsersInOperation'
      const data = vm.dontFilter ? {} : { id: vm.id }
      api(operationApiList[method], data)
      .then(res => {
        if (res.data.errcode === 0) {
          vm.nodeList = new Set()
          vm.treeData = handleUnitData(res.data.data)
        }
      },(error) => {console.log(error)})
    },
    // 根据单位和部门id查询人员列表
    getPerson(item, callback) {
      // item为当前节点信息
      const vm = this
      api(operationApiList.getDeptPerson, {
        data: {
          // 单位id
          mainorgid: item.parentId,
          // 部门id
          maindeptid: item.id,
          // 体系
          systemCode: item.systemCode || 'gxqpt'
        },
        pageNo: 1,
        pageSize: 1000
      }).then(res => {
        if (res.data.errcode === 0) {
          let result = res.data.data.list
          if (!vm.multiple && !vm.dontFilter) {
            result = result.filter((item) => vm.filterIds.includes(item.gxqptEmpId))
          }
          const personList = handlePersonData(result)
          if (personList.length === 0) {
            this.$Message.info('该部门下无可选人员')
          }
          callback(personList)
        }
      },(error) => {console.log(error)})
    },
    open() {
      this.treeData = []
      // 获取服务审核的处理人的id列表
      if (!this.multiple && !this.dontFilter) {
        this.getFilterIds()
      } else {
        this.findOrgTreeByLoginInOperation()
      }
      this.showModal = true
    },
    async getFilterIds () {
      const vm = this
      const res = await api(operationApiList.findOperationPerson, { id: vm.id })
      if (res.data && res.data.errcode === 0) {
        vm.filterIds = res.data.data
        vm.findOrgTreeByLoginInOperation()
      }
    },
    // 确定提交
    submit() {
      const vm = this
      const nodeList = [...vm.nodeList]
      const data = []
      for (let item of nodeList) {
        if (item.children) {
          vm.$Message.info('只能选择人员')
          return
        }
        if (item.selected) {
          data.push(item)
        }
      }
      if (data.length == 0) {
        vm.$Message.info('请选择人员')
        return
      }
      vm.$emit('on-ok', data)
      vm.showModal = false
    }
  }
}
</script>
<style lang="less">
	.ivu-message{
	  z-index: 10000;
	}
</style>
