<!-- 单位预警状态柱状图对比分析 -->
<template>
  <div id="appWarnHistory"></div>
</template>

<script>
function handleData(data) {
  // 已处理数量
  const handled = []
  // 年份、月份
  const month = []
  // 新增数量
  const newCome = []
  // 待处理数量
  const pending = []
  data.map(data => {
    handled.unshift(data.handled)
    month.unshift(data.month)
    newCome.unshift(data.newCome)
    pending.unshift(data.pending)
  })
  return { handled, month, newCome, pending }
}

export default {
  data () {
    return {
      echartData: {},
      appWarnHistory: ''
    }
  },
  methods: {
    initAppWarnHistory () {
      const echartData = this.echartData
      console.log(this.echartData)
      // 基于准备好的dom，初始化echarts实例
      if (!this.appWarnHistory) {
        this.appWarnHistory = this.$echarts.init(document.getElementById('appWarnHistory'))
      }
      const barWidth = 5
      const option = {
        backgroundColor: '#fff',
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          data: ['已处理', '未处理', '新增预警数量'],
          align: 'right',
          right: 10,
          textStyle: {
            color: "#fff"
          },
          itemWidth: 10,
          itemHeight: 10,
          itemGap: 35
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        xAxis: [{
            type: 'category',
            data: this.echartData.month,
            axisLabel : {
                show: true,
                textStyle: {
                    color: "#00c7ff",
                },
                formatter : function (value){
                    let valueTxt = '';
                    if (value.length > 6) {
                    valueTxt = value.substring(0, 4) + '...';
                    }
                    else {
                        valueTxt = value;
                    }
                    return valueTxt ;
                },
                interval:0,
                rotate:40
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: "#A6A6A6",
                    width: 1,
                    type: "solid"
                },
            },
            axisTick: {
                show: false
            }
        }],
        yAxis: [{
            type: 'value',
            axisTick: {
                show: false,
            },
            axisLine: {
                show: true,
                lineStyle: {
                    color: "#A6A6A6",
                    width: 1,
                    type: "solid"
                },
            },
            splitLine: {
                show: false
            }
        }],
        series: [{
            name: '已处理预警',
            type: 'bar',
            data: this.echartData.handled,
            barWidth: barWidth,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: '#9FDFA1'
                }
            }
        }, {
            name: '未处理预警',
            type: 'bar',
            data: this.echartData.pending,
            barWidth: barWidth,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: '#F19A9A'
                }
            }
        }, {
            name: '新增预警',
            type: 'bar',
            data: this.echartData.newCome,
            barWidth: barWidth, //柱子宽度
            barGap: 1, //柱子之间间距
            itemStyle: {
                normal: {
                    color: '#85C8F6'
                }
            }
        }]
      }
      // 使用刚指定的配置项和数据显示图表。
      this.appWarnHistory.setOption(option)
    },
    refresh (data) {
      this.echartData = handleData(data)
      this.initAppWarnHistory()
    }
  }
}
</script>

<style lang="less" scoped>
#appWarnHistory{
  width: 100%;
  height: 300px;
}
</style>
