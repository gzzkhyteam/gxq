<!-- 线图 -->
<template>
  <div>
    <slot></slot>
  </div>
</template>

<script>
export default {
  props: {
    radarOption: {
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
        tooltip: {},
        title: {
          text: vm.title
        },
        radar: {
          name: {
            textStyle: {
              color: '#fff',
              backgroundColor: '#999',
              borderRadius: 3,
              padding: [3, 5]
            }
          },
          indicator: []
        },
        series: [],
        ...vm.radarOption
      }
      const line = vm.$echarts.init(document.getElementById(vm.el))
      line.setOption(option)
    }
  }
}
</script>
