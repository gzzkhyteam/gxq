<!-- 仪表盘 -->
<template>
  <div>
    <slot></slot>
  </div>
</template>

<script>
export default {
  props: {
    gaugeOption: {
      type: Object,
      default: () => {
        return {}
      }
    },
    el: {
      type: String,
      required: true
    },
    title: {
      type: String,
      default: ''
    }
  },
  methods: {
    refresh () {
      const vm = this
      const option = {
        tooltip : {
          formatter: ""
        },
        title:{
          text: vm.title,
          bottom: '0',
          left: 'center'
        },
        series: [],
        ...vm.gaugeOption
      }
      const gauge = vm.$echarts.init(document.getElementById(vm.el))
      gauge.setOption(option)
    }
  }
}
</script>
