<!-- 各应用预警级别情况 -->
<template>
  <div id="appLevel"></div>
</template>

<script>
export default {
  data(){
    return{
      legendmap:{'1':'特别重大(Ⅰ级)','2':'重大(Ⅱ级)','3':'较大(Ⅲ级)','4':'一般(Ⅳ级)'},
      // legendData:[{name: '特别重大(Ⅰ级)'}, {name: '重大(Ⅱ级)'},{name: '较大(Ⅲ级)'},{name: '一般(Ⅳ级)'}],
      legendData:['特别重大(Ⅰ级)', '重大(Ⅱ级)', '较大(Ⅲ级)', '一般(Ⅳ级)'],
      yAxisData:[],
      seriesData:[],
      appLevel: '',
      echartData: []
    }
  },
  methods: {
    initAppLevel () {
      // 基于准备好的dom，初始化echarts实例
      if (!this.appLevel) {
        this.appLevel = this.$echarts.init(document.getElementById('appLevel'))
      }
      const option = {
        backgroundColor: '#fff',
        tooltip : {
          trigger: 'axis',
          axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
          },
          // formatter: "{b} <br> {a0}:{c0} <br> {a1}:{c1} <br> {a2}:{c2} <br> {a3}:{c3}"
        },
        legend: {
          data: this.legendData
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        color:['#EF0202','#EF8D02','#EFCB02','#0299EF'],//在这里设置colorList，是一个数组，图片颜色会按顺序选取
        xAxis:  {
          type: 'value'
        },
        yAxis: {
          type: 'category',
          data: this.yAxisData
        },
        series: this.seriesData
      }
      // 使用刚指定的配置项和数据显示图表。
      this.appLevel.setOption(option);
    },
    count(){
      let arr = [];
      for(let i of this.legendData){
        this.seriesData.push({
          name: i,
          type: 'bar',
          stack: '总量',
          label: {
            normal: {
              show: false,
              position: 'insideRight'
            }
          },
          barWidth: '15',
          data:[]
        })
      }

      for(var i = 0; i < this.echartData.length; i++){
        this.yAxisData.push(this.echartData[i].name || '');
        for(var j in this.legendmap){
          (this.echartData[i].count[j]) ? this.seriesData[4-j].data.push(this.echartData[i].count[j]) : this.seriesData[4-j].data.push(0);
        }
      }
    },
    refresh (data) {
      Object.assign(this.$data, this.$options.data())
      this.echartData = data
      this.count()
      this.initAppLevel()
    }
  }
}
</script>

<style lang="less" scoped>
#appLevel{
  width: 100%;
  height: 300px;
}
</style>
