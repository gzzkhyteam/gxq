<template>
    <li style="height: 100%;">
        <a class="mu-item-wrapper">
            <div class="mu-item" style="height:auto;min-height:48px;">
                <div class="mu-item-title"><img v-if="req" src="../../assets/reqIcon.png">{{name}}</div> 
                <div class="mu-item-action" :class="{actionInput:textare || chips}">
                    <span v-if="!!content" class="mu-item-after-text" style="color: rgba(0, 0, 0, 0.87);">{{content}}</span>
                    <div v-if="textare">
                        <div :style="{fontSize: fontSize , lineHeight: lineHeight, height: fullHeight ? '100%': 'auto'}" class="auto-textarea-wrapper">
                            <textarea @focus="focusInput" @blur="blurInput" ref="vTextarea" :autofocus="s_autofocus" @keyup="change" spellcheck="false"  :placeholder="inputP" v-model="temp_value"  class="auto-textarea-input mu-text-field-input">
                            </textarea>
                        </div>
                    </div>
                    <div class="chipsList" v-if="chips">
                        <mu-chip class="demo-chip" v-for="(name, index) in nameArr" :key="index" @delete="remove(index)" delete>{{ name.name }}<{{ name.nickname }}></mu-chip>
                        <mu-icon style="margin-top:0.5rem;" value="add_circle" @click="goTree"></mu-icon>
                    </div>
                </div>
            </div>
        </a>
    </li>
</template>
<script>
import autosize from 'autosize'
export default {
    props:{
        name: {
            type: String,
            default: ''
        },
        icon: {
            type: Boolean,
            default: true
        },
        req: {
            type: Boolean,
            default: true
        },
        textare: {
            type: Boolean,
            default: false
        },
        chips: {
            type: Boolean,
            default: false
        },
        clear: {
            type: Boolean,
            default: false
        },
        type: {
            type: String,
            default: ''
        },
        content: {
            type: String,
            default: ''
        },
        nameArr: {
            type: Array
        },
        fontSize: {
            type: String,
            default: '14px'
        },
        modelT: {
            type: String,
            default: ''
        },
        lineHeight: {
            type: String,
            default: '18px'
        },
        fullHeight: {
            type: Boolean,
            default: false
        },
    },
    mounted(){
        const textareas = this.$refs.vTextarea;
        autosize(textareas);
    },
    activated(){
        console.log(this.nameArr);
    },
    data () {
        return{
            inputP:'请输入',
            temp_value: (() => {
                console.log(this.modelT);
                return this.modelT;
            })(),
            s_autofocus: (() => {
                if (this.autofocus) {
                    return 'autofocus'
                } else {
                    null
                }
            })()
        }
    },
    activated(){
        if(this.clear)this.temp_value = '';
    },
    methods:{
        change(v) {
            this.$emit('test',this.temp_value);
        },
        focusInput () {
            this.inputFocus=true;
            this.inputP='';
        },
        blurInput () {
            if(!this.modelT){
                this.inputFocus=false;
                this.inputP='请输入';
            }
        },
        remove (index) {//移除标签
            this.nameArr.splice(index, 1);
        },
        goTree(){
            this.$store.dispatch('openLoading')
            this.$router.push({
                name:'getTreeEmpPhoneByUserIdItem',
                params:{type:this.type}
            });
        },
    },
    created() {
    },
    components: {
    }
}
</script>
<style lang="less" scoped>
.container{
    padding:0;
    height:100%;
    background: #fafafa;
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
}
.mu-list{
    padding: 8px 0;
    width: 100%;
    position: relative;
    overflow-x: hidden;
    overflow-y: visible;
    background: #fff;
    margin: 10px 0;
    border-bottom: 1px solid #ccc;
    .mu-item-title{
        font-size:1rem;
    }
    .mu-item-action{
        min-width:110px;
        line-height: 32px;
        font-size:1rem;
        .mu-item-after-text{
            font-size:1rem;
        }
    }
    .actionInput{
        width:100%;
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
      padding: 18px 0 10px 0;
      overflow-y: hidden;
      color: #2C3E50;
      resize:none;
      
    }
  .mu-text-field-input{
    overflow-x:visible;
    overflow-y:visible;
    height: auto;
    min-height: 32px;
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
    .chipsList{
        padding:0.5rem;
        position: relative;
        width: 100%;
        i{
            position: absolute;
            right: -0.5rem;
            bottom: 0;
        }
        span{
            margin-right: 5px;
        }
    }
</style>


