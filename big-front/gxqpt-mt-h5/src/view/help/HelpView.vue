<template>
	<div class="main">
		<top-bar style="z-index:10000" title="帮助详情"></top-bar>
		<mu-container ref="container">
			<div class="doc-box">
				<mu-paper class="demo-paper step-list" :z-depth="1">
					<div class="text-title">
						<span class="left">{{doc.title}}</span>
						<span class="right date-time">{{doc.auditorTime}}</span>
					</div>
					<div class="step-item" v-html="doc.content"></div>
				</mu-paper>
			</div>
		</mu-container>
	</div>
</template>

<script>
	import topBar from '@/components/topBar'
	export default {
		data() {
			return {
			}
		},
		computed:{
			doc:function(){
				return this.$route.params.help;
			}
		},
		components: {
			topBar
		},
		mounted(){
			this.$store.dispatch('closeLoading', false);
			this.$refs.container.scrollTop = 0;
		}
	}
</script>

<style lang="less" scoped="scoped">
	.main {
		height: 100%;
		background: #fff;
		.doc-box {
			padding: 8px;
			.text-title,
			.step-list {
				float: left;
				width: 100%;
			}
			.text-title {
				margin-bottom: 12px;
				height: 28px;
				.date-time {
					color: #ccc;
				}
			}
			.step-list {
				padding: 12px;
				border: 1px solid #ccc;
				border-radius: 8px;
				.step-item {
					text-align: left;
					line-height: 22px;
					font-size: 0.9rem;
				}
			}
		}
	}
	.step-item /deep/ img{
		width:80%;
		margin:1rem 10%;
	}
</style>