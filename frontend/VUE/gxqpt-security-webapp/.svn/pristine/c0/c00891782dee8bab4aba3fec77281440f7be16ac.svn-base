<!-- 各应用预警类别情况 -->
<template>
  <div id="appCategoryView"></div>
</template>

<script>
function handleData(data, vm) {
  // legend
  const nameList = [vm.$route.query.app, '平均水平']
  // 总类型
  const indicator = []
  // 当前应用
  const seriesData1 = {
    value: [],
    name: nameList[0]
  }
  // 平均水平
  const seriesData2 = {
    value: [],
    name: nameList[1]
  }
  // 总类型
  data.avg.map(item => {
    indicator.push({
      name: item.type
    })
    seriesData2.value.push(item.count)
  })
  // 根据总类型先确定当前应用的长度并且填充0
  seriesData1.value.length = indicator.length
  seriesData1.value.fill(0)
  data.app.map(item => {
    let idx = indicator.indexOf(item.type)
    seriesData1.value[idx] = item.count
  })
  return { nameList, indicator, seriesData1, seriesData2 }
}
export default {
  data () {
    return{
      echartData: {},
      appCategoryView: ''
    }
  },
  methods: {
    initAppCategoryView() {
      if(this.echartData.indicator.length==0){
        this.echartData.indicator = [0,0,0,0,0,0,0,0];
        this.echartData.nameList = ['暂无数据'];
    	};
      const echartData = this.echartData
      // 基于准备好的dom，初始化echarts实例
      if (!this.appCategoryView) {
        this.appCategoryView = this.$echarts.init(document.getElementById('appCategoryView'))
      }
      console.log(echartData);
      const option = {
        title: {
          show: false
        },
        tooltip: {
          show: true,
          position: ['50%', '5%']
        },
        legend: {
          type: 'scroll',
          orient: 'vertical',
          top: '10%',
          right: '10%',
          data: echartData.nameList
        },
        radar: {
          scale: true,
          indicator: echartData.indicator,
          center: ['30%', '50%'],
          radius: '50%'
        },
        series: [{
          type: 'radar',
          zlevel: 2,
          data: [echartData.seriesData1, echartData.seriesData2]
        }]
      }
      // 使用刚指定的配置项和数据显示图表。
      this.appCategoryView.setOption(option)
    },
    refresh (data) {
      Object.assign(this.$data, this.$options.data())
      this.echartData = handleData(data, this)
      this.initAppCategoryView()
    }
  }
}
</script>

<style lang="less" scoped>
#appCategoryView {
  width: 100%;
  height: 300px;
}
</style>