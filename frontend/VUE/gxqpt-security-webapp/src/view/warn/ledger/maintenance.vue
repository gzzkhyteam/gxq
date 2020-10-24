<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>预警管理系统</BreadcrumbItem>
        <BreadcrumbItem>预警类型维护</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <Row>
          <Col span="6">
            <Tree :data="ztreeData" :render="renderContent" id="docClassify"></Tree>
          </Col>
          <Col span="16">
          <Form ref="formValidate" :label-width="100">
            <FormItem label="分类名称：">
              <Row>
                <Col span="24">
                  <Input :value="currentNodeDetail.typeName" disabled></Input>
                </Col>
              </Row>
            </FormItem>
            <FormItem label="类型描述：">
              <Row>
                <Col span="24">
                  <Input
                    type="textarea"
                    :rows="5"
                    disabled
                    :value="currentNodeDetail.context"
                    :maxlength="520"></Input>
                </Col>
              </Row>
            </FormItem>
          </Form>
          </Col>
        </Row>
      </Card>
      <Modal v-model="modal" :title="actTitle">
        <Form ref="modalForm" inline :label-width="120" :model="modalFormData" :rules="ruleValidate">
          <FormItem label="分类名称:" prop="typeName">
            <Input type="text"  :maxlength="20" v-model="modalFormData.typeName" style="width:160px;" placeholder="限制输入1~20个字符(文字、字母或数字)!"></Input>
          </FormItem>
          <FormItem label="预警类型编码:" prop="code">
            <Input type="text" :maxlength="20" v-model="modalFormData.code" style="width:160px;" :disabled="currentAct === actTypes.edit" placeholder="限制输入1~20个字符(数字或字母)!"></Input>
          </FormItem>
          <FormItem label="新增类型:" v-if="currentAct === actTypes.create">
            <Select v-model="modalFormData.type" style="width:150px;">
              <Option value="1">--新增子类--</Option>
              <Option value="2" :disabled="currentNodeInfo.parentId == '-1'">--新增类--</Option>
            </Select>
          </FormItem>
          <FormItem label="类型描述:" style="width: 100%;">
            <Input
              type="textarea"
              v-model="modalFormData.context"
              :rows="5"
              :maxlength="100"
              :autosize="{minRows: 5, maxRows: 5}">
            </Input>
          </FormItem>
        </Form>
        <div slot="footer">
          <Button class="modalBtn" type="default" @click="modal = false" size="large">关闭</Button>
          <Button class="modalBtn" type="primary" @click="saveOrUpdate" size="large">确定</Button>
        </div>
      </Modal>
    </Content>
  </Layout>
</template>

<script>
import {mapState} from 'vuex'
import api from '@/api/axiosApi'
import {changeTreeData} from '@/assets/js/utils'
import warnApiList from '@/api/warnApiList'
import {chineseNumAlphabet, numAlphabet} from '@/api/formValidate'
// 操作类型
const actTypes = {
  edit: 'edit',
  create: 'create'
}

