<!-- 人员预警处理对比分析图 -->
<template>
  <div id="unitManage"></div>
</template>

<script>
export default {
  data () {
    return {
      echartData: [],
      lineBar: ''
      // yAxisMax1:'',
      // yAxisMax2:''
    }
  },
  methods: {
    initLineBar () {
      // 基于准备好的dom，初始化echarts实例
      if (!this.lineBar) {
        this.lineBar = this.$echarts.init(document.getElementById('unitManage'))
      }
      const option = {
        backgroundColor: '#fff',
        color: ['#F19A9A', '#00A0E9'],
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
            data: this.echartData.names,
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
            axisLabel : {
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
              rotate:40,
              textStyle: {
                color: "#000",
              }
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '预警确认平均时长',
            min: 0,
            axisLabel: {
              formatter: '{value} h',
              textStyle: {
                  color: "#000",
              }
            },
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
            }
          },
          {
            type: 'value',
            name: '预警处理平均时长',
            min: 0,
            axisLabel: {
              formatter: '{value} h',
              textStyle: {
                  color: "#000",
              }
            },
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
            }
          }
        ],
        series: [
          {
            name:'预警确认平均时长',
            type:'bar',
            data:this.echartData.confirmedArr
          },
          {
            name:'预警处理平均时长',
            type:'line',
            yAxisIndex: 1,
            data:this.echartData.processedArr
          }
        ]
      }
      // 使用刚指定的配置项和数据显示图表。
      this.lineBar.setOption(option);
    },
    refresh (data) {
      this.echartData = data;
      this.echartData.confirmedArr = [];
      this.echartData.processedArr = [];
      this.echartData.confirmedHours.forEach(item=>{
        item = item.toFixed(2);
        this.echartData.confirmedArr.push(item);
      })
      this.echartData.processedHours.forEach(item=>{
        item = item.toFixed(2);
        this.echartData.processedArr.push(item);
      })
      this.initLineBar()
    }
  }
}
</script>

<style lang="less" scoped>
#unitManage{
  width: 100%;
  height: 300px;
}
</style>
