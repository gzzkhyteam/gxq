<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>运维分析</BreadcrumbItem>
        <BreadcrumbItem>应用流量监控</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <Row type="flex" justify="space-between">
          <Col style="width: 49%">
            <chart-card title="Top5接口流量">
              <Table
                border
                :columns="tableList1.columns"
                :data="tableList1.data"></Table>
            </chart-card>
          </Col>
          <Col style="width: 49%">
            <chart-card title="Top5接口利用率">
              <Table
                border
                :columns="tableList2.columns"
                :data="tableList2.data"></Table>
            </chart-card>
          </Col>
        </Row>
        <Row>
          <Col span="24">
            <chart-card title="Top5接口流量">
              <Row style="margin-top: 15px;">
                <Col span="24">
                  <RadioGroup v-model="type">
                    <Radio label="1">
                      <span>近1小时</span>
                    </Radio>
                    <Radio label="2">
                      <span>近12小时</span>
                    </Radio>
                    <Radio label="3">
                      <span>近24小时</span>
                    </Radio>
                    <Radio label="4">
                      <span>近7天</span>
                    </Radio>
                    <Radio label="5">
                      <span>近1个月</span>
                    </Radio>
                    <Radio label="6">
                      <span>近1年</span>
                    </Radio>
                  </RadioGroup>
                </Col>
              </Row>
              <chartLine ref="appflowChart1" el="appflowChart1" :lineOption="appflowChart1Option">
                <div id="appflowChart1" style="height: 400px;"></div>
              </chartLine>
              <Table
                border
                :columns="tableList1.columns"
                :data="tableList1.data"></Table>
            </chart-card>
          </Col>
        </Row>
      </Card>
    </Content>
  </Layout>
</template>

<script>
import {mapState} from 'vuex'
import api from '@/api/axiosApi'
import operationApiList from '@/api/operationApiList'
// echart图外层容器，包括卡片样式
import chartCard from '@/view/home/chartCard.vue'
import chartLine from './../echarts/ChartLine.vue'
import {areaLine} from '@/assets/js/echartOption'
// 数据
import analyzeAppflowData from './analyzeAppflowData'

function getData(type) {
  const date = Date.now()
  const xData = []
  let yData = []
  switch(type) {
    // 近一小时
    case '1':
      for (let i = 12; i > 0; i--) {
        xData.push(date - i * 5 * 60 * 1000)
      }
      yData = [
        [89, 93, 64, 125, 145, 62, 263, 456, 56, 45, 69, 98],
        [145, 62, 164, 75, 56, 256, 69, 78, 94, 186, 86, 25],
        [98, 339, 59, 123, 256, 164, 125, 145, 62, 164, 76, 54],
        [75, 98, 145, 62, 164, 75, 56, 45, 245, 256, 164, 76],
        [145, 654, 164, 339, 135, 245, 456, 263, 456, 256, 164, 76]
      ]
      break
    // 近12小时
    case '2':
      for (let i = 12; i > 0; i--) {
        xData.push(date - i * 60 * 60 * 1000)
      }
      yData = [
        [2.52, 1.23, 2.15, 1.98, 2.65, 4.16, 3.26, 1.65, 2.12, 3.24, 1.35, 1.52],
        [3.21, 2.15, 1.98, 2.65, 4.16, 3.26, 2.15, 1.98, 2.15, 2.15, 1.98, 1.26],
        [1.23, 2.65, 4.16, 3.26, 1.25, 2.22, 4.23, 2.15, 1.98, 2.13, 3.12, 1.62],
        [2.31, 4.23, 2.15, 1.98, 4.23, 2.15, 1.98, 2.15, 1.98, 2.65, 4.16, 1.42],
        [4.12, 4.23, 2.15, 1.98, 5.14, 4.16, 3.26, 1.25, 4.21, 2.95, 3.2, 3.27]
      ]
      break
    // 近24小时
    case '3':
      for (let i = 12; i > 0; i--) {
        xData.push(date - i * 120 * 60 * 1000)
      }
      yData = [
        [6.32, 8.23, 6.38, 4.63, 9.3, 4.13, 3.75, 4.13, 6.81, 4.91, 5.36, 2.87],
        [3.47, 5.21, 4.13, 3.25, 4.63, 7.42, 5.36, 4.63, 7.42, 4.13, 4.3, 3.24],
        [5.1, 4.36, 5.23, 4.22, 7.42, 4.13, 3.88, 7.42, 3.47, 6.38, 4.11, 4.74],
        [5.23, 7.26, 5.1, 5.23, 7.42, 4.78, 6.54, 4.13, 6.38, 4.13, 4.63, 5.58],
        [4.63, 5.36, 4.63, 7.42, 4.65, 6.54, 8.35, 4.13, 9.3, 4.51, 7.16, 6.47]
      ]
      break
    // 近7天
    case '4':
      for (let i = 7; i > 0; i--) {
        xData.push(date - i * 24 * 60 * 60 * 1000)
      }
      yData = [
        [69, 29, 48, 59, 64, 109, 66.82],
        [87, 86, 84, 52, 36, 46, 57.19],
        [76, 62, 35, 46, 98, 52, 60.46],
        [110, 24, 65, 78, 95, 65, 66.41],
        [54, 87, 59, 32, 56, 48, 73.15]
      ]
      break
    // 近一个月
    case '5':
      for (let i = 30; i > 0; i--) {
        xData.push(date - i * 24 * 60 * 60 * 1000)
      }
      yData =[
        [35, 68, 47, 58, 32, 56, 48, 98, 59, 64, 109, 98, 76, 85, 43, 58, 86, 88, 125, 53, 69, 29, 48, 59, 64, 109, 67, 89, 159, 86],
        [89, 76, 62, 35, 46, 98, 86, 46, 56, 26, 45, 85, 96, 54, 87, 86, 56, 78, 95, 62, 87, 86, 84, 52, 36, 46, 57, 89, 169, 96],
        [75, 112, 85, 43, 58, 86, 88, 95, 76, 45, 35, 59, 64, 109, 98, 86, 46, 25, 64, 98, 76, 62, 35, 46, 98, 52, 60],
        [45, 85, 96, 54, 87, 97, 59, 64, 109, 98, 98, 130, 112, 95, 65, 84, 76, 98, 95, 64, 110, 24, 65, 78, 95, 65, 66],
        [56, 26, 45, 85, 96, 54, 87, 85, 43, 58, 86, 88, 75, 32, 56, 48, 98, 75, 56, 26, 54, 87, 59, 32, 56, 48, 73],
      ]
      break
    // 近1年
    case '6':
      for (let i = 12; i > 0; i--) {
        xData.push(date - i * 30 * 24 * 60 * 60 * 1000)
      }
      yData = [
        [2.15, 1.98, 2.12, 3.24, 1.35, 1.65, 2.65, 4.16, 3.26, 2.12, 2.52, 1.78],
        [1.98, 2.65, 2.15, 2.15, 1.98, 1.98, 4.16, 3.26, 2.15, 3.12, 3.21, 1.76],
        [4.16, 3.26, 1.98, 2.13, 3.12, 2.15, 1.25, 2.22, 4.23, 2.11, 1.23, 1.83],
        [2.15, 1.98, 1.98, 2.65, 4.16, 2.15, 4.23, 2.15, 1.98, 3.26, 2.31, 2.2],
        [2.15, 1.98, 4.21, 2.95, 3.2, 1.25, 5.14, 4.16, 3.26, 1.58, 4.12, 1.64]
      ]
      break
  }
  return {xData, yData}
}

