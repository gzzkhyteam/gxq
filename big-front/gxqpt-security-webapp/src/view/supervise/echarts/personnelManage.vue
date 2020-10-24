<!-- 人员预警处理对比分析图 -->
<template>
  <div id="personnelManage"></div>
</template>

<script>
export default {
  data () {
    return {
      echartData: [],
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
        color: ['#F19A9A', '#00A0E9'],
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          },
          formatter: function (params) { // 格式化显示内容，数值保留2位小数
            var text = ''
            for (var i = 0; i < params.length; i++) {
              text += params[i].seriesName + ':' + params[i].data.toFixed(2) + '<br />'
            }
            return text 
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
              rotate:40
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '预警确认平均时长',
            min: 0,
            // max: 5,
            // interval: 0.5,
            axisLabel: {
              formatter: '{value} h',
              color: '#000'
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
            // max: 5,
            // interval: 0.5,
            axisLabel: {
              formatter: '{value} h',
              color: '#000'
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
            data:this.echartData.confirmedHours
          },
          {
            name:'预警处理平均时长',
            type:'line',
            yAxisIndex: 1,
            data:this.echartData.processedHours
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
#personnelManage{
  width: 100%;
  height: 300px;
}
</style>
