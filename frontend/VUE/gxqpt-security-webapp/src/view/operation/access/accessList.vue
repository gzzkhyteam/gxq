<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>接入管理</BreadcrumbItem>
        <BreadcrumbItem>我的应用</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <Form
          ref="formValidate"
          inline
          :label-width="100"
          :model="searchCondition">
          <FormItem label="应用名称：">
            <Input
              type="text"
              v-model="searchCondition.name">
            </Input>
          </FormItem>
          <FormItem label="应用分类：">
            <Select v-model="searchCondition.type" style="width:140px">
              <Option value="-1">全部</Option>
              <Option value="jryy">接入应用</Option>
              <Option value="zcpt">支撑平台</Option>
              <Option value="zcfw">支撑服务</Option>
              <Option value="zcfwmk">支撑服务模块</Option>
              <Option value="zcyy">支撑应用</Option>
            </Select>
          </FormItem>
          <FormItem label="应用类型：">
            <Select v-model="searchCondition.appType" style="width:140px">
              <Option :value="-1">全部</Option>
              <Option value="1">应用</Option>
              <Option value="2">服务</Option>
              <Option value="3">应用/服务</Option>
            </Select>
          </FormItem>
          <FormItem label="提供方：">
            <Input
              type="text"
              v-model="searchCondition.provider">
            </Input>
          </FormItem>
          <FormItem :label-width="20">
            <Button type="primary" @click="preSearch" v-if="authButton.includes('ops_application_query')">查询</Button>
          </FormItem>
        </Form>
        <hy-table
          highlight-row
          border
          :current="pageInfo.pageNo"
          :columns="tableList.columns"
          :data="tableList.data"
          :total="Number(pageInfo.total)"
          :pageSize="Number(pageInfo.pageSize)"
          pageType="small"
          show-elevator
          show-sizer
          class="access-list"
          @on-change="pageNoChange"
          @on-page-size-change="pageSizeChange" />
      </Card>
    </Content>
  </Layout>
</template>

<script>
import {mapState} from 'vuex'
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'

function defaultDisplay(h, params, key) {
  return h('span', params.row[key] || '--')
}

export default {
  data () {
    const slgLineStyle =  {
      maxHeight: '36px',
      overflow: 'hidden',
      margin: '10px 0',
      textOverflow: 'ellipsis',
      whiteSpace: 'nowrap'
    }
    return {
      searchCondition: {
        // 应用名称
        name: '',
        // 应用分类
        type: '-1',
        // 应用类型
        appType: -1,
        // 提供方
        provider: ''
      },
      pageInfo: {
        pageNo: 1,
        pageSize: 10,
        total: 0
      },
      tableList: {
        columns: [
          {
            type: 'index',
            title: '序号',
            width: 60,
            align: 'center'
          },
          {
            title: '应用图标',
            key: 'logoUrl',
            maxWidth: 100,
            render: (h, params) => {
              return h('img', {
                attrs: {
                  src: params.row.logoUrl
                },
                style: {
                  width: '40px'
                }
              })
            }
          },
          {
            title: '应用名称',
            key: 'name',
            render: (h, params) => {
              return defaultDisplay(h, params, 'name')
            }
          },
          {
            title: '应用编码',
            key: 'code',
            render: (h, params) => {
              return defaultDisplay(h, params, 'code')
            }
          },
          {
            title: '应用分类',
            key: 'typeName',
            render: (h, params) => {
              return defaultDisplay(h, params, 'typeName')
            }
          },
          {
            title: '应用类型',
            key: 'appType',
            render: (h, params) => {
              return h('span', ['--', '应用', '服务', '应用/服务'][params.row.appType])
            }
          },
          {
            title: '应用描述',
            key: 'desc',
            render: (h, params) => {
              const html = params.row.desc || '--'
              return h('div', {
                style: {...slgLineStyle},
                attrs: {
                  title: html
                }
              }, html)
            }
          },
          {
            title: '提供方',
            key: 'provider',
            render: (h, params) => {
              return defaultDisplay(h, params, 'provider')
            }
          },
          {
            title: '创建人',
            key: 'createName',
            render: (h, params) => {
              return defaultDisplay(h, params, 'createName')
            }
          },
          {
            title: '应用管理员',
            key: 'appManager',
            render: (h, params) => {
              return defaultDisplay(h, params, 'appManager')
            }
          },
          {
            title: '操作',
            key: 'id',
            minWidth: 160,
            align: 'center',
            render: (h, params) => {
              const vm = this
              const {id, name, appId} = params.row
              const info = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click () {
                    // const url = `#/accessInfo?id=${id}`
                    // window.open(url)
                    vm.$router.push({
                      path: '/accessInfo',
                      query: {
                        id: appId
                      }
                    })
                  }
                }
              }, '部署信息')
              const upgrade = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click () {
                    // const url = `#/accessUpgrade?id=${id}&name=${name}`
                    // window.open(url)
                    vm.$router.push({
                      path: '/accessUpgrade',
                      query: {
                        id: id,
                        name: name
                      }
                    })
                  }
                }
              }, '应用升级')
              const analyze = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style: {
                  marginRight: '5px'
                },
                on: {
                  click () {
                    // const url = `#/accessAnalyze?id=${id}`
                    // window.open(url)
                    vm.$router.push({
                      path: '/accessAnalyze',
                      query: {
                        id: appId
                      }
                    })
                  }
                }
              }, '应用分析')
              const userId = vm.userInfo.userId
              const btns = []
              if (vm.authButton.includes('ops_deploying_info')) {
                btns.push(info)
              }
              // 是否是自己维护的系统
              if (vm.appids.has(appId)) {
                if (vm.authButton.includes('ops_application_update')) {
                  btns.push(upgrade)
                }
              }
              if (vm.authButton.includes('ops_application_analysis')) {
                btns.push(analyze)
              }
              return h('div', btns)
            }
          }
        ],
        data: []
      },
      // 我负责的应用的id
      appids: new Set()
    }
  },
  computed: {
    // 按钮权限列表
    ...mapState(['authButton', 'userInfo'])
  },
  methods: {
    pageNoChange(pageNo) {
      this.pageInfo.pageNo = pageNo
      this.getAppList()
    },
    pageSizeChange(pageSize) {
      this.pageInfo.pageSize = pageSize
      this.getAppList()
    },
    // 获取我关联的系统
    getSystemList() {
      const vm = this
      api(operationApiList.getSystemList)
      .then(res => {
        if (res.data.errcode === 0) {
          const appids = []
          const data = res.data.data || []
          res.data.data.map(item => {
            appids.push(item.systemId)
          })
          vm.appids = new Set(appids)
          vm.getAppList()
        }
      }, error => {console.log(error)})
    },
    // 获取所有文档的列表
    getAppList (pageNo, pageSize) {
      const vm = this
      const {name, type, appType, provider} = { ...vm.searchCondition }
      api(operationApiList.findByAppIdList, {
        pageNo: pageNo || vm.pageInfo.pageNo,
        pageSize: pageSize || vm.pageInfo.pageSize,
        data: {
          // 后端已经更改,传不传都是查询所有的应用
          appIdList: [],
          // 应用名称
          name: name || '',
          // 应用分类
          type: type || '-1',
          // 应用类型
          appType: appType || -1,
          // 提供方
          provider: provider || ''
        }
      }).then(res => {
        if (res.data.errcode === 0) {
          const result = res.data.data
          vm.pageInfo.pageNo = result.pageNum
          vm.pageInfo.total = result.total
          vm.tableList.data = result.list
        }
      }, error => {console.log(error)})
    },
    preSearch() {
      this.pageInfo.pageNo = 1
      this.getAppList()
    }
  },
  mounted() {
    this.getSystemList()
  }
}
</script>

<style lang='less'>
.access-list{
  span.handle{
    margin: 0 5px;
    display: inline-block;
    cursor: pointer;
    &:hover{
      color: #57a3f3;
    }
  }
}
</style>
