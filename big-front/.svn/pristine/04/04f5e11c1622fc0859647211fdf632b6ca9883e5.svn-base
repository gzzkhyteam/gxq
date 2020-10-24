<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>服务器详情</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <Form
          inline
          ref="formValidate"
          :label-width="100"
          :model="formInfo">
          <Row>
            <FormItem label="申请单位：">
              <Input
                type="text"
                v-model="formInfo.content"
                disabled>
              </Input>
            </FormItem>
            <FormItem label="申请人：">
              <Input
                type="text"
                v-model="formInfo.content"
                disabled>
              </Input>
            </FormItem>
            <Button type="default" @click="quit" style="float: right;">返回</Button>
            <Button type="default" @click="gotoCtrl(2)" style="float: right;">监控详情</Button>
          </Row>
          <Row>
            <FormItem label="CPU核数：">
              <Input
                type="text"
                v-model="formInfo.content"
                disabled>
              </Input>
            </FormItem>
            <FormItem label="内存大小：">
              <Input
                type="text"
                v-model="formInfo.content"
                disabled>
              </Input>
            </FormItem>
          </Row>
          <Row>
            <FormItem label="操作系统：">
              <Input
                type="text"
                v-model="formInfo.content"
                disabled>
              </Input>
            </FormItem>
            <FormItem label="所属网络：">
              <Input
                type="text"
                v-model="formInfo.content"
                disabled>
              </Input>
            </FormItem>
          </Row>
          <FormItem label="网络宽带：">
            <Input
              type="text"
              v-model="formInfo.content"
              disabled>
            </Input>
          </FormItem>
          <h4>磁盘列表</h4>
          <hy-table
            highlight-row
            :columns="tableList.columns"
            :data="tableList.data"
            class="server-list"
            :needPage="false" />
        </Form>
      </Card>
    </Content>
  </Layout>
</template>

<script>
// 服务器配置表单
import serverConfig from './../common/serverConfig'
const hidecode = ['操作系统', '网关描述', '申请数量']

const list = {
  name: '4核',
  age: 1,
  address: 'New York No. 1 Lake Park',
  date: '2016-10-03',
  diskList: [0]
}
export default {
  components: {
    serverConfig
  },
  data () {
    return {
      hidecode,
      formInfo: {
        name: '',
        content: ''
      },
      providerList: [{
        value: 3,
        label: '提供方1'
      }],
      tableList: {
        columns: [
          {
            type: 'index',
            title: '序号',
            width: 60,
            align: 'center'
          },
          {
            title: 'CPU核数',
            key: 'name'
          },
          {
            title: '内存',
            key: 'age'
          },
          {
            title: '操作系统',
            key: 'address'
          },
          {
            title: '所属网络',
            key: 'age'
          },
          {
            title: '网络宽带',
            key: 'address'
          },
          {
            title: '申请数量',
            key: 'age'
          },
          {
            title: '磁盘',
            key: 'address'
          },
          {
            title: '大小',
            key: 'age'
          },
          {
            title: '操作',
            key: 'address',
            render: (h, params) => {
              const vm = this
              const age = params.row.age
              const id = params.row.age
              const edit = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                domProps: {
                  innerHTML: '修改'
                },
                on: {
                  click () {
                    vm.gotoCtrl(1, params.index)
                  }
                }
              })
              const deleteServer = h('Button', {
                props: {
                  type: 'error',
                  size: 'small'
                },
                domProps: {
                  innerHTML: '删除'
                },
                on: {
                  click () {
                    vm.gotoCtrl(0, params.index)
                  }
                }
              })
              return h('div', [edit, deleteServer])
            }
          }
        ],
        data: [list, list]
      }
    }
  },
  methods: {
    // 返回
    quit () {
      this.$router.go(-1)
    },
    gotoCtrl(idx,data) {
      switch (idx) {
        case 0://修改
          break
        case 1://删除
          break
        case 2://监控详情
          this.$router.push({//修改服务器
            name: 'monitoringDetails'
          })
          break
      }
    },
  }
}
</script>
