<!-- 应用预警状态柱状图对比分析 -->
<template>
  <div id="bar3D"></div>
</template>

<script>
export default {
  data () {
    return {
      bar3D: '',
      echartData: {}
    }
  },
  methods: {
    initbar3D () {
      const echartData = this.echartData
      // 基于准备好的dom，初始化echarts实例
      if (!this.bar3D) {
        this.bar3D = this.$echarts.init(document.getElementById('bar3D'))
      }
      const barWidth = 20
      const option = {
        backgroundColor: '#fff',
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'shadow'
          }
        },
        legend: {
          data: ['一般预警', '较重预警', '严重预警', '特严预警'],
          align: 'right',
          right: 10,
          textStyle: {
            color: "#333"
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
            data: this.echartData.xzData,
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
            name: '一般预警',
            type: 'bar',
            stack: '预警级别',
            data: this.echartData.yzLevelOneData,
            barWidth: barWidth,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: '#61a0a8'
                }
            }
        }, {
            name: '较重预警',
            type: 'bar',
            stack: '预警级别',
            data: this.echartData.yzLevelTwoData,
            barWidth: barWidth,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: '#2f4554'
                }
            }
        }, {
            name: '严重预警',
            type: 'bar',
            stack: '预警级别',
            data: this.echartData.yzLevelThreeData,
            barWidth: barWidth, //柱子宽度
            barGap: 1, //柱子之间间距
            itemStyle: {
                normal: {
                    color: '#d48265'
                }
            }
        }, {
            name: '特严预警',
            type: 'bar',
            stack: '预警级别',
            data: this.echartData.yzLevelFourData,
            barWidth: barWidth, //柱子宽度
            barGap: 1, //柱子之间间距
            itemStyle: {
                normal: {
                    color: '#ff0000'
                }
            }
        }]
      };
      if (this.echartData.yzTotalNumData){
        option.legend.data = []
        option.series = [{
            name: '预警数量',
            type: 'bar',
            data: this.echartData.yzTotalNumData,
            barWidth: barWidth,
            barGap: 1,
            itemStyle: {
                normal: {
                    color: '#61a0a8'
                }
            }
        }]
      }
      // 使用刚指定的配置项和数据显示图表。
      this.bar3D.setOption(option);
    },
    refresh (data) {
      this.echartData = data
      this.initbar3D()
    }
  }
}
</script>

<style lang="less" scoped>
#bar3D{
  width: 100%;
  height: 300px;
  // overflow: auto;
}
</style>
