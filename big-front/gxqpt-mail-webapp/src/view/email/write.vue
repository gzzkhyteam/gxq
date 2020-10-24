<template>
	<div class="ivu-layout wAuto">
		<Layout>
			<Content>
				<Breadcrumb>
					<BreadcrumbItem>邮件管理系统</BreadcrumbItem>
					<BreadcrumbItem>{{pageTilte}}</BreadcrumbItem>
				</Breadcrumb>
				<email ref="email" :writeType="writeType"></email>
			</Content>
		</Layout>
	</div>
</template>

<script>
	import UE from '@/components/ue/ue'
	import email from '@/view/common/emailMoal.vue'
	export default {
		data() {
			return {
				writeType:{
					pageType:"",
					folderType:"",
					mailId:"",
				},
				pageTilte:"写信",
			}
		},
		components: {
			UE,
			email
		},
		mounted(){
			this.setWritdType();
		},
		methods:{
			setWritdType(){
				this.writeType.pageType = this.$route.params.pageType;
				this.writeType.folderType = this.$route.params.folderType;
				this.writeType.mailId = this.$route.params.mailId;
				if(this.writeType.mailId && this.writeType.mailId!="-1"){
					if(this.writeType.pageType=="forward"){
						this.pageTilte="转发";
					}else if(this.writeType.pageType=="reloadSend"){
						this.pageTilte="编辑";
					}else{
						this.pageTilte="回复";
					}
				}else{
					this.pageTilte="写邮件";
				};
			}
		},
		watch: {
			'$route' (val, oldVal){
	            this.setWritdType(); //获取表格列表
	        },

		},
	}
</script>

<style type="text/css">
	.wAuto{
		width: 100%;
	}
	.ml {
		margin-left: 20px;
	}
	
	.pl {
		padding-left: 1.8em;
	}
	
	.writeForm .ivu-form-item {
		width: 100%;
	}
	
	.title-right {
		border-left: 2px solid #0091D0;
		padding-left: 6px;
		line-height: 12px;
	}
	
	.treeMain{
		margin: 10px 0;
		padding: 10px;
		border:1px solid #ddd;
	}
</style>