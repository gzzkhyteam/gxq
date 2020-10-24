<template>
	<div class="hy-upload">
		<Upload :action="action" :headers="self_headers" :data="self_data" :multiple="multiple" 
			:type="type" :show-upload-list="showUploadList" :accept="accept" :max-size="maxSize" :before-upload="beforeUpload" 
			:on-progress="onProgress" :format="format" :on-success="preSuccess" :on-error="onError" :on-remove="onRemove" 
			:on-format-error="onFormatError" :on-exceeded-size="onExceededSize" :default-file-list="defaultFileList" ref="upload">
			<Button type="ghost" icon="ios-cloud-upload-outline" :on-preview="onPreview"><slot>选择文件</slot></Button>
		</Upload>
	</div>
</template>
<script>
	import { mapState } from 'vuex'
	export default {
		name: 'hyUpload',
		props: {
			action: { //上传的地址，必填
				type: String,
				default: '/api/file/p/file/simple'
			},
			headers: Object, //设置上传的请求头部
			data: Object, //上传时附带的额外参数
			multiple: Boolean, //是否支持多选文件
			showUploadList: { //是否显示已上传文件列表
				type: Boolean,
				default: true
			},
			type: String, //上传控件的类型，可选值为 select（点击选择），drag（支持拖拽）
			accept: String, //接受上传的文件类型
			format:Array, //设置默认已上传的列表
			maxSize: Number, //文件大小限制，单位 kb
			// beforeUpload: Function, //上传文件之前的钩子，参数为上传的文件，若返回 false 或者 Promise 则停止上传
			onProgress: Function, //文件上传时的钩子，返回字段为 event, file, fileList
			onSuccess: Function, //文件上传成功时的钩子，返回字段为 response, file, fileList
			onError: {
				type:Function, //文件上传失败时的钩子，返回字段为 error, file, fileList
				default:this.errorFuc
			},
			onPreview: Function, //点击已上传的文件链接时的钩子，返回字段为 file， 可以通过 file.response 拿到服务端返回数据
			onRemove: Function, //文件列表移除文件时的钩子，返回字段为 file, fileList
			onFormatError: Function, //文件格式验证失败时的钩子，返回字段为 file, fileList
			onExceededSize: Function, //文件超出指定大小限制时的钩子，返回字段为 file, fileList
			defaultFileList:Array //设置默认已上传的列表
		},
		data() {
			return {}
		},
		computed: {
			...mapState([
				'userInfo'
			]),
			self_headers() {
				return Object.assign({
					token: this.userInfo.token,
					_user_id: this.userInfo.userId,
				}, this.headers, true);
			},
			self_data() {
				return Object.assign({
					folderId: '-1'
				}, this.data, true);
			},
		},
		mounted () {
			this.$Message.config({
	            top: 100,
	            duration: 3
	        });
		},
		methods: {
			// 上传成功回调前的拦截
			preSuccess (resp, file, fileList) {
				if (resp.errcode === 0) {
					this.onSuccess(resp, file, fileList);
				} else {
					this.$Modal.confirm({
						content: '上传文件出错,请删除重试！'
					});
				}
			},
			clearFiles () {
				this.$refs.upload.clearFiles()
			},
			errorFuc(error, file, fileList){
				this.$Modal.confirm({
					content: '上传文件出错,请删除重试！'
				});
			},
			// 上传前操作
			beforeUpload (file) {
				const vm = this
				let fileArray = file.name.split('.')
				let length = fileArray.length - 1
				let fileType = fileArray[length]
				if (vm.format) {
					if (vm.format.length) {
						let fileTypeBoolean = false
						vm.format.map(item => {
							if (item === fileType) {
							fileTypeBoolean = true
							}
						})
						if (!fileTypeBoolean) {
							this.$Message.warning({
							content: '请上传' + vm.format.join('、') + '格式的文件！'
							})
							return false
						}
					}
				}
			}
		}
	}
</script>
<style lang="less" scoped="scoped">
	.hy-upload {
		text-align: left;
		display: table;
	}
	.ivu-form-item-content{
		height:auto;
	}
</style>

<style lang="less">
.hy-upload{
	.ivu-upload-list {
		.ivu-upload-list-file{
			width: 400px;
		    span{
		    	display: block;
		    	width: 380px;
			    white-space: nowrap;
			    text-overflow: ellipsis;
			    overflow: hidden;
			    float: left;
		    }
		}
	}
}
</style>