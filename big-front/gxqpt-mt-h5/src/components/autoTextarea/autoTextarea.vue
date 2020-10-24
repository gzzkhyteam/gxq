<template>
    <div>
        <div :class="{ isFloat : !inputFocu, focus : inputFocu}" class="mu-form-item-label"><img src="../../assets/reqIcon.png">{{floatName}}</div>
        <div class="mu-form-item-content">
            <div :class="{ focus : inputFocu }" class="mu-input">
                <div class="mu-text-field mu-input-content">
                    <div :style="{fontSize: fontSize , lineHeight: lineHeight, height: fullHeight ? '100%': 'auto'}" class="auto-textarea-wrapper">
                        <!-- <div :style="{fontSize: fontSize , lineHeight: lineHeight, minHeight: fullHeight ? '100%': 'auto'}" class="auto-textarea-block"><br/>{{temp_value}} </div> -->
                        <textarea :style="{fontSize: fontSize , lineHeight: lineHeight, minHeight: fullHeight ? '100%': 'auto',height:montHeight}" @focus="focusInput" @blur="blurInput" ref="vTextarea" :autofocus="s_autofocus" @keyup="change" spellcheck="false"  :placeholder="inputP" v-model="temp_value"  class="auto-textarea-input mu-text-field-input" :readonly="readonly">
                        </textarea>
                    </div>
                    <div>
                        <div class="mu-input-line"></div>
                        <div :class="{ lineFocus : inputFocu }" class="mu-input-focus-line"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script type="text/ecmascript-6">
import autosize from 'autosize'
export default {
    data() {
        return {
            inputP:this.placeholder,
            inputFocu:this.inputFocus,
            logForm:{
                todayConclusions:'',
            },
            todayConclusion:'',
            temp_value: (() => {
                return this.value;
            })(),
            s_autofocus: (() => {
                if (this.autofocus) {
                    return 'autofocus'
                } else {
                    null
                }
            })()
        };
    },
    mounted(){
        console.log(this.readonly);
        const textareas = this.$refs.vTextarea;
        autosize(textareas);
    },
    created() {
        console.log("编辑日志详情内容显示：")
        console.log(this.inputFocus);
        console.log(this.inputFocu);
    },
    props: {
        fullHeight: {
            type: Boolean,
            default: false
        },
        readonly: {
            type: Boolean,
            default: false
        },
        autofocus: {
            type: Boolean,
            default: false
        },
        value: {
            type: String,
            default: ''
        },
        placeholder: {
            type: String,
            default: ''
        },
        montHeight:{
            type:String,
            default:'60px'
        },
        onchange: {
            type: Function,
            default: null
        },
        fontSize: {
            type: String,
            default: '14px'
        },
        lineHeight: {
            type: String,
            default: '18px'
        },
        floatName:{
            type: String,
            default:''
        },
        inputFocus: {
            type: Boolean,
            default: false
        },
    },
    methods: {
        change($event) {
            if (this.onchange) {
                this.onchange(this.temp_value , $event)
            }
        },
        focusInput () {
            this.inputFocu=true;
            this.inputP='请输入';
        },
        blurInput () {
            if(!this.temp_value){
                this.inputFocu=false;
                this.inputP='';
            }
        },
    },
    watch: {
        value: function (val, oldVal) {
            this.temp_value = val
        },
        temp_value: function (val, oldVal) {
            this.$emit('input' , val)
        },
        '$route'(to,from) {
            if(to.name == "index"){
                this.inputFocu=false;
                this.inputP='';
            }
        },
    }
};
</script>
<style lang="less" scoped>
    .mu-form-item-label{
        margin-left: 2rem;
        width: 100%;
        text-align: left;
        img{
            position: absolute;
            left: -0.8rem;
            top: 0.5rem;
            width: 0.5rem;
            height:0.5rem;
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
            padding: 1rem 0;
            box-sizing: border-box;
            font-size: 100%;
        }
        .auto-textarea-input{
            font-family: Menlo, "Ubuntu Mono", Consolas, "Courier New", "Microsoft Yahei", "Hiragino Sans GB", "WenQuanYi Micro Hei", sans-serif;
        //   position: absolute;
            width: 90%;
            height: 90%;
            top: 0;
            left: 0;
            margin: 1rem 2rem 0 2rem;
            text-align: left;
            overflow-y: hidden;
            color: #2C3E50;
            resize:none;
        }
    }
    .mu-text-field-input{
        overflow-x:visible;
        overflow-y:visible;
        height: auto;
        min-height: 32px;
    }
    .focus{
        color:#2196f3;
    }
    .isFloat{
        -webkit-transform: translate3d(0,28px,0);
        transform: translate3d(0,28px,0);
        font-size: 1.2rem;
        top:20px;
    }
    .lineFocus{
        transform: scaleX(1);
        -webkit-transform: scaleX(1);
    }
    .mu-input-line, .mu-input-focus-line{
        bottom:0;
    }
</style>
