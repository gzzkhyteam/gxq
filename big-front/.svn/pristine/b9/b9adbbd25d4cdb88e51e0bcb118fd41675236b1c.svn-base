<!-- 业务应用运行数据采集-->
<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>统一监管平台</BreadcrumbItem>
        <BreadcrumbItem>业务应用运行数据采集</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <Form ref="formValidate" inline :label-width="110" :model="searchData">
          <FormItem label="应用名称：">
            <Select v-model="searchData.appId" style="width:200px" clearable>
                <Option v-for="item in appArr" :value="item.appId" :key="item.appId">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem :label-width="20">
            <Button type="primary" @click="preSearch">查询</Button>
            <Button type="primary" @click="openModal()">新增</Button>
          </FormItem>
        </Form>
        <hy-table
          highlight-row
          border
          ref="unitTable"
          :current="pageInfo.pageNo"
          :columns="tableList.columns"
          :data="tableList.data"
          :total="Number(pageInfo.total)"
          :pageSize="Number(pageInfo.pageSize)"
          pageType="small"
          show-elevator
          @on-page-change="pageChange"
          show-sizer/>
      </Card>
      <Modal v-model="createModal" :title="modelTitle" width="40%" :mask-closable="false">
        <Form ref="createForm" :model="createForm" :rules="createRule" :label-width="90">
          <FormItem label="应用名称" prop="appId">
            <Select v-model="createForm.appId" style="width:200px" :disabled="disa">
                <Option v-for="item in appArr" :value="item.appId" :key="item.appId">{{ item.name }}</Option>
            </Select>
          </FormItem>
          <FormItem label="采集方式" prop="storeDay">
            <Select class="queryItem" v-model="createForm.storeDay" :disabled="disa">
              <Option value="实时">实时</Option>
              <Option value="半实时">半实时</Option>
              <Option value="异步">异步</Option>
            </Select>
          </FormItem>
          <FormItem label="采集占用率" prop="storeIs" required>
            <Input type="text" v-model="createForm.storeIs" :disabled="disa">
              <span slot="append">%</span>
            </Input>
          </FormItem>
        </Form>
        <div slot="footer">
          <Button class="modalBtn" type="primary" @click="saveOrUpdate" size="large">确定</Button>
          <Button class="modalBtn" type="default" @click="createModal = false" size="large">取消</Button>
        </div>
      </Modal>
    </Content>
  </Layout>
</template>

