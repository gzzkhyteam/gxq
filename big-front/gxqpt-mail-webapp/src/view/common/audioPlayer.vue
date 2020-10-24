<template>
  <Modal
    :mask-closable="false"
    v-model="showModal"
    :title="audioName"
    width="500">
    <div class="main">
      <audio class="audioWid" controlsList="nodownload" v-if="audioSrc" controls>
        <source :src="audioSrc" type="audio/ogg">
        <source :src="audioSrc" type="audio/mpeg">
                您的浏览器不支持,请升级或更换浏览器。
      </audio>
    </div>
    <div slot="footer">
      <Button class="modalBtn" type="default" @click="cancel" size="large">取消</Button>
    </div>
  </Modal>
</template>

<script>

export default {
  data () {
    const vm = this
    return {
      audioName: '',
      audioSrc: '',
      showModal: false,
    }
  },
  methods: {
    open (fileName, src) {
      const vm = this
      vm.audioName = fileName
      vm.audioSrc = src
      vm.showModal = true
    },
    // 关闭弹窗方法
    cancel () {
      const vm = this
      vm.showModal = false
    }
  }
}
</script>

<style lang="less" scoped>
.audioWid{
  width: 100%;
}
</style>