export default {
  data() {
    return {
      // 树的所有节点数组
      treeRoot: [],
      // 当前操作的节点对象，包含父节点的nodekey
      currentNode: {},
      actTypes,
      modal: false,
      // 当前操作的类型
      currentAct: 'edit',
      // 当前操作的节点的信息
      currentNodeInfo: {
        // 自生的id
        id: '',
        // 父节点的id，如果没有父节点就为-1
        parentId: ''
      },
      // 当前操作节点的详细信息
      currentNodeDetail: {
        typeName: '',
        context: ''
      },
      // 新增或者编辑时的表单
      modalFormData: {
        code: '',
        name: '',
        type: '1',
        context: ''
      },
      ruleValidate: {
        typeName: [{
            required: true, 
            message: '类型名称不可为空', 
            trigger: 'blur'
        }, {
            validator: chineseNumAlphabet,
            message: '请输入正确的数值!',
            trigger: 'blur'
        }],
        code: [{
            required: true, 
            message: '类型编码不可为空', 
            trigger: 'blur'
        }, { 
            validator: numAlphabet,
            message: '请输入正确的数值!',
            trigger: 'blur'
        }]
      },
      defaultMsg: '',
      config: {
        initialFrameWidth: null,
        initialFrameHeight: 350
      },
      displayType: "none",
      ztreeData: [],
      buttonProps: {
        type: 'ghost',
        size: 'small',
      }
    }
  },
  computed: {
    actTitle () {
      return this.currentAct === actTypes.edit ? '编辑分类' : '新增分类'
    },
    saveOrUpdateUrl() {
      return this.currentAct === actTypes.create ? 'save' : 'update'
    },
    // 按钮权限列表
    ...mapState(['authButton'])
  },
  methods: {
    renderContent(h, { root, node, data }) {
      const vm = this
      // 添加按钮
      const createBtn = h('Button', {
        props: {
          icon: 'plus',
          ...this.buttonProps
        },
        style: {
          marginRight: '8px',
          color: 'green'
        },
        on: {
          click: () => {
            this.treeRoot = root
            this.currentNode = node
            this.modalFormData.typeName = ''
            this.modalFormData.context = ''
            this.modalFormData.code = ''
            this.currentNodeInfo = data
            this.currentAct = actTypes.create
            this.modal = true
          }
        }
      })
      // 编辑按钮
      const editBtn = h('Button', {
        props: {
          icon: 'edit',
          ...this.buttonProps
        },
        style: {
          marginRight: '8px',
          color: 'blue'
        },
        on: {
          click: () => {
            this.treeRoot = root
            this.currentNode = node
            this.currentNodeInfo = data
            this.currentAct = actTypes.edit
            this.modal = true
            this.getClassifyDetail()
          }
        }
      })
      // 删除按钮
      const deleteBtn = h('Button', {
        props: {
          icon: 'close',
          ...this.buttonProps
        },
        style: {
          marginRight: '8px',
          color: 'red'
        },
        on: {
          click: () => {
            vm.$Modal.confirm({
              title: '禁用确认',
              content: '确认禁用吗？',
              onOk: () => {
                api(warnApiList.overdueById, {
                  id: data.id,
                  isEnable: false
                }).then(res => {
                  if (res.data.errcode === 0) {
                    vm.$Message.success('禁用成功！')
                    vm.$set(data, 'isEnable', '0')
                  }
                }, error => {console.log(error)})
              }
            })
            this.currentNodeInfo = data
          }
        }
      })
      // 启用按钮
      const enableBtn = h('Button', {
        props: {
          icon: 'checkmark-round',
          ...this.buttonProps
        },
        style: {
          marginRight: '8px',
          color: 'green'
        },
        on: {
          click: () => {
            vm.$Modal.confirm({
              title: '启用确认',
              content: '确认启用吗？',
              onOk: () => {
                api(warnApiList.overdueById, {
                  id: data.id,
                  isEnable: true
                }).then(res => {
                  if (res.data.errcode === 0) {
                    vm.$Message.success('启用成功！')
                    vm.$set(data, 'isEnable', '1')
                  }
                }, error => {console.log(error)})
              }
            })
            this.currentNodeInfo = data
          }
        }
      })
      const btns = []
      // 如果是第五层就不能添加
      const leveSize = data.leve.split("-").length
      if (Number(data.isEnable) === 1 && Number(leveSize) < 5) {
        btns.push(createBtn)
      }
      btns.push(editBtn)
      // 如果有子节点，那就不能删除
      if (!data.children || data.children.length === 0 && data.parentId != '-1' && Number(data.isEnable) === 1) {
        btns.push(deleteBtn)
      }
      // 如果是禁用的，就有启用按钮,从根级开始启用
      if (Number(data.isEnable) === 0  && (data.children || data.children.length === 0)) {
        btns.push(enableBtn)
      }
      // 有none这个字段就不显示
      if (data.none) {
        return h('span', {
          style: {
            display: 'none'
          }
        }, '')
      }
      return h('span', {
        attrs: {
          class: 'doc-tree-title'
        }
      }, [
        h('span', {
          on: {
            click: () => {
              // 点击文字也可以展开树结构
              Vue.set(data, 'expand', !data.expand)
              this.currentNodeInfo = data
              this.getClassifyDetail()
            }
          },
          attrs: {
            class: 'title'
          }
        }, data.title),
        h('span', {
          attrs: {
            class: 'act-btns-container'
          }
        }, btns)
      ])
    },
    // 获取树结构,isAct代表是不是操作之后的刷新
    getTreeData(isAct, node) {
      // node: 新增的node的信息
      const vm = this
      api(warnApiList.findWarnTypeTree, {id: ''})
      .then(res => {
        if (res.data.errcode === 0) {
          // 打开第一层
          // res.data.data[0].expand = true
          // 操作--新增
          if (isAct) {
            const opts = {
              root: vm.treeRoot,
              node: vm.currentNode,
              data: vm.currentNodeInfo,
              nodeInfo: node,
              name: 'typeName'
            }
            // 新增子类
            if (vm.modalFormData.type === '1') {
              opts.type = 'createChild'
            } else {
              opts.type = 'create'
            }
            changeTreeData(opts)
          } else {
            this.ztreeData = JSON.parse(JSON.stringify(res.data.data).replace(/typeName/g, 'title'))
          }
        }
      }, error => {console.log(error)})
    },
    // 保存或者更新节点信息
    saveOrUpdate() {
      // 此处缺少表单验证
      const vm = this
      vm.$refs.modalForm.validate(valid => {
        if (valid) {
          const {parentId, id} = {...vm.currentNodeInfo}
          let data = {
            ...vm.modalFormData
          }
          // 编辑
          if (vm.currentAct === actTypes.edit) {
            data.id = id
          } else {
            // 新增子类
            if (vm.modalFormData.type === '1') {
              data.parentId = id
            } else {
              data.parentId = parentId
            }
          }
          api(warnApiList[vm.saveOrUpdateUrl], data)
          .then(res => {
            if (res.data.errcode === 0) {
              // 编辑
              if (vm.currentAct === actTypes.edit) {
                changeTreeData({
                  root: vm.treeRoot,
                  node: vm.currentNode,
                  data: vm.currentNodeInfo,
                  nodeInfo: vm.modalFormData,
                  name: 'typeName',
                  type: 'edit'
                })
              } else {
                vm.getTreeData(true, res.data.data)
              }
              vm.modal = false
              vm.$refs.modalForm.resetFields()
            }else {
              vm.$Message.warning(res.data.errmsg);
            }
          }, error => {console.log(error)})
        } else {
          vm.$Message.warning('表单验证失败！')
        }
      })
    },
    // 获取文档分类的详细信息
    getClassifyDetail(node) {
      const vm = this
      api(warnApiList.getById, {
        id: vm.currentNodeInfo.id
      }).then(res => {
        if (res.data.errcode === 0) {
          vm.modalFormData.context = res.data.data.context
          vm.modalFormData.typeName = res.data.data.typeName
          vm.modalFormData.code = res.data.data.code
          vm.currentNodeDetail.context = res.data.data.context
          vm.currentNodeDetail.typeName = res.data.data.typeName
          vm.currentNodeDetail.code = res.data.data.code
        }
      }, error => {console.log(error)})
    }
  },
  mounted() {
    this.getTreeData()
  }
}
</script>

<style type="text/css" scoped>
.w168 {
  width: 168px;
}
</style>

<style lang="less">
#docClassify{
  .doc-tree-title{
    display: inline-block;
    width: 100%;
    vertical-align: middle;
    .title{
      display: inline-block;
      height: 24px;
      float: left;
      line-height: 24px;
      cursor: pointer;
    }
    .act-btns-container{
      display: none;
      margin-left: 10px;
    }
    &:hover{
      .act-btns-container{
        display: inline-block;
      }
    }
  }
}

</style>
