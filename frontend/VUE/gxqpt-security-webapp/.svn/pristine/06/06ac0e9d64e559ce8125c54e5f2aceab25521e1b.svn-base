<!-- 部门预警处理对比分析图 -->
<template>
  <div id="personnelManage"></div>
</template>

<script>
export default {
  data () {
    return {
      lineBar: ''
    }
  },
  methods: {
    initLineBar () {
      // 基于准备好的dom，初始化echarts实例
      if (!this.lineBar) {
        this.lineBar = this.$echarts.init(document.getElementById('personnelManage'))
      }
      const option = {
        backgroundColor: '#fff',
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        legend: {
          data:['预警确认平均时长', '预警处理平均时长']
        },
        xAxis: [
          {
            type: 'category',
            data: ['人员1','人员2','人员3','人员4','人员5','人员6','人员7','人员8','人员9','1人员0','人员11','人员12'],
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '预警确认平均时长',
            min: 0,
            max: 250,
            interval: 50,
            axisLabel: {
              formatter: '{value} h'
            }
          },
          {
            type: 'value',
            name: '预警处理平均时长',
            min: 0,
            max: 25,
            interval: 5,
            axisLabel: {
              formatter: '{value} h'
            }
          }
        ],
        series: [
          {
            name:'蒸发量',
            type:'bar',
            data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
          },
          {
            name:'平均温度',
            type:'line',
            yAxisIndex: 1,
            data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
          }
        ]
      }
      // 使用刚指定的配置项和数据显示图表。
      lineBar.setOption(option);
    },
    refresh () {
      this.initLineBar()
    }
  }
}
</script>

<style lang="less" scoped>
#personnelManage{
  width: 100%;
  height: 300px;
}
</style>
