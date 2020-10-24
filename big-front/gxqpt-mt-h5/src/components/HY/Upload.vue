<template>
  <div class="hy-upload">
    <div class="upload-name">添加图片</div>
    <div class="upload-icon" @click="updateImgList">
      <!-- <input
        ref="input"
        type="file"
        accept="image/*"
        class="upload-input"
        :disabled="disabled"
        @change="onChange"
        :multiple="multiple"
      > -->
    </div>
    <div class="pic-list" v-if="waitList.length > 0">
      <div class="wait-item" v-for="(pic,index) in waitList" :key=index >
        <div class="wait-pic" v-if="pic.fileType.indexOf('image')>-1" :style="{backgroundImage: `url(${pic.fileUrl})`}" @click="lookImg(pic.fileUrl)">
          <a @click.stop="deleteImg(pic.fileUrl)"><img src="../../assets/delete.png"></a>
        </div>
         <div class="wait-pic" v-if="pic.fileType.indexOf('text')>-1 || pic.fileType.indexOf('application')>-1">
            {{pic.submittedFileName}}
            <a @click.stop="deleteImg(pic.fileUrl)"><img src="../../assets/delete.png"></a>
          </div>
      </div>
    </div>
    <mu-dialog title="消息" width="360" :open.sync="dialog">
        {{msg}}
        <mu-button slot="actions" flat color="primary" @click="closeDialog">确定</mu-button>
    </mu-dialog>
    <mu-dialog width="360" transition="fade" fullscreen :open.sync="openFullscreen">
      <img style="width:90%;padding:5%;background:#000;" :src="screenImg">
    </mu-dialog>
  </div>
</template>

