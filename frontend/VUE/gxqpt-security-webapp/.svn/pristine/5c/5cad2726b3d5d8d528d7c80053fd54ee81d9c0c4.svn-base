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
      const option = {
        color: '#4F81BD',
        title: {
          bottom: 20,
          left: 'center',
          textStyle: {
            color: '#28A4D7'
          },
          ...(opts.title || {})
        },
        tooltip: {
          show: false
        },
        legend: {
          show: false
        },
        tooltip: {
          trigger: 'axis'
        },
        grid: {
          left: '60px',
          right: '60px',
          bottom: '60px',
          containLabel: true
        },
        xAxis: {
          type: 'category',
          axisLine: {
            show: true,
            lineStyle: {
              width: 1,
              type: "solid"
            }
          },
          axisTick: {
            show: false,
          },
          axisLabel: {
            show: true,
            textStyle: {
              color: "#00c7ff",
            }
          },
          ...opts.xAxis
        },
        yAxis: {
          type: 'value',
          ...opts.yAxis
        },
        series: opts.series
        // series: [{
        //     type:'line',
        //     data: attence[type]
        // }]
      }
      const line = vm.$echarts.init(document.getElementById(opts.el))
      line.setOption(option)
    }
  }
}
</script>
