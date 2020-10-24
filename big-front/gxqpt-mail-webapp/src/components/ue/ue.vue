<template>
	<div id="ueditor">
		<hyUpload :uploadBtn="imgUploadId" class="hidden" ref="imgHyUpload" action="/api/file/p/file/simple" :accept="imgType" :onSuccess="imgfileUploadSuccess" />
		<hyUpload :uploadBtn="fileUploadId" class="hidden" ref="fileHyUpload" action="/api/file/p/file/simple" :accept="fileType" :onSuccess="fileUploadSuccess" />
		<script :id=id type="text/plain"></script>
	</div>
</template>
<script>
	// 文件上传
	import hyUpload from '@/components/hengyun/hyUpload'
	import $ from '@static/login/jquery-3.3.1.min.js'
	export default {
		name: 'UE',
		data() {
			return {
				editor: null,
				imgType: 'image/*',
				fileType: '',
				imgUploadId: 'imgId',
				fileUploadId: 'fileId',
				ueHtml:""
			}
		},
		props: {
			defaultMsg: {
				type: String
			},
			config: {
				type: Object
			},
			id: {
				type: String
			},
		},
		components: {
			hyUpload
		},
		mounted() {
			const _this = this;
			UE.registerUI('uploadimg', function(editor, uiName) {
				//注册按钮执行时的command命令，使用命令默认就会带有回退操作
				editor.registerCommand(uiName, {
					execCommand: function() {
						alert('execCommand:' + uiName)
					}
				});
				let domeRefs = _this.$refs;
				//创建一个button
				var uploadimg = new UE.ui.Button({
					//按钮的名字
					name: "uploadimg",
					//提示
					title: "图片上传",
					//添加额外样式，指定icon图标，这里默认使用一个重复的icon
					cssRules: 'background-position: -380px 0px;',
					//点击时执行的命令
					onclick: function() {
						//这里可以不用执行命令,做你自己的操作也可
						// editor.execCommand(uiName);
						document.getElementById('imgId').click();
					}
				});
				//当点到编辑内容上时，按钮要做的状态反射
				editor.addListener('selectionchange', function() {
					var state = editor.queryCommandState(uiName);
					if(state == -1) {
						uploadimg.setDisabled(true);
						uploadimg.setChecked(false);
					} else {
						uploadimg.setDisabled(false);
						uploadimg.setChecked(state);
					}
				});
				//因为你是添加button,所以需要返回这个button
				return uploadimg;
			});
			UE.registerUI('uploadfiles', function(editor, uiName) {
				//注册按钮执行时的command命令，使用命令默认就会带有回退操作
				editor.registerCommand(uiName, {
					execCommand: function() {
						alert('execCommand:' + uiName)
					}
				});
				//创建一个button
				var uploadfiles = new UE.ui.Button({
					//按钮的名字
					name: "uploadfiles",
					//提示
					title: "附件上传",
					//添加额外样式，指定icon图标，这里默认使用一个重复的icon
					cssRules: 'background-position: -620px -40px;',
					//点击时执行的命令
					onclick: function() {
						//这里可以不用执行命令,做你自己的操作也可
						// editor.execCommand(uiName);
						document.getElementById('fileId').click();
						// _this.$refs.fileHyUpload.fileUpload();
						
					}
				});
				//当点到编辑内容上时，按钮要做的状态反射
				editor.addListener('selectionchange', function() {
					var state = editor.queryCommandState(uiName);
					if(state == -1) {
						uploadfiles.setDisabled(true);
						uploadfiles.setChecked(false);
					} else {
						uploadfiles.setDisabled(false);
						uploadfiles.setChecked(state);
					}
				});
				//因为你是添加button,所以需要返回这个button
				return uploadfiles;
			});
			this.editor = UE.getEditor(this.id, this.config); // 初始化UE
			this.editor.addListener("ready", function() {
			  _this.$emit('editorInput');
//				_this.$emit('getEditor');
				_this.editor.setContent(_this.defaultMsg); // 确保UE加载完成后，放入内容。
			});
			UE.getEditor(this.id).addListener('blur', function(editor) {
				_this.$emit('editorUpdate', _this.getUEContent(),_this.getUEContentTxt());
			});
		},
		methods: {
			getUEContent() { // 获取内容方法
				return this.editor.getContent();
			},
			getUEContentTxt() { // 获取纯文本内容方法
				return this.editor.getContentTxt()
			},
			imgfileUploadSuccess(resp, file, fileList) {
				let fileArray = file.response.data.list;
				for(let j in fileArray) {
					let url = fileArray[j].url;
					let html = `<img src='${url}'/>`;
					this.editor.focus();
					this.editor.execCommand('inserthtml', html);
				}
			},
			fileUploadSuccess(resp, file, fileList) {
				let fileArray = file.response.data.list;
				for(let j in fileArray) {
					let url = fileArray[j].url;
					let name = fileArray[j].submittedFileName;
					let apiRoot = process.env.API_ROOT;
					let urlDownload = apiRoot+"/api/file/file/download?url=" + url + "&filename=" + name;
					let html = '<a href="' + urlDownload + '">' + name + '</a>';
					this.ueHtml = html;
					this.editor.focus();
					this.editor.execCommand('inserthtml', html);
				}
			},
			setContent(val){
				this.editor.setContent(val);
			},
			writeContent(val){
				this.editor.setContent(val, true);
			},
			setDisabled(){//设置当前编辑区域不可编辑
				this.editor.setDisabled();
			},
			setEnabled(){//设置当前编辑区域可编辑
				this.editor.setEnabled();
			},
			execCommand(){//清空内容
				this.editor.execCommand('cleardoc');
			},
			enabledOrDisabled(val){
				var _this = this;
//				_this.editor.addListener("ready", function() {
					if(val || val==0){
						if(val==1){
							_this.setEnabled();
						}else if(val==0){
							_this.execCommand();
							_this.setDisabled();
						};
					}
//				});
			}
		},
		destroyed() {
			this.editor.destroy();
		},
	}
</script>

<style>
	#ueditor .hidden {
		display: none;
	}
	#ueditor .edui-default .edui-button-body, 
	#ueditor .edui-splitbutton-body, 
	#ueditor .edui-menubutton-body, 
	#ueditor .edui-combox-body{
		height: 20px;
	}
	.edui-default .edui-toolbar .edui-combox .edui-combox-body{
		height: 24px;
	}
</style>