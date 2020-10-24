<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>预警管理系统</BreadcrumbItem>
        <BreadcrumbItem>预警处理台账</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <searchCondition ref="condition" @searchClick="preSearch" :excepts="['status']" />
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
          class="refer-apply"
          @on-page-change="pageChange" />
        <Modal
          v-model="showModal"
          title="预警信息详情"
          :width="960">
          <detail ref="detail" key="deal" />
          <div slot="footer">
            <Button class="modalBtn" type="primary" @click="showModal = false" size="large">确定</Button>
          </div>
        </Modal>
      </Card>
    </Content>
  </Layout>
</template>

<script>
import {mapState} from 'vuex'
import api from '@/api/axiosApi'
import warnApiList from '@/api/warnApiList'
import searchCondition from './searchCondition.vue'
import detail from './detail.vue'
import {levels, allStatus} from './constant'

export default {
  components: {
    searchCondition,
    detail
  },
  data () {
    const vm = this
    return {
      showModal: false,
      tableList: {
        columns: [
          {
            type: 'index',
            title: '序号',
            width: 60,
            align: 'center'
          },
          {
            title: '预警级别',
            key: 'level',
            render: (h, params) => {
              const {level} = params.row
              let text = '--'
              for (let l of levels) {
                if (l.value == level) {
                  text = l.label
                  break
                }
              }
              return h('span', text)
            }
          },
          {
            title: '预警类型',
            key: 'typeName'
          },
          {
            title: '预警标题',
            key: 'title'
          },
          {
            title: '应用程序名称',
            key: 'appName'
          },
          {
            title: '预警时间',
            key: 'warntime'
          },
          {
            title: '处理人',
            key: 'recName'
          },
          {
            title: '处理人类型',
            key: 'recType',
            render: (h, params) => {
              const types = ['--', '确认人', '抄送人', '责任人']
              return h('span', types[params.row.recType])
            }
          },
          {
            title: '是否属实',
            key: 'result',
            render: (h, params) => {
              return h('span', params.row.result ? '属实' : '不属实')
            }
          },
          {
            title: '处理信息',
            key: 'remarks'
          },
          {
            title: '处理时间',
            key: 'handTime'
          },
          {
            title: '操作',
            key: 'address',
            align: 'center',
            render: (h, params) => {
              const vm = this
              const {
                status,
                whoHandle,
                recType,
                id,
                title,
                content,
                handlerLeve,
                callbackUrl,
                isHandle,
                warnId,
                userId
              } = params.row
              const style = {
                marginRight: '5px'
              }
              // 详情
              const info = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style,
                domProps: {
                  innerHTML: '详情'
                },
                on: {
                  click () {
                    vm.showModal = true
                    vm.$refs.detail.refresh(id)
                  }
                }
              })
              // 确认
              const confirm = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style,
                domProps: {
                  innerHTML: '详情'
                },
                on: {
                  click () {
                    vm.$router.push({
                      name: 'referDetail',
                      params: {
                        id: id
                      },
                      query: {
                        status
                      }
                    })
                  }
                }
              })
              // 处理
              const deal = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                style,
                domProps: {
                  innerHTML: '详情'
                },
                on: {
                  click () {
                    vm.$router.push({
                      name: 'referDetail',
                      params: {
                        id: id
                      },
                      query: {
                        status
                      }
                    })
                  }
                }
              })
              const btns = []
              if(status == '1' && recType == '1' && whoHandle) {
                btns.push(confirm)
              } else if (recType == '3' && whoHandle){
                btns.push(deal)
              }
              btns.push(info)
              return h('span', btns)
            }
          }
        ],
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
    this.search()
  },
  methods: {
    preSearch() {
      this.pageInfo.pageNo = 1
      this.search()
    },
    pageChange(pageNo, pageSize) {
      this.pageInfo.pageNo = pageNo
      this.pageInfo.pageSize = pageSize
      this.search()
    },
    // 获取所有处理台账的列表
    search () {
      const vm = this
      const data = vm.$refs.condition.getCondition()
      api(warnApiList.findWarnHandleList, {
        data,
        ...vm.pageInfo
      }).then(res => {
        if (res.data.errcode === 0) {
          const result = res.data.data
          vm.pageInfo.pageNo = result.pageNum
          vm.pageInfo.total = result.total
          vm.tableList.data = result.list
        }
      }, error => {console.log(error)})
    }
  }
}
</script>

<style lang='less'>
.refer-apply{
  .handle{
    margin: 0 5px;
    display: inline-block;
    cursor: pointer;
    color: #2d8cf0;
  }
}
#applyModal .ivu-form-item-content{
  height: auto !important;
}
</style>
