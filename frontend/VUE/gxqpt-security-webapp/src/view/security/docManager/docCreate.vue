<template>
	<div id="examine">
		<Form ref="docData" :model="docData" :rules="ruleValidate" :label-width="100">
			<Row>
		        <Col span="12">
		        	<FormItem label="文档名称：" prop="docName">
						<Input type="text" > </Input>
					</FormItem>
		        </Col>
		        <Col span="12">
		        	<FormItem label="文档类别：" prop="docType">
						<Select >
							<Option value="0">全部</Option>
							<Option value="1">制度文档</Option>
							<Option value="2">流程文档</Option>
							<Option value="3">实施细则</Option>
							<Option value="4">操作手册</Option>
							<Option value="5">工作指南</Option>
						</Select>
					</FormItem>
		        </Col>
		    </Row>
		    <FormItem label="文档描述：" prop="docDescribe">
		    	<Row>
        			<Col span="24">
						<Input type="textarea" :rows="5" ></Input>
					</Col>
    			</Row>
			</FormItem>
		    <FormItem label="文档上传：">
		    	<Row>
        			<Col span="24">
						<Upload  ref="evalReport":on-success="setEvalReport" :on-remove="removeEvalReport" multiple class="left" action="//jsonplaceholder.typicode.com/posts/">
							<Button type="ghost" icon="ios-cloud-upload-outline">选择文件</Button>
						</Upload>
					</Col>
    			</Row>
			</FormItem>
		</Form>
	</div>
</template>

<script>
	export default{
		data(){
			return{
				docData:{},
				ruleValidate: {
					docName: [{
						required: true,
						message: '文档名称不可以为空',
						trigger: 'blur'
					}],
					docType: [{
						required: true,
						message: '文档类别不可以为空',
						trigger: 'blur'
					}],
					docDescribe: [{
						required: true,
						message: '文档描述不可以为空',
						trigger: 'blur'
					}]
				},
			}
		},
		methods:{
			handleSubmit(name) {
				this.$refs[name].validate((valid) => {
					if(valid) {
						this.$emit('examine',this.docData); 
					}
				})
			},
		}
	}
</script>

<style>
</style>