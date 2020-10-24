<template>
	<div class="approver">
		<div class="mu-form-item-label isFloat" v-show="name"><img v-if="req" src="../../assets/reqIcon.png">审批人</div>
        <div class="approverList" :class={listM:name}>
            <div @click="delUser(item)" class="approverItem" :key="index" v-for="(item,index) in chance">
                <img v-if="!!item.photo" class="approver-icon approver-img" :src=item.photo>
                <div v-if="!item.photo" class="approver-icon"></div>
                    <span>{{item.name}}</span>
                <div class="arrR" v-if="chance">
                    <img src="../../assets/arr-right.png">
                </div>
            </div>
            <div v-if="addPeo" class="approverItem addPeo" @click="openPeoList">+</div>
        </div>
	</div>
</template>

<script>
	import api from '@/api/axiosApi'
	import ApiList from '@/api/apiList'
	export default {
		props: {
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
            addPeo: {
                type: Boolean,
                default: true
            },
            name:{
                type: Boolean,
				default: true
            },
            chance:{
                type: Array,
				default: []
            },
			maxSize: {
				type: Number,
				default: Number.MAX_VALUE
            },
            backUrl: {
				type: String,
				default: 'logForm'
			},
		},
		data() {
			return {
				waitList: []
			}
        },
        created(){
            console.log(this.chance);
            console.log(this.backUrl);
        },
		methods: {
            openPeoList(){
                console.log("跳转审批人");
                this.$store.dispatch('openLoading')
                this.$router.push({
                    name:'getTreeEmpPhoneByUserIdItem',
                    params:{backUrl:this.backUrl,type:1}
                });
            },
            delUser(item){// 删除抄送人
                if(this.addPeo){
                    for(var i in this.chance){
                        if(item.gxqptEmpId==this.chance[i].gxqptEmpId){
                            this.chance.splice(i,1);
                        }
                    }
                }
            }
		}
	}
</script>

<style lang="less" scoped>
	.approver {
        text-align: left;
        padding:0 16px 2rem 16px;
	}
	.approverList{
        width:100%;
        height:80px;
        .approverItem{
            width: 50px;
            height: 50px;
            text-align: center;
            float: left;
            margin: 1rem 0.5rem 1rem 0.9rem;
            position: relative;
            .arrR{
                position: absolute;
                top: 30%;
                right: -1.2rem;
                img{
                    width:15px;
                    height:15px;
                }
            }
            .approver-icon{
                width: 50px;
                height: 50px;
                line-height: 120px;
                overflow: hidden;
                float: left;
                position: relative;
                border-radius: 10px;
                background: url("../../assets/approverHeader.png");
                background-size: 100% 100%;
                margin-bottom:0.2rem;
            }
            .approver-img{
                border-radius: 30px;
            }
            span{
                font-size:12px;
                font-weight: bold;
            }
        }
        .addPeo{
            height: 50px;
            border: 1px solid #ccc;
            border-radius: 50px;
            line-height: 50px;
            font-size: 20px;
            color: #ccc;
        }
    }
    .listM{
        margin-top: 40px;
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
        font-size:1rem;
        padding:0.8rem;
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