<template>
    <mu-container>
        <div class="mu-paper mu-appbar mu-primary-color mu-inverse  mu-paper-elevation-4 top-bar-box" style="position:fixed">
			<div class="mu-appbar-left">
				<a @click="goback" class="mu-button mu-flat-button" style="font-size: 1.2rem;" tabindex="0">
					<div class="mu-button-wrapper">
						<div class="mu-ripple-wrapper"></div> 
						<i class="mu-icon material-icons" style="user-select: none;color: #fff;">keyboard_arrow_left</i>
						返回
					</div>
				</a>
			</div> 
			<div class="mu-appbar-title">
				<div class="mu-appbar-title">{{ title }}</div> 
			</div>
            <mu-button flat slot="right" @click="send" style="font-size:1rem">
                发送
            </mu-button>
		</div>
        <mu-list>
            <mu-list class="input-list-group mu-email-form">
                <inputModel name="收件人" :clear="clear" :req='true' :icon="!icon" type='recipient' chips :nameArr='recipients'></inputModel>
                <inputModel name="抄送" :clear="clear" :req='false' :icon="!icon"  type='copy' chips :nameArr='copy'></inputModel>
                <inputModel @test="getEmailTheme" :modelT="emailTheme" name="主题" :clear="clear" :req='true' :icon="!icon" textare></inputModel>
                <li style="height: 100%;">
                    <a class="mu-item-wrapper">
                        <div class="mu-item" style="height:170px; overflow-y: auto;">
                            <div class="mu-item-title">邮件内容</div> 
                            <div class="mu-item-action actionInput">
                                <div>
                                    <div style="fontSize:14px;lineHeight:18px;height:auto" class="auto-textarea-wrapper">
                                        <textarea
                                            :rows="textRows"
                                            @focus="focusInput"
                                            @blur="blurInput"
                                            ref="vTextarea"
                                            :autofocus="s_autofocus"
                                            @keyup="change"
                                            spellcheck="false"
                                            :placeholder="inputP"
                                            v-model="emailContent"
                                            class="auto-textarea-input mu-text-field-input">
                                        </textarea>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </a>
                </li>
                <!-- <inputModel @test='getContent' name="邮件内容" :modelT="emailContent" :clear="clear" :req='false' :icon="!icon" textare></inputModel> -->
            </mu-list>
            <div class="mu-item" style="padding:0;">
                <Upload @deleteImg="DeleteImgArr" style="width: 100%;" :clear='clear' :imgArr="imgFile" :action="url" :onSuccess="UploadSuccess" :onError="UploadError"></Upload>
            </div>
        </mu-list>
        <mu-dialog title="消息" width="360" :open.sync="dialog">
            {{msg}}
            <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
        </mu-dialog>
    </mu-container>
</template>

<script>
import ApiList from '@/api/apiList'
import api from '@/api/axiosApi'
import inputModel from '@/components/inputModel/inputModel'
import eventBus from '@/public/eventBus.js'
import Upload from '@/components/HY/Upload'
import Approver from '@/components/approver/approver'
import autosize from 'autosize'
export default {
    data(){
        return{
            title:'写邮件',
            recipients:[],
            copy:[],
            textRows:6,
            emailTheme:'',//主题
            emailContent:'',//邮件内容
            imgFile:[],//图片内容
            chance:[],
            inputP:'请输入',
            s_autofocus: (() => {
                if (this.autofocus) {
                    return 'autofocus'
                } else {
                    null
                }
            })(),
            sendData:{
                "attachment":[],
                "bcc": "",
                "cc": "",
                "content": "",
                "exigence": false,
                "from": "",
                "sended": true,
                "subject": "",
                "text": false,
                "time": false,
                "to": "",
                "isReplySign": 0
            },
            clear:false,
            dialog:false
        }
    },
    watch:{
        '$route'(to,from) {
            if(from.name != 'getTreeEmpPhoneByUserIdItem'){
                this.clear =true;
            }else{
                this.clear =false;
            }
        },
    },
    mounted(){
        this.$store.dispatch('closeLoading', false);
        // const textareas = this.$refs.vTextarea;
        // autosize(textareas);
    },
    activated(){
        if(this.clear){//清空其他值
            this.recipients = [];
            this.copy = [];
            this.emailTheme = '';
            this.emailContent = '';
            this.imgFile = [];
            this.title = '写邮件';
            this.textRows = 6;
        }
        this.$store.dispatch('closeLoading', false);
        if(this.$route.params.content){
            let type = this.$route.params.type;
            let reg = new RegExp('<br/>','g');
            (type == 'reply') ? this.title = '转发邮件' : (this.title = '回复邮件',this.recipients.push({nickname:this.$route.params.content.from}));
            // this.emailTheme = this.title + "：" +this.$route.params.content.subject;//主题赋值
            this.$route.params.content.content = this.$route.params.content.content.replace(reg,'\n');//空格格式转换
            this.emailContent = "\n\n\n\n\n----原始邮件内容----" 
            + "\n发件人：" + this.$route.params.content.from 
            + "\n发送时间：" + this.$route.params.content.date 
            + "\n收件人：" + this.$route.params.content.to 
            + "\n主题：" + this.$route.params.content.subject 
            + "\n正文内容：" + this.$route.params.content.content;
        }
        //根据key名获取传递回来的参数，data就是map
        eventBus.$on('nameArr', function(data,type){//抄送人回调
            var data = JSON.parse(data);
            data.forEach(item => {
                if(item.nickname.indexOf('@') !== -1){
                  item.nickname = `${item.nickname.split('@')[0]}`
                }
                item.nickname = item.nickname + "@gygxq.com";
            });
            if(type == 'recipient'){
                (!!this.recipients) ? this.recipients = this.arrConcat(this.recipients,data) : this.recipients = data;
            }else if(type == 'copy'){
                (!!this.copy) ? this.copy = this.arrConcat(this.copy,data) : this.copy = data;
            }
        }.bind(this));
    },
    methods:{
        UploadSuccess(res){
            this.imgFile=res;
            this.sendData.attachment = [];
            res.forEach(item=>{
                let obj = {};
                obj.fileName = item.fileName;
                obj.url = item.fileUrl;
                this.sendData.attachment.push(obj);
            })
            console.log(this.sendData);
            this.$store.state.applyData.images = JSON.parse(JSON.stringify(res).replace(/id/g,"fileId"));
        },
        UploadError(res){
            this.msg = res.errmsg;
            this.dialog = true;
        },
        DeleteImgArr(v){
            this.UploadSuccess(v);
        },
        getEmailTheme(v){
            this.emailTheme = v;
            this.sendData.subject = v;
        },
        send(){//邮件发送
            let reg = new RegExp('\n','g');
            if(this.validate()){
                let recArr = [], copyArr = [];
                this.recipients.forEach(item=>{
                    if (item.name) {
                        recArr.push('"' + item.name + '"'  + '<' + item.nickname + '>');
                    } else { // 回复，且没有修改收件人
                        const names = item.nickname.split('<');
                        const to = '"'+names[0]+'"'+'<'+names[1];
                        recArr.push(to);
                    }
                })
                this.copy.forEach(item=>{
                    copyArr.push('"' + item.name + '"'  + '<' + item.nickname + '>');
                })
                this.sendData.content = this.emailContent;
                this.sendData.content = this.sendData.content.replace(reg,'<br/>');
                this.sendData.to = recArr.join(",");
                this.sendData.cc =copyArr.join(",");
                let sendDataFrom = ''
                if(this.$store.state.userInfo.account.indexOf('@') !== -1){
                  sendDataFrom = `${this.$store.state.userInfo.account.split('@')[0]}`
                }else{
                  sendDataFrom = this.$store.state.userInfo.account
                }
                this.sendData.from ='"' + this.$store.state.userInfo.userName + '"' + '<' + sendDataFrom + '@gygxq.com>';
                api(ApiList.sendEmail,this.sendData).then((res)=>{
					if(res.data.errcode==0){
						this.msg = "发送成功!";
                        this.dialog = true;
                        this.$router.push({
                            path:'/'
                        });
					}else{
						this.msg = res.data.errmsg;
						this.dialog = true;
					}
				},(error)=>{
                    console.log(error)
                })
            }
        },
        validate(){//校验表单
            if(this.recipients.length == 0){
                this.msg = "收件人不能为空！";
                this.dialog = true;
                return false;
            }else if(this.emailTheme == ''){
                this.msg = "主题不能为空";
                this.dialog = true;
                return false;
            }else{
                return true;
            }
        },
        closeDialog(){
            this.dialog = false;
        },
        goback () {
            this.$store.dispatch('openLoading')
            this.$router.go(-1);
        },
        arrConcat(arr1,arr2){//数组去重
            let arr = {};
            for(var i=0;i<arr1.length;i++){
                arr[arr1[i].gxqptEmpId]=true;
            }
            for (var i = 0; i < arr2.length; i++) {
                if(!arr[arr2[i].gxqptEmpId]){
                    arr1.push(arr2[i]);
                }
            }; 
            return arr1;  
        },
        change(v) {
            // console.log(v);
        },
        focusInput () {
            this.inputP='';
        },
        blurInput () {
            if(!this.modelT){
                this.inputP='请输入';
            }
        },
    },
    components: {
        inputModel,
        Upload,
        Approver
    }
}
</script>

