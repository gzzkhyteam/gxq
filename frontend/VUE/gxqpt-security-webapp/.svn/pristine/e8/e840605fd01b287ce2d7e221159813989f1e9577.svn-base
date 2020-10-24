<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>运维管理平台</BreadcrumbItem>
        <BreadcrumbItem>日志管理</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <searchCondition
          @searchClick="preSearch"
          @onCreate="onCreate"
          ref="condition"
          :logCode="logCode"
          :faultClass="faultClass"
          :faultLevel="faultLevel" />
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
          ref="table"
          @on-page-change="pageChange" />
        <dealModal ref="dealModal"
          :logCode="logCode"
          :faultClass="faultClass"
          :faultLevel="faultLevel"
          @on-ok="preSearch" />
      </Card>
    </Content>
  </Layout>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
import comApiList from '@/api/comApiList'
import searchCondition from './searchCondition.vue'
import dealModal from './dealModal.vue'
import { HANDLE_TYPES } from './../constant'
const alarmLevels = [{
  label: '全部',
  value: ''
}, {
  label: '一级',
  value: 1
}, {
  label: '二级',
  value: 2
}, {
  label: '三级',
  value: 3
}]
export default {
  components: {
    searchCondition,
    dealModal
  },
  data () {
    const vm = this
    return {
      // 日志类别
      logCode: [],
      // 故障分类
      faultClass: [],
      // 故障级别
      faultLevel: [],
      tableList: {
        columns: [{
          title: '序号',
          type: 'index',
          width: 80,
          align: 'center'
        }, {
          title: '日志类别',
          key: 'logType',
          render: (h, params) => {
            const obj = vm.logCode.find(item => item.code === params.row.logType)
            return h('span', obj.name)
          }
        }, {
          title: '日志记录',
          key: 'logRecord',
          render: (h, params) => {
            return h('div', [
              h('span', {
                style: {
                  display: 'inline-block',
                  width: params.column._width * 0.9 + 'px',
                  overflow: 'hidden',
                  textOverflow: 'ellipsis',
                  whiteSpace: 'nowrap'
                },
                domProps: {
                  title: params.row.logRecord
                }
              }, params.row.logRecord)
            ])
          }
        }, {
          title: '附件',
          key: 'systemName',
          render: (h, params) => {
            const download = h('Button', {
              props: {
                type: 'primary',
                size: 'small'
              },
              style: {
                marginRight: '5px'
              },
              on: {
                click: () => {
                  vm.preDownload(params.row.files)
                }
              }
            }, '下载')
            return h('div', [download])
          }
        }, {
          title: '故障分类',
          key: 'faultClassification',
          render: (h, params) => {
            const obj = vm.faultClass.find(item => item.code === params.row.faultClassification)
            return h('span', obj.name)
          }
        }, {
          title: '故障级别',
          key: 'faultLevel',
          render: (h, params) => {
            const obj = vm.faultLevel.find(item => item.code === params.row.faultLevel)
            return h('span', obj.name)
          }
        }, {
          title: '处理人',
          key: 'dealUserName'
        }, {
          title: '处理时间',
          key: 'dealTime'
        }, {
          title: '操作',
          type: 'act',
          width: 200,
          align: 'center',
          render: (h, params) => {
            const {status, ruleId, id, detailsUrl, applyCode} = params.row
            const remove = h('Button', {
              props: {
                type: 'primary',
                size: 'small'
              },
              style: {
                marginRight: '5px'
              },
              on: {
                click: () => {
                  vm.$Modal.confirm({
                    title: '删除确认',
                    content: '确认删除吗？',
                    onOk: () => {
                      api(operationApiList.logDelete, {id: id})
                      .then(res => {
                        if (res.data.errcode === 0) {
                          vm.$Message.success('删除成功')
                          vm.preSearch()
                        }
                      }, error => {console.log(error)})
                    }
                  })
                }
              }
            }, '删除')
            const edit = h('Button', {
              props: {
                type: 'primary',
                size: 'small'
              },
              style: {
                marginRight: '5px'
              },
              on: {
                click: () => {
                  vm.onEdit(params.row)
                }
              }
            }, '修改')
            const btns = []
            btns.push(remove)
            btns.push(edit)
            return h('div', btns)
          }
        }],
        data: []
      },
      pageInfo: {
        pageNo: 1,
        pageSize: 10,
        total: 0
      }
    }
  },
  mounted () {
    const logCode = this.getCodeList('log_code')
    const faultClass = this.getCodeList('fault_class')
    const faultLevel = this.getCodeList('fault_level')
    Promise.all([logCode, faultClass, faultLevel])
      .then((res) => {
        this.logCode = res[0].data.data
        this.faultClass = res[1].data.data
        this.faultLevel = res[2].data.data
        this.getList()
      })
  },
  methods: {
    preDownload (files) {
      const vm = this
      if (!files || files.length === 0) {
        vm.$Message.info('无附件')
        return
      }
      const {userId, token} = vm.$store.state.userInfo
      const ids = files.map(file => file.fileId)
      window.open(`/api/file/p/file/downloadpackage?ids[]=${ids.join(',')}&userId=${userId}&token=${token}`)
    },
    onCreate () {
      this.$refs.dealModal.open(HANDLE_TYPES.CREATE)
    },
    onEdit (row) {
      this.$refs.dealModal.open(HANDLE_TYPES.EDIT, row.id)
    },
    preSearch() {
      this.pageInfo.pageNo = 1
      this.doSearch()
    },
    pageChange(pageNo, pageSize) {
      this.pageInfo.pageNo = pageNo
      this.pageInfo.pageSize = pageSize
      this.doSearch()
    },
    // 查询
    doSearch () {
      this.getList()
    },
    // 获取培训列表
    getList(pageNo, pageSize) {
      const vm = this
      const condition = vm.$refs.condition.getCondition()
      api(operationApiList.logPageProviderInformation, {
        pageNo: pageNo || vm.pageInfo.pageNo,
        pageSize: pageSize || vm.pageInfo.pageSize,
        data: condition
      }).then(res => {
        if (res.data.errcode === 0) {
          const result = res.data.data
          vm.pageInfo.pageNo = result.pageNum
          vm.pageInfo.total = result.total
          vm.tableList.data = result.list
        }
      }, error => {console.log(error)})
    },
    // 获取数据字典
    getCodeList (code) {
      return api(comApiList.dictionaryGetCodeList, { code })
    }
  }
}
</script>
