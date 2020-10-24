<template>
    <Card :bordered="false" style="margin-bottom: 30px;">
        <p slot="title">附件列表</p>
        <div style="text-align:left">
            <Form :model="detail" :label-width="100" class="clearfix">
                <Row :gutter="40">
                    <Col span="24">
                        <FormItem label="培训签到表：">
                          <ol>
                            <li v-for="item in defaultSignFiles" :key="item.id"><a :href="item.fileUrl" target="_blank" :download="item.fileName">{{item.fileName}} <Icon type="ios-cloud-download" /></a></li>
                          </ol>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="培训反馈表：">
                          <ol>
                            <li v-for="item in defaultFeedbackFiles" :key="item.id"><a :href="item.fileUrl" target="_blank" :download="item.fileName">{{item.fileName}} <Icon type="ios-cloud-download" /></a></li>
                          </ol>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
        </div>
    </Card>
</template>

<script>
export default {
  props:{
    detail: {
      type: Object
    }
  },
  data(){
    return{
      defaultSignFiles: [],
      defaultFeedbackFiles: []
    }
  },
  mounted () {
    const vm = this
    vm.detail.files.map(item => {
      if (item.bussType === 'train_sign_in') {
        vm.defaultSignFiles.push(item)
      } else{
        vm.defaultFeedbackFiles.push(item)
      }
    })
  }
}
</script>

<style scoped>
.ivu-form-item >>> .ivu-form-item-content{
    height:auto;
}
.ivu-input-wrapper >>> textarea{
    resize: none;
}
</style>