<style lang="less" scoped="scoped">
.container {
    padding: 0;
    background: #fafafa;
    .mu-list{
        padding: 8px 0 30px 0;
        width: 100%;
        position: relative;
        overflow-x: hidden;
        overflow-y: visible;
        margin:0;
        .mu-item-title{
            position: relative;
            padding: 0 0.8rem;
            img{
                position: absolute;
                left:0;
                width:0.5rem;
                height:0.5rem;
                margin-top: 8px;
            }
        }
        li{
            margin:1rem 0;
            background: #fff;
            border-top: 1px solid #eee;
            border-bottom: 1px solid #eee;
        }
        .mu-item    {
            height:auto;
            min-height:48px;
            background: #fff;
        }
        /deep/ .mu-item-title{
            font-size:1rem;
            width:50%;
        }
        /deep/ .mu-item-action{
            min-width:110px;
            position:relative;
            line-height: 32px;
            text-align: left;
            .mu-item-after-text{
                font-size:1rem;
            }
        }
    }
    .mu-appbar{
		/* position: fixed; */
		top: -2px;
		left: 0;
		z-index: 1000;
		width:100%;
	}
	.mu-primary-color{
		background-color: #38ADFF;
	}
	.mu-appbar-title{
		width: 100%;
		font-size: 1rem;
    	text-align: center;
	}
	.mu-button-wrapper{
		font-size: 1rem;
		color: #fff;
    }
    .mu-email-form{
        padding-top:56px;
        /deep/ .mu-input{
            width: 90%;
        }
    }
    /deep/ .material-icons{
        color:#38ADFF;
    }
    .formItem{
        position: relative;
        i{
            position: absolute;
            right: 1rem;
            top: 30%;
        }
    }
    .auto-textarea-wrapper{
        position:relative;
        width: 100%;
        margin: 0;
        padding: 0;
        line-height: normal;
        .auto-textarea-block{
        display: block;
        white-space: pre-wrap;
        word-wrap: break-word !important;
        visibility: hidden;
        overflow: hidden;
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-size: 100%;
        }
    }
    .auto-textarea-input{
        font-family: Menlo, "Ubuntu Mono", Consolas, "Courier New", "Microsoft Yahei", "Hiragino Sans GB", "WenQuanYi Micro Hei", sans-serif;
        width: 100%;
        height: 100%;
        font-size:1rem;
        padding: 18px 0 0;
        overflow-y: hidden;
        color: #2C3E50;
        resize:none;
        
        }
    .mu-text-field-input{
        overflow-x:visible;
        overflow-y:visible;
        height: auto;
        min-height: 32px;
        height:auto;
        line-height: 25px;
    }
    .focus{
        color:#2196f3;
    }
    .isFloat{
        -webkit-transform: translate3d(0,28px,0);
        transform: translate3d(0,28px,0);
        font-size: 16px;
    }
    .lineFocus{
        transform: scaleX(1);
        -webkit-transform: scaleX(1);
    }
    .mu-input-line, .mu-input-focus-line{
        bottom:0;
    }
    .actionInput{
        width:100%;
    }
}
</style>
