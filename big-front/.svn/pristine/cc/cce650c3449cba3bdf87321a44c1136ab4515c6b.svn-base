<!-- 线图 -->
<template>
  <div>
    <slot></slot>
  </div>
</template>
<script>
export default {
  methods: {
    refresh (opts) {
      const vm = this
      const bar = vm.$echarts.init(document.getElementById(opts.el))
      bar.setOption(opts)
    }
  }
}
</script>