<script>
import api from '@/api/axiosApi'
import superviseApiList from '@/api/superviseApiList'
import { validNumber100 } from '@/api/formValidate'
import comApiList from '@/api/comApiList'
import { mapState } from 'vuex'
function getCreateForm() {
  return {
    appId: '', // 应用名称
    storeDay: '', // 存储天数
    storeIs: '', // 是否存储
    type: 'application'
  }
}
export default {
  data() {
    const vm = this
    return {
      // 当前操作的行数据的id
      currentId: null,
      remindTypes:'',
      appArr:[],//应用列表,
      searchData: { //查询参数
        // 区分应用和服务
        type: 'application',
        // 应用id
        appId: ''
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
            title: '应用名称',
            key: 'appId',
            render: (h, params) => {
              return h('span', vm.appArr.find(item => item.appId === params.row.appId).name)
            }
          },
          {
            title: '采集方式',
            key: 'storeDay'
          },
          {
            title: '采集占用率（%）',
            key: 'storeIs'
          },
          {
            title: '操作',
            key: 'act',
            width: 240,
            render: (h, params) => {
              const edit = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                on: {
                  click: () => {
                    vm.modelTitle = '修改'
                    vm.openModal(params.row.id)
                  }
                }
              }, "修改");
              const del = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                on: {
                  click: () => {
                    vm.itemDelete(params.row.id);
                  }
                }
              }, "删除");
              const log = h('Button', {
                props: {
                  type: 'primary',
                  size: 'small'
                },
                on: {
                  click: () => {
                    vm.$router.push({
                      name: 'optLogs',
                      params: {
                        id: params.row.appId,
                        type: 'application'
                      }
                    })
                  }
                }
              }, "操作记录");
              return h('div', [edit, del, log]);
            }
          }
        ],
        data: []
      },
      // 分页数据
      pageInfo: {
        pageNo: 1,
        pageSize: 10,
        total: 0
      },
      createForm: getCreateForm(),
      createModal:false,
      createRule: {
        appId: [{
          required: true,
          trigger: 'change',
          validator: (rule, value, cb) => {
            if (!this.createForm.appId) {
              cb(new Error('请选择应用名称！'))
              return
            }
            cb()
          }
        }],
        storeIs: [{
          // required: true,
          trigger: 'change',
          message: '只能填写正数',
          validator: validNumber100
        }],
        storeDay: [{
          required: true,
          message: '不可为空',
          trigger: 'change'
        }]
      }
    }
  },
  mounted() {
    this.fwlbByAdmin();
  },
  methods: {
    fwlbByAdmin() { // 查询我所管理的所有启用的应用或服务(1：应用；2：服务)
      api(comApiList.findAppIdListByPt, {
        type: 1
      }).then((res) => {
        if (res.data.errcode == 0 && res.data.data) {
          this.appArr = res.data.data
          this.preSearch();
        }
      }, (err) => {})
    },
    preSearch () {
      this.pageInfo.pageNo = 1
      this.getList()
    },
    pageChange (pageNo, pageSize) {
      this.pageInfo.pageNo = pageNo
      this.pageInfo.pageSize = pageSize
      this.getList()
    },
    getList () {
      const vm = this
      let data = {
        data: vm.searchData,
        pageNo: vm.pageInfo.pageNo,
        pageSize: vm.pageInfo.pageSize
      }
      api(superviseApiList.appOptConfigPageList, data)
      .then((res) => {
        if (res.data && res.data.errcode === 0) {
          vm.tableList.data = res.data.data.list
          vm.pageInfo.total = res.data.data.total
        } else {
          vm.tableList.data = []
          vm.$Message.error('查询失败');
        }
      }, (err) => {})
    },
    // 打开新增或者修改弹窗
    openModal (id) {
      const vm = this
      vm.currentId = id || null
      if (!vm.currentId) {
        vm.createForm = getCreateForm();
        vm.$refs.createForm.resetFields();
      } else {
        api(superviseApiList.appOptConfigFindById, { id: vm.currentId })
        .then((res) => {
          if (res.data && res.data.errcode === 0) {
            vm.createForm = res.data.data;
          } else {
            vm.$Message.error('获取详情失败');
          }
        }, (err) => {})
      }
      vm.createModal = true;
    },
    // 保存或者新增
    saveOrUpdate () {
      const vm = this
      vm.$refs.createForm.validate(valid => {
        if (valid) {
          const urlMethod = vm.currentId ? 'appOptConfigUpdateData' : 'appOptConfigSaveData'
          api(superviseApiList[urlMethod], {
            ...vm.createForm,
            id: vm.currentId,
            serviceId: vm.appArr.find(item => item.appId === vm.createForm.appId).serviceId
          }).then((res) => {
            if (res.data && res.data.errcode === 0) {
              vm.tableList.data = res.data.data.list
              vm.pageInfo.total = res.data.data.total
              vm.createModal = false
              vm.preSearch()
            } else {
              vm.tableList.data = []
            }
          }, (err) => {})
        } else {
          vm.$Message.error('表单验证失败！')
        }
      })
    },
    // 删除记录
    itemDelete (id) {
      const vm = this
      vm.$Modal.confirm({
        title: '删除确认',
        content: '确定删除此条数据吗？',
        onOk: () => {
          api(superviseApiList.appOptConfigDeleteById, { id })
          .then((res) => {
            if (res.data && res.data.errcode === 0) {
              vm.$Message.success('删除成功');
              vm.preSearch();
            } else {
              vm.$Message.error('删除失败，请重试');
            }
          }, (err) => {})
        }
      })
    }
  }
}
</script>
