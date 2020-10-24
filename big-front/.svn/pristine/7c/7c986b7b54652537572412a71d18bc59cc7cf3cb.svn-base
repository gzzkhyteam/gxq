<template>
    <Card :bordered="false">
        <p slot="title">服务反馈</p>
        <div style="text-align:center">
            <Form :model="serverData" :label-width="100" class="clearfix">
                <Row :gutter="40">
                    <Col span="18">
                        <FormItem label="服务态度：" prop="attitude" class="textleft">
                            <hy-rate disabled  show-text :value="Number(serverData.serviceAttitude)" :sglValue="20">
                                <span style="color: #f5a623">{{Number(serverData.serviceAttitude)}}</span>
                            </hy-rate>
                        </FormItem>
                    </Col>
                    <Col span="18">
                        <FormItem label="服务效率：" class="textleft">
                            <hy-rate disabled  show-text :value="Number(serverData.serviceEfficiency)" :sglValue="20">
                                <span style="color: #f5a623">{{Number(serverData.serviceEfficiency)}}</span>
                            </hy-rate>
                        </FormItem>
                    </Col>
                    <Col span="18">
                        <FormItem label="服务质量：" class="textleft">
                            <hy-rate disabled show-text :value="Number(serverData.serviceEvaluation)" :sglValue="20">
                                <span style="color: #f5a623">{{Number(serverData.serviceEvaluation)}}</span>
                            </hy-rate>
                        </FormItem>
                    </Col>
                    <Col span="24">
                        <FormItem label="建议：" :label-width="100">
                            <Input :value="serverData.serviceAdvice" type="textarea" :autosize="{minRows: 2,maxRows: 2}" placeholder="请输入建议..." disabled></Input>
                        </FormItem>
                    </Col>
                </Row>
            </Form>
        </div>
    </Card>
</template>

<script>
export default {
    props:['serverData']
}
</script>

<style scoped>
.ivu-form-item >>> .ivu-form-item-content{
    height:auto;
}
.ivu-input-wrapper >>> textarea{
    resize: none;
}
.textleft{
	text-align: left;
}
</style>
