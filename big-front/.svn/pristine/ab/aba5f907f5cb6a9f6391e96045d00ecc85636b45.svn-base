/*
* 静态操作树结构，防止树结构收起来
* root:树结构的所有节点，数组形式
* node:操作的节点
* data:操作的节点信息
* nodeInfo:新增、编辑的节点的信息
* type:操作类型 新增子类:createChild 新增同级类:create 修改:edit 删除:delete
* name:nodeInfo的标题字段名称，默认为‘name’
*/
import Vue from 'vue'
function changeTreeData ({root, node, data, nodeInfo, type, name = 'name'}) {
  if (!type) {
    alert('操作类型不能为空')
    return
  }
  let children = []
  switch (type) {
    case 'edit':
      Vue.set(data, 'title', nodeInfo[name])
      break
    case 'delete':
      // 当前操作节点的父节点的所有子节点
      children = root[node.parent].node.children
      for (let i = 0; i < children.length; i++) {
        // 找到当前操作的节点
        if (children[i].nodeKey === data.nodeKey) {
          Vue.delete(children, i)
          break
        }
      }
      break
    case 'createChild':
      data.children.push({
        ...nodeInfo,
        title: nodeInfo[name],
        children: [],
        id: nodeInfo.id,
        parentId: nodeInfo.parentId
      })
      break
    case 'create':
      // 当前操作节点的父节点的所有子节点
      children = root[node.parent].node.children
      children.push({
        ...nodeInfo,
        title: nodeInfo[name],
        children: [],
        id: nodeInfo.id,
        parentId: nodeInfo.parentId
      })
      break
  }
}

export { changeTreeData }
