<template>
    <Card :bordered="false" style="margin-bottom: 30px;">
        <p slot="title">培训详情</p>
        <div style="text-align:center">
            <Form :model="detail" :label-width="70" class="clearfix">
                <Row :gutter="40">
                    <Col span="24">
                        <FormItem label="培训类别">
                            <Input :value="detail.trainType" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="培训名称">
                            <Input :value="detail.trainName" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="12">
                        <FormItem label="培训时间">
                            <Input
                                type="text"
                                :value="detail.trainTime"
                                style="float: left;"
                                disabled>
                            </Input>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="培训地址">
                            <Input :value="detail.trainAddress" disabled></Input>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="培训内容" :label-width="72">
                            <Input :value="detail.trainInfo" type="textarea" disabled :autosize="{minRows: 5}"></Input>
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
