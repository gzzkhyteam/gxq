<!-- 新增关键字组件 -->
<template>
  <Modal v-model="auditModal" :title="modalTitle" @on-ok="sumbitSet" @on-cancel="cancel" width="30%" :loading="loading" :mask-closable="false">
    <Card :bordered="false" dis-hover>
      <div style="text-align:left">
        <Form ref="evalData" :model="auditForm" :label-width="80" :rules="ruleValidate" class="clearfix">
          <FormItem label="关键字：" prop="keyWord">
            <Input v-model="auditForm.keyWord" type="text" :maxlength="4"/>
            <p class="fontColor">长度限制4字符内</p>
          </FormItem>
        </Form>
      </div>
    </Card>
  </Modal>
</template>

<script>
import api from '@/api/axiosApi'
import apiList from '@/api/comApiList'
import emailApi from '@/api/emailApi'

export default {
  data () {
    return {
      modalTitle: '评分',
      loading: true,
      auditModal: false,
      auditForm: {
        keyWord: ''
      },
      ruleValidate: {
        keyWord: [
          { required: true, message: '关键字不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    init (data, title) {
      const vm = this
      vm.modalTitle = title
      console.log(data)
      console.log(vm.modalTitle)
      vm.$refs.evalData.resetFields()
      vm.auditModal = true
    },
    getForm () {
      return this.auditForm
    },
    sumbitSet () {
      const vm = this
      setTimeout(() => {
        vm.loading = false
        vm.$nextTick(() => {
          vm.$refs.evalData.validate((valid) => {
            if (valid) {
              vm.save()
            } else {
              vm.$Message.error('表单验证失败，请重试！')
            }
          })
          vm.loading = true
        })
      }, 500)
    },
    save () {
      let _this = this;
      let data = {
          keyWord: this.auditForm.keyWord
      };
        api(emailApi.sendInsertfilter, data).then((res) => {
            if(res.data.errcode === 0 && res.data.errmsg == "ok") {
                // _this.isReadFun(_this.formQueryData.isRead); //获取表格列表
                 _this.$emit('on-ok')
                _this.$Message.success({
                    content: "添加成功",
                    duration: 3
                });
                this.auditModal = false
            } else {
                _this.$Message.error({
                    content: res.data.errmsg,
                    duration: 3
                });
            };
        }, (err) => {})
    },
    cancel () { // 关闭模块
      this.auditModal = false
      this.$refs.evalData.resetFields()
    }
  }
}
</script>
<style>
  .fontColor{
    font-size: 12px;
    color: #bbb;
  }
</style>