function addZero(value) {
  if (!value) {
    return '00'
  } else {
    return value < 10 ? `0${value}` : value
  }
}

function changeDate(value, type) {
  const date = new Date(Number(value))
  switch(type) {
    // 近一小时
    case '1':
    // 近12小时
    case '2':
    // 近24小时
    case '3':
      return `${addZero(date.getHours())}:${addZero(date.getMinutes())}`
    // 近7天
    case '4':
    // 近一个月
    case '5':
      return `${addZero(date.getMonth() + 1)}-${addZero(date.getDate())}`
    // 近1年
    case '6':
      return `${addZero(date.getFullYear())}-${addZero(date.getMonth() + 1)}`
  }
}

export default {
  components: {
    chartCard,
    chartLine
  },
  data () {
    return {
      appflowChart1Option: {},
      type: '1',
      tableList1: {
        columns: [{
          title: '接口',
          key: 'item1',
          align: 'center',
          width: 280
        }, {
          title: '流入速率',
          key: 'item2',
          align: 'center'
        }, {
          title: '流出速率',
          key: 'item3',
          align: 'center'
        }, {
          title: '流入包速率',
          key: 'item4',
          align: 'center'
        }, {
          title: '流出包速率',
          key: 'item5',
          align: 'center'
        }],
        data: []
      },
      tableList2: {
        columns: [{
          title: '接口',
          key: 'item1',
          align: 'center'
        }, {
          title: '流入利用率',
          key: 'item2',
          align: 'center'
        }, {
          title: '流出利用率',
          key: 'item3',
          align: 'center'
        }],
        data: []
      }
    }
  },
  computed: {
    ...mapState(['userInfo'])
  },
  mounted() {
    this.drawTable()
    this.drawAppflowChart1()
  },
  methods: {
    drawTable () {
      this.tableList1.data = analyzeAppflowData.top5Interface
      this.tableList2.data = analyzeAppflowData.top5InterfaceUse
    },
    drawAppflowChart1 () {
      const type =  this.type
      const num = Math.floor(Math.random() * 600)
      const data = getData(type)
      const option = areaLine()
      option.series = []
      option.tooltip = {
        trigger: 'axis',
        formatter: (params) => {
          const name = changeDate(params[0].name, type)
          return `${name}: ${params[0].value}kb`
        }
      }
      option.xAxis.data = data.xData
      option.xAxis.axisLabel = {
        formatter: (value, idx) => {
          return changeDate(value, type)
        }
      }
      for (var i = 0; i < 5; i++) {
        option.series.push({
          type: 'line',
          smooth: false,
          data: data.yData[i],
          areaStyle: {
            normal: {
              color: 'rgba(0, 0, 0, 0)'
            }
          }
        })
      }
      this.appflowChart1Option = option
      this.$nextTick(() => {
        this.$refs.appflowChart1.refresh()
      })
    }
  },
  watch: {
    type () {
      this.drawAppflowChart1()
    }
  }
}
</script>
