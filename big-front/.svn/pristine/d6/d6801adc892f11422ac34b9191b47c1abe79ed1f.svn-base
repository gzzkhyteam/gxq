<template>
    <Card :bordered="false" style="margin-bottom: 30px;">
        <p slot="title">审核详情</p>
        <div style="text-align:center">
            <Form ref="detail" :model="detail" :label-width="100" class="clearfix">
                <Row :gutter="40">
                    <Col span="6">
                        <FormItem label="审核结果">
                            <Input :value="detail.status == 2 ? '不同意' : '同意'" type="text" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="审核意见" label-position="left">
                            <Input v-model="detail.dealOpinion" type="textarea" disabled></Input>
                        </FormItem>
                    </Col>
                    <template v-if="detail.status != 2">
                        <Col span="12">
                            <FormItem label="培训人">
                                <Input v-model="detail.personName" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="12">
                        <FormItem label="职位">
                            <Input v-model="detail.position" disabled></Input>
                        </FormItem>
                        </Col>
                        <Col span="24">
                            <FormItem label="联系方式">
                                <Input v-model="detail.contact" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="24">
                            <FormItem label="主要工作内容">
                                <Input v-model="detail.job" type="textarea" disabled></Input>
                            </FormItem>
                        </Col>
                        <Col span="24">
                            <FormItem label="协助人">
                                <Input :value="detail.assistant" disabled></Input>
                            </FormItem>
                        </Col>
                    </template>
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
