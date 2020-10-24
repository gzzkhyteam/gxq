<template>
  <Layout>
    <Content>
      <Row style="margin: 15px 0; text-align: right;">
          <Col span="24">
              <Button type="primary" @click="$router.go(-1)">返回</Button>
          </Col>
      </Row>
      <Card>
        <Row>
          <Col span="18">
            <Form
              ref="formValidate"
              :label-width="120"
              :model="detail"
              id="referDetail"
              width="300px">
              <h4>咨询详情</h4>
              <FormItem label="咨询名称：">
                <Input
                  type="text"
                  :value="detail.consultName"
                  disabled>
                </Input>
              </FormItem>
              <FormItem label="咨询时间：">
                <Input
                  type="text"
                  :value="detail.consultTime"
                  disabled>
                </Input>
              </FormItem>
              <FormItem label="咨询内容：">
                <Input
                  type="textarea"
                  :value="detail.consultInfo"
                  disabled
                  :rows="5">
                </Input>
              </FormItem>
              <template v-if="$route.query.status >= 2">
                <h4>处理详情</h4>
                <FormItem label="处理结果：">
                  <Input
                    type="text"
                    :value="detail.dealResult === 'true' ? '同意' : '拒绝'"
                    disabled>
                  </Input>
                </FormItem>
                <FormItem :label="detail.dealResult === 'true' ? '处理意见：' : '驳回理由:'">
                  <Input
                    type="textarea"
                    :value="detail.dealOpinion"
                    disabled
                    :rows="5">
                  </Input>
                </FormItem>
                <template v-if="detail.dealResult === 'true'">
                  <FormItem label="咨询人：">
                    <Input
                      type="text"
                      :value="detail.consultPerson"
                      disabled>
                    </Input>
                  </FormItem>
                  <FormItem label="职位：">
                    <Input
                      type="text"
                      :value="detail.job"
                      disabled>
                    </Input>
                  </FormItem>
                  <FormItem label="联系方式：">
                    <Input
                      type="text"
                      :value="detail.tel"
                      disabled>
                    </Input>
                  </FormItem>
                  <FormItem label="主要工作内容：">
                    <Input
                      type="textarea"
                      :value="detail.workInfo"
                      disabled
                      :rows="5">
                    </Input>
                  </FormItem>
                  <FormItem label="协助人：">
                    <Input
                      type="text"
                      :value="detail.helpPerson.join(',')"
                      disabled>
                    </Input>
                  </FormItem>
                </template>
              </template>
              <template v-if="$route.query.status == 4">
                <h4>咨询反馈</h4>
                <h5 style="margin-left: 20px;">评分</h5>
                <FormItem label="服务态度：">
                  <hy-rate :value="detail.serviceAttitude" disabled :sglValue="20"></hy-rate>
                </FormItem>
                <FormItem label="服务效率：">
                  <hy-rate :value="detail.serviceEfficiency" disabled :sglValue="20"></hy-rate>
                </FormItem>
                <FormItem label="服务质量：">
                  <hy-rate :value="detail.serviceQuality" disabled :sglValue="20"></hy-rate>
                </FormItem>
                <FormItem label="咨询建议：">
                  <Input
                    type="textarea"
                    :value="detail.consultAdvice"
                    disabled
                    :rows="5">
                  </Input>
                </FormItem>
              </template>
            </Form>
          </Col>
        </Row>
      </Card>
    </Content>
  </Layout>
</template>

<script>
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
export default {
  data () {
    return {
      detail: {
        consultName: '',
        consultTime: '',
        consultInfo: '',
        dealResult: '',
        dealOpinion: '',
        consultPerson: '',
        job: '',
        tel: '',
        workInfo: '',
        helpPerson: [],
        serviceAttitude: 0,
        serviceEfficiency: 0,
        serviceQuality: 0,
        consultAdvice: ''
      }
    }
  },
  mounted () {
    this.getDetail()
  },
  methods: {
    getDetail() {
      const vm = this
      api(operationApiList.consultGet, {
        id: vm.$route.params.id
      })
      .then(res => {
        if (res.data.errcode === 0) {
          vm.detail = res.data.data
        }
      }, error => {console.log(error)})
    },
    goback() {
      this.$router.go(-1)
    }
  }
}
</script>

<style lang="less">
#referDetail .ivu-form-item-content{
  height: auto !important;
}
</style>
