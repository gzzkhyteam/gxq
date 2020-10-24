<!-- 各应用预警级别情况 -->
<template>
  <div id="appLevelView"></div>
</template>

<script>
function handleData(data, vm) {
  // legend
  const legend = [vm.$route.query.app, '平均水平']
  // 预警种类
  const typeList = data.level
  const seriesData1 = {
    name: legend[0],
    type: 'bar',
    data: data.num
  }
  // 平均水平
  const seriesData2 = {
    name: legend[1],
    type: 'bar',
    data: data.avg
  }
  return { legend, typeList, seriesData1, seriesData2 }
}
export default {
  methods: {
    initAppLevelView (data) {
      // 基于准备好的dom，初始化echarts实例
      if (!this.appLevelView) {
        this.appLevelView = this.$echarts.init(document.getElementById('appLevelView'))
      }
      const option = {
        color: ['#FFD85C', '#37A2DA'],
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          data: data.legend
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: {
          inverse: true,
          type: 'value',
          boundaryGap: [0, 0.01],
          axisLine: {
              show: true,
              lineStyle: {
                  color: "#A6A6A6",
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
                  color: "#000",
              }
          }
        },
        yAxis: {
          position: 'right',
          type: 'category',
          data: data.typeList,
          axisLine: {
              show: true,
              lineStyle: {
                  color: "#A6A6A6",
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
                  color: "#000",
              }
          }
        },
        series: [ data.seriesData1, data.seriesData2]
      }
      // 使用刚指定的配置项和数据显示图表。
      this.appLevelView.setOption(option);
    },
    refresh (data) {
      this.initAppLevelView(handleData(data, this))
    }
  }
}
</script>

<style lang="less" scoped>
#appLevelView{
  width: 100%;
  height: 300px;
}
</style>
