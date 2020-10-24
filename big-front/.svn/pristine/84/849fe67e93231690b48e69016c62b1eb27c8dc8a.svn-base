<!-- 单位预警状态柱状图对比分析 -->
<template>
  <div id="unitWarnState"></div>
</template>

<script>
export default {
  data () {
    return {
      unitWarnState: ''
    }
  },
  methods: {
    initUnitWarnState () {
      // 基于准备好的dom，初始化echarts实例
      if (!this.unitWarnState) {
        this.unitWarnState = this.$echarts.init(document.getElementById('unitWarnState'))
      }
      const option = {
        backgroundColor: '#00265f',
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
            data: this.echartData.names,
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
            name: '接入率',
            type: 'bar',
            data: [20, 50, 80, 58, 83, 68, 57, 80, 42, 66],
            barWidth: 10, //柱子宽度
            barGap: 1, //柱子之间间距
            itemStyle: {
                normal: {
                    color: this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#008cff'
                    }, {
                        offset: 1,
                        color: '#005193'
                    }]),
                    opacity: 1,
                }
            }
        }, {
            name: '在线率',
            type: 'bar',
            data: [50, 70, 60, 61, 75, 87, 60, 62, 86, 46],
            barWidth: 10,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#00da9c'
                    }, {
                        offset: 1,
                        color: '#007a55'
                    }]),
                    opacity: 1,
                }
            }
        }, {
            name: '完好率',
            type: 'bar',
            data: [70, 48, 73, 68, 53, 47, 50, 72, 96, 86],
            barWidth: 10,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                        offset: 0,
                        color: '#c4e300'
                    }, {
                        offset: 1,
                        color: '#728400'
                    }]),
                    opacity: 1,
                }
            }
        }]
      };
      // 使用刚指定的配置项和数据显示图表。
      unitWarnState.setOption(option);
    },
    refresh () {
      this.initUnitWarnState()
    }
  }
}
</script>

<style lang="less" scoped>
#unitWarnState{
  width: 100%;
  height: 300px;
}
</style>