<script>
import api from '@/api/axiosApi'
import ApiList from '@/api/apiList'
import ajax from './ajax'
function noop () {}
export default {
  props: {
    disabled: Boolean,
    imgArr:{
      type: Array,
      default: []
    },
    autoUpload: {
      type: Boolean,
      default: true
    },
    clear: {//是否清空数据
      type: Boolean,
      default: true
    },
    multiple: {
      type: Boolean,
      default: true
    },
    beforeUpload: Function,
    maxSize: {
      type: Number,
      default: Number.MAX_VALUE
    },
    onSuccess: {
      type: Function,
      default: noop
    },
    onProgress: {
      type: Function,
      default: noop
    },
    onError: {
      type: Function,
      default: noop
    },
    // 删除文件
    onRemove: {
      type: Function,
      default: noop
    },
    // 上传的api地址
    action: {
      type: String,
      required: true
    }
  },
  data () {
    return {
      waitList: this.imgArr || [],
      openFullscreen:false,
      screenImg:'',
      tempIndex: 1,
      uploadFiles: [],
      reqs: {},
      fileList: [],
      msg:'',
      dialog:false,
    }
  },
  activated(){
    if(this.clear)this.waitList = [];
  },
  methods: {
    deleteImg(url){
      for(var i = 0;i<this.waitList.length;i++){
        if(url==this.waitList[i].fileUrl){
          this.waitList.splice(i,1);
        }
      }
      this.$emit('deleteImg',this.waitList);
    },
    closeDialog(){
        this.dialog = false;
    },
    lookImg(url){//图片放大
      this.screenImg = url;
      this.openFullscreen = true;
    },
    doSubmit () {
      const vm = this;
      if (autoUpload) { return; }
      this.fileList.forEach(rawFile => {
        vm.handleStart(rawFile);
        vm.upload(rawFile);
      });
    },
    onChange (event) {//H5图片上传
      const vm = this
      let { files } = event.target
      if (vm.disabled || !files.length) {
        return
      }

      files = Array.prototype.slice.call(files);
      if (!vm.multiple) { files = files.slice(0, 1); }

      if (files.length === 0) { return; }

      this.fileList = files;
      this.fileList.forEach(rawFile => {
        vm.handleStart(rawFile);
        if (vm.autoUpload) vm.upload(rawFile);
      });
    },
    updateImgList(){
      let _this = this;
      if(_this.waitList.length>=3){
        this.msg = '只能上传3张图片'
        this.dialog = true;
        return;
      }
      _this.$store.dispatch('openLoading');
      let total = 3 - _this.waitList.length;//给安卓传递参数
      Android.updateImgList(total,function (res) {
        console.log("安卓获取的图片数据：");
        console.log(res);
        if(res.errcode==0){
          // if (res.data.list.length < total) {
          //   _this.msg = '共有' + (total - res.data.list.length) + '张图片上传失败，请重试！';
          //   _this.dialog = true;
          // }
          res.data.list.forEach(item => {
            let obj = {};
            obj.dataType = item.dataType;
            obj.ext = item.ext;
            obj.fileName = item.filename;
            obj.id = item.id;
            obj.fileType = item.mime;
            obj.fileSize = item.size;
            obj.wordname = item.submittedFileName;
            obj.fileUrl = item.url;
            _this.waitList.push(obj);
          });
        }else{
          _this.msg = res.errmsg;
          _this.dialog = true;
        }
        _this.onSuccess(_this.waitList);
        _this.$store.dispatch('closeLoading',false);
      });
    },
    // 开始上传前的数据准备
    handleStart(rawFile) {
      this.$store.dispatch('openLoading');
      rawFile.uid = Date.now() + this.tempIndex++;
      let file = {
        status: 'ready',
        name: rawFile.name,
        size: rawFile.size,
        percentage: 0,
        uid: rawFile.uid,
        raw: rawFile
      };

      try {
        file.url = URL.createObjectURL(rawFile);
      } catch (err) {
        console.error(err);
        return;
      }

      this.uploadFiles.push(file);
    },
    // 上传前控制
    upload(rawFile) {
      if (rawFile.size > this.maxSize) {
        this.onError('图片过大', rawFile);
        return;
      }
      this.$refs.input.value = null;

      if (!this.beforeUpload) {
        return this.post(rawFile);
      }

      const before = this.beforeUpload(rawFile);
      if (before !== false) {
        this.post(rawFile);
      } else {
        this.onRemove(rawFile);
      }
    },
    // 正式上传
    post(rawFile) {
      var root = process.env.API_ROOT;
      const vm = this
      const { uid } = rawFile;
      const option = {
        headers: {  // 设置请求头token
          'token':this.$store.state.userInfo.token
        },
        // cookie凭证是否支持发送
        withCredentials: true,
        file: rawFile,
        data: {},
        filename: rawFile.name,
        // 上传的地址
        // action: vm.action,
        action: root+ApiList.fileUpload.url,
        onProgress: e => {
          vm.onProgress(e, rawFile);
        },
        onSuccess: res => {
          if(res.errcode==0){
              this.waitList.push(this.editFile(res.data.list[0]));
          }else{
              this.msg = res.errmsg;
              this.dialog = true;
          }
          vm.onSuccess(this.waitList, rawFile);
          delete vm.reqs[uid];
          this.$store.dispatch('closeLoading',false);
        },
        onError (res) {
          vm.onError(res, rawFile);
          delete vm.reqs[uid];
          this.$store.dispatch('closeLoading',false);
        },
      };
      // 调用后台接口
      const req = ajax(option);
      vm.reqs[uid] = req;
      if (req && req.then) {
        req.then(option.onSuccess, option.onError);
      }
    },
    editFile(waitList){
      // 变更参数名
      waitList = JSON.parse(JSON.stringify(waitList).replace(/filename/g,"wordname"));
      waitList = JSON.parse(JSON.stringify(waitList).replace(/submittedFileName/g,"fileName"));
      waitList = JSON.parse(JSON.stringify(waitList).replace(/size/g,"fileSize"));
      waitList = JSON.parse(JSON.stringify(waitList).replace(/mime/g,"fileType"));
      waitList = JSON.parse(JSON.stringify(waitList).replace(/url/g,"fileUrl"));
      return waitList;
    }
  }
}
</script>

<style lang="less" scoped>
.hy-upload{
  padding: 10px 10px 10px 2rem;
  text-align: left;
}
.hy-upload::after{
  content: '';
  display: block;
  clear: both;
}
.upload-name{
  font-size:1rem;
}
.upload-icon{
  width: 50px;
  height: 50px;
  margin-top:20px;
  overflow: hidden;
  // border: 1px solid rgba(100,100,100,0.5);
  background: url(../../assets/addImg.png) no-repeat;
  background-size: 100% 100%;
  position: relative;
}
.upload-input{
  opacity: 0;
}
.pic-list{
    min-height: 60px;
    height: auto;
    overflow: hidden;
    margin: 1rem 0;
}
.wait-pic{
  height: 60px;
  width: 60px;
  margin: 0.5rem;
  float: left;
  background-size: contain;
  background-position: center;
  background-repeat: no-repeat;
  position: relative;
  a{
    position: absolute;
    top: -0.3rem;
    right: -0.8rem;
    padding: 5px;
    img{
      width:15px;
      height:15px;
    }
  }
}
</style>
