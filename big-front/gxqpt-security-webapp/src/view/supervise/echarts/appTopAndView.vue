<!-- 应用预警来源情况 -->
<template>
  <div id="appTop"></div>
</template>

<script>
function handleData(data) {
  return JSON.parse(JSON.stringify(data).replace(/num/g, 'value'))
}
export default {
  data () {
    return {
      appTop: ''
    }
  },
  methods: {
    initAppTop (data) {
      console.log(data);
      // 基于准备好的dom，初始化echarts实例
      if (!this.appTop) {
        this.appTop = this.$echarts.init(document.getElementById('appTop'))
      }
      const option = {
        // backgroundColor: '#131f56',
        tooltip: {
          show: true
        },
        series: [{
          name: '热点分析',
          type: 'wordCloud',
          textPadding: 0,
          autoSize: {
            enable: true,
            minSize: 6
          },
          textStyle: {
            normal: {
              color: function() {
                return 'rgb(' + [
                  Math.round(Math.random() * 105) + 150,
                  Math.round(Math.random() * 105) + 150,
                  Math.round(Math.random() * 105) + 150
                ].join(',') + ')';
              }
            },
            emphasis: {
              shadowBlur: 10,
              shadowColor: '#333'
            }
          },
          data: data
        }]
      }
      // 使用刚指定的配置项和数据显示图表。
      this.appTop.setOption(option);
    },
    refresh (data) {
      this.initAppTop(handleData(data))
    }
  }
}
</script>

<style lang="less" scoped>
#appTop{
  width: 100%;
  height: 300px;
}
</style>
