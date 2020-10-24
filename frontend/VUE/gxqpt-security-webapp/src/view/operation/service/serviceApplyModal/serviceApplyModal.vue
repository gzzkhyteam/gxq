<template>
  <Modal
    v-model="showModal"
    title="服务申请"
    :mask-closable="false"
    width="880">
    <Form ref="modalForm" :model="formData" :rules="ruleValidate" :label-width="100" class="clearfix">
      <Row :gutter="40">
        <Col span="12">
          <FormItem label="服务类别" prop="serviceType">
            <Select v-model="formData.serviceType">
              <Option v-for="item in serviceTypeList" :value="item.id" :key="item.id">{{item.type}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="服务对象" prop="serviceObj">
            <Select v-model="formData.serviceObj">
              <Option v-for="item in serviceObjList" :value="item.id" :key="item.id">{{item.type}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="服务分类" prop="serviceClass">
            <Select v-model="formData.serviceClass">
              <Option v-for="item in serviceClassList" :value="item.id" :key="item.id">{{item.type}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="服务名称" prop="serviceName">
            <Select v-model="formData.serviceName">
              <Option v-for="item in serviceNameList" :value="item.id" :key="item.id">{{item.serviceName}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="申请单位" prop="applyOrg">
            <Select v-model="formData.applyOrg">
              <Option v-for="item in applyOrgList" :value="item.id" :key="item.id">{{item.name}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="24">
          <FormItem label="服务简介" label-position="left" prop="serviceAdvice">
            <Input v-model="formData.serviceAdvice" type="textarea" :autosize="{minRows: 5,maxRows: 5}" disabled></Input>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="涉及系统" prop="systemNameIdx">
            <Select v-model="systemNameIdx">
              <Option v-for="(app, i) in appList" :value="i" :key="i">{{app.name}}</Option>
            </Select>
          </FormItem>
        </Col>
        <Col span="12">
          <FormItem label="服务时间" prop="serverTime">
            <DatePicker
              type="datetimerange"
              v-model="serverTime"
              placeholder="请选择服务时间"
              :options="serverTimeOptions"
              style="width: 100%"></DatePicker>
          </FormItem>
        </Col>
      </Row>
    </Form>
    <div slot="footer">
      <Button class="modalBtn" type="primary" @click="handleSubmit" size="large" :loading="loading">确定</Button>
      <Button class="modalBtn" type="default" @click="showModal = false" size="large">取消</Button>
    </div>
  </Modal>
</template>

<script>
import api from '@/api/axiosApi'
import apiList from '@/api/comApiList'
import operationApiList from '@/api/operationApiList'

function convertDateTime(date) {
  if (!date) return ''
  // return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes() + 1}:${date.getSeconds()}`
  return `${date.getFullYear()}-${date.getMonth() + 1}-${date.getDate()} ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`
}

const requestType = {
  // 服务类别
  serviceType: 'serviceType',
  // 服务对象
  serviceObj: 'serviceObj',
  // 服务分类
  serviceClass: 'serviceClass',
  // 服务名称
  serviceName: 'serviceName'
}

export default {
  data(){
    const vm = this
    return{
      loading: false,
      showModal: false,
      isEdit: false,
      formData: {
        // 服务类别id
        serviceType: '',
        // 服务对象id
        serviceObj: '',
        // 服务分类id
        serviceClass: '',
        // 服务名称id
        serviceName: '',
        // 单位id
        applyOrg: '',
        // 服务简介
        serviceAdvice: ''
      },
      // 服务类别list
      serviceTypeList: [],
      // 服务对象list
      serviceObjList: [],
      // 服务分类list
      serviceClassList: [],
      // 服务名称list
      serviceNameList: [],
      // 单位列表
      applyOrgList: [],
      // 系统列表
      appList: [],
      // 涉及的系统的序号
      systemNameIdx: '',
      // 服务时间
      serverTime: [],
      // 不可选日期
      serverTimeOptions: {
        disabledDate (date) {
          return date && date.valueOf() < Date.now() - 86400000;
        }
      },
      // 校验规则
      ruleValidate: {
        serviceType: [{ required: true, message: '不可为空', trigger: 'change' }],
        serviceObj: [{ required: true, message: '不可为空', trigger: 'change' }],
        serviceClass: [{ required: true, message: '不可为空', trigger: 'change' }],
        serviceName: [{ required: true, message: '不可为空', trigger: 'change' }],
        applyOrg: [{ required: true, message: '不可为空', trigger: 'change' }],
        serviceAdvice: [{ required: true, message: '不可为空', trigger: 'blur' }],
        systemNameIdx: [{
          required: true,
          trigger: 'change',
          validator: (rule, value, callback) => {
            if (vm.systemNameIdx === '') {
              callback(new Error('不可为空'))
            } else {
              callback()
            }
          }
        }],
        serverTime: [{
          required: true,
          trigger: 'change',
          validator: (rule, value, callback) => {
            if (vm.serverTime.length === 0) {
              callback(new Error('不可为空'))
            } else {
              callback()
            }
          }
        }]
      }
    }
  },
  mounted () {
    this.getServiceType(requestType.serviceType)
    this.getMyOrgList()
    this.findAppByAdminWithEnable()
  },
  methods:{
    // 获取所有单位
    getMyOrgList() {
      const vm = this
      api(apiList.getMyOrgList)
      .then(res => {
        if (res.data.errcode === 0) {
          vm.applyOrgList = res.data.data.orgList
        }
      }, error => {console.log(error)})
    },
    // 获取系统列表
    findAppByAdminWithEnable() {
      const vm = this
      api(operationApiList.findAppByAdminWithEnable)
      .then(res => {
        if (res.data.errcode === 0) {
          vm.appList = res.data.data
        }
      }, error => {console.log(error)})
    },
    handleSubmit() {
      const vm = this
      vm.loading = true
      setTimeout(() => {
        vm.$nextTick(() => {
          vm.$refs.modalForm.validate((valid) => {
            if(valid) {
              // const systemNames = []
              // vm.systemName.map(i => {
              //   systemNames.push({
              //     systemId: vm.appList[i].appId,
              //     systemName: vm.appList[i].name
              //   })
              // })
              let url = 'serviceSaveMange'
              // 更新
              if (vm.id) {
                url = 'serviceUpdateMange'
                vm.formData.id = vm.id
                vm.formData.status = '1'
              }
              api(operationApiList[url], {
                startTime: convertDateTime(vm.serverTime[0]),
                endTime: convertDateTime(vm.serverTime[1]),
                ...vm.formData,
                systemName: [{
                  systemId: vm.appList[vm.systemNameIdx].appId,
                  systemName: vm.appList[vm.systemNameIdx].name
                }]
              }).then(res => {
                if (res.data.errcode === 0) {
                  vm.$Message.success('申请成功')
                  vm.showModal = false
                  vm.loading = false
                  vm.$emit('on-ok')
                }
              }, error => {console.log(error)})
            } else {
              vm.$Message.error('表单验证失败!');
            }
          })
          vm.loading = true
        })
      }, 500)
    },
    // 获取服务分类等等列表
    getServiceType(type) {
      const vm = this
      let data = {}
      if (!vm.isEdit) {
        vm.formData[type] = ''
        vm[`${type}List`] = []
      }
      switch(type) {
        case requestType.serviceType:
          data = {
            level: 1,
            parentId: -1
          }
          break
        case requestType.serviceObj:
          data = {
            level: 2,
            parentId: vm.formData.serviceType
          }
          break
        case requestType.serviceClass:
          data = {
            level: 3,
            parentId: vm.formData.serviceObj
          }
          break
        case requestType.serviceName:
          data = {
            level: 4,
            parentId: vm.formData.serviceClass
          }
          // 编辑初始化结束之后就把状态改为非编辑，这样之后手动改变的时候才可以触发联动
          vm.isEdit = false
          break
      }
      if (!data.parentId) {
        return
      }
      api(operationApiList.getServiceType, data)
      .then(res => {
        if(res.data.errcode === 0) {
          vm[`${type}List`] = res.data.data
        }
      }, error => { console.log(error) })
    },
    getDetail(id) {
      const vm = this
      api(operationApiList.getServiceDetailById, {
        id: id
      }).then(res => {
        if (res.data.errcode === 0) {
          const {
            serviceType,
            serviceObj,
            serviceClass,
            serviceName,
            applyOrg,
            serviceAdvice,
            systemName,
            startTime,
            endTime
          } = res.data.data
          vm.formData = {
            // 服务类别id
            serviceType,
            // 服务对象id
            serviceObj,
            // 服务分类id
            serviceClass,
            // 服务名称id
            serviceName,
            // 单位id
            applyOrg,
            // 服务简介
            serviceAdvice
          }
          const names = []
          const timeInterval = setInterval(() => {
            if (vm.appList.length > 0) {
              clearInterval(timeInterval)
              for (let i = 0; i < vm.appList.length; i++) {
                if (systemName[0].systemId === vm.appList[i].appId) {
                  vm.systemNameIdx = i
                  break
                }
              }
            }
          }, 200)
          vm.serverTime = [startTime, endTime]
        }
      }, error => { console.log(error) })
    },
    // 打开弹窗的方法
    open(id) {
      this.$refs.modalForm.resetFields()
      this.loading = false
      this.systemNameIdx = ''
      this.serverTime = []
      this.showModal = true
      this.id = id
      // 修改
      if (id) {
        this.$nextTick(() => {
          this.isEdit = true
          this.getDetail(id)
        })
      }
    }
  },
  watch: {
    'formData.serviceType' (val, oldVal) {
      this.getServiceType(requestType.serviceObj)
    },
    'formData.serviceObj' (val, oldVal) {
      this.getServiceType(requestType.serviceClass)
    },
    'formData.serviceClass' (val, oldVal) {
      this.getServiceType(requestType.serviceName)
    },
    'formData.serviceName' (val, oldVal) {
      if (this.serviceNameList.length === 0) {
        return
      }
      for (let item of this.serviceNameList) {
        if (item.id == val) {
          this.formData.serviceAdvice = item.serviceInfo
          return
        }
      }
      this.formData.serviceAdvice = ''
    }
  }
}
</script>
