<template>
	<div class="approver">
		<div class="mu-form-item-label isFloat"><img v-if="req" src="../../assets/reqIcon.png">{{title}}<small class="subtext">{{subTitle}}</small></div>
        <div class="approverList">
            <div class="approverItem" v-for="user of userListData">
                <div class="approver-icon"></div>
                <span>{{user.name}}</span>
            </div>
        </div>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import ApiList from '@/api/apiList'

	export default {
		name:'userList',
		props: {
			title:String,
			subTitle:String,
			userListData:Array,
			disabled: Boolean,
			beforeRead: Function,
			beforeUpload: Function,
			resultType: {
				type: String,
				default: 'dataUrl'
			},
            req: {
                type: Boolean,
                default: true
            },
			maxSize: {
				type: Number,
				default: Number.MAX_VALUE
			}
		},
		data() {
			return {
				waitList: []
			}
		},
		methods: {
		}
	}
</script>

<style lang="less" scoped>
	.approver {
        text-align: left;
        padding:0 16px 2rem 16px;
        .subtext{
        	color: #777 !important;	
        }
	}
	.approverList{
        width:100%;
        height:80px;
        margin-top: 40px;
        .approverItem{
            width: 40px;
            height: 60px;
            text-align: center;
            float: left;
            margin-top: 1rem;
            margin-left: 0.9rem;
            .approver-icon{
                width: 40px;
                height: 40px;
                line-height: 120px;
                overflow: hidden;
                float: left;
                position: relative;
                border-radius: 10px;
                background: url("../../assets/approverHeader.png");
                background-size: 100% 100%;
                margin-bottom:0.2rem;
            }
            span{
                font-size:16px;
                font-weight: bold;
            }
        }
    }
	.pic-list {
		margin-left: 18px;
		width: 100%;
		height: auto;
		min-height: 80px;
		overflow: auto;
	}
	
	.wait-pic {
		height: 60px;
		width: 60px;
		margin: 10px;
		float: left;
		background-size: contain;
		background-position: center;
		background-repeat: no-repeat;
	}
	
	.isFloat {
		-webkit-transform: translate3d(0, 28px, 0);
		transform: translate3d(0, 28px, 0);
        font-size: 16px;
        font-size:1.2rem;
        padding:0 0.8rem;
		width: 100%;
		height: 28px;
        text-align: left;
        position: relative;
        img {
            position: absolute;
            left: 0;
            width: 0.5rem;
            height:0.5rem;
            margin-top: 8px;
        }
	}
</style>