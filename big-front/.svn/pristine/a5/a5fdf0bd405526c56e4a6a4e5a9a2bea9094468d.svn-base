<template>
  <Tree ref="typeTree" :data="typeTree" empty-text="暂无预警类型"></Tree>
</template>

<script>
import api from '@/api/axiosApi'
import warnApiList from '@/api/warnApiList'

function handleTreeData(data) {
  data.map((value, idx) => {
    if (value.children && value.children.length > 0) {
      data[idx].disableCheckbox = true
      // 默认打开树结构
      // data[idx].expand = true
      data[idx].children = handleTreeData(data[idx].children)
    }
  })
  return data
}

export default {
  data () {
    return {
      typeTree: []
    }
  },
  methods: {
    // 初始化预警类型的树结构
    initTreeData(id) {
      const vm = this
      if (vm.typeTree.length > 0) {
        return
      }
      api(warnApiList.findWarnTypeTree, {
        id: id || ''
      }).then(res => {
        if (res.data.errcode === 0) {
          const tree = JSON.parse(JSON.stringify(res.data.data).replace(/typeName/g, 'title'))
          // vm.typeTree = handleTreeData(tree)
          vm.typeTree = [{
            expand: true,
            id: '',
            children: tree,
            parentId: '-1',
            title: '全部'
          }]
        }
      }, error => {console.log(error)})
    },
    // 获取选择的项目
    getSelection () {
      const vm = this
      const obj = vm.$refs.typeTree.getSelectedNodes()
      return obj
    }
  }
}
</script>