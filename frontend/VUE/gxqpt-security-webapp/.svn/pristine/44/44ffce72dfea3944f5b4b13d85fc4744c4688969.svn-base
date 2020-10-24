<!-- 网络资源面板 -->
<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>网络资源面板</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <div class="card-container">
          <div class="card-list">
            <Card style="height:160px;background: #fff;color:#495060;">
              <div class="card-content" style="width:100%;">
                <p style="line-height: 42px;"><span style="color:#0099CC">网络带宽：</span>{{network }}MB</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>本月新增：</span>{{curMonAdd}}MB</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>新增占比：</span>{{addPercent}}</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>新增环比：</span>{{ciraddPercent}}</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>净增：</span>{{jadd}}MB</p>
              </div> 
              <div class="card-content">
                <p style="line-height: 42px;"><span>本月回收：</span>{{curMonSub}}MB</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>回收占比：</span>{{subPercent}}</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>回收环比：</span>{{revertPercent}}</p>
              </div>
              <div class="card-content">
                <p style="line-height: 42px;"><span>净增占比：</span>{{jaddPercent}}</p>
              </div>
            </Card>
          </div>
        </div>
        <Row type="flex" justify="space-between">
          <Col style="width: 49%">
            <chart-card title="各部门网络带宽总量统计">
              <barChart ref="serviceNum">
                <div id="serviceNum" style="height: 540px;"></div>
              </barChart>
            </chart-card>
          </Col>
          <Col style="width: 49%">
            <chart-card title="各部门网络带宽占比统计">
              <chartLine ref="databaseType" el="databaseType" :lineOption="databaseType">
                <div id="databaseType" style="height: 500px;"></div>
              </chartLine>
            </chart-card>
          </Col>
          <Col style="width: 100%">
            <chart-card title="前12个月网络带宽总量统计">
              <chartLine ref="databaseCount" el="databaseCount" :lineOption="databaseCount">
                <div id="databaseCount" style="height: 400px;"></div>
              </chartLine>
            </chart-card>
          </Col>
        </Row>
      </Card>
    </Content>
  </Layout>
</template>

<script>
// echart图外层容器，包括卡片样式
import chartCard from '@/view/home/chartCard.vue'
import lineChart from '@/view/home/lineChart.vue'
import barChart from '@/view/home/barChart.vue'
import chartLine from './common/ChartLine.vue'
import api from '@/api/axiosApi'
import softhardApiList from '@/api/softhardApiList'
import {dataPie,multipleLine} from '@/assets/js/echartOption'
export default {
  components:{
    chartCard,
    lineChart,
    barChart,
    chartLine
  },
  data() {
    return {
      network :0,//数据库数量
      curMonAdd: 0,//新增
      curMonSub: 0,//回收
      addPercent: 0,//新增占比
      subPercent:0,//回收占比
      ciraddPercent: 0,//新增环比
      revertPercent:0,//回收环比
      jadd: 0,//净增
      jaddPercent: 0,//净增占比
      databaseType: dataPie(),
      databaseCount: multipleLine(),
    }
  },
  mounted () {
    this.init();
  },
  methods: {
    init(){//初始化
      this.getThisMonthStatistics();
      this.getEachOrgNetWorkBandwidthYearStatistics();
      this.getEachOrgNetWorkBandwidthMonthStatistics();
    },
    getThisMonthStatistics() {//查询网络带宽面板cpu增比等情况
      api(softhardApiList.getThisMonthStatistics).then((res) => {
        if(res.status == 200 && res.data.data) {
          let data = res.data.data;
          this.network = data.network ;
          this.curMonAdd = data.curMonAdd;
          this.curMonSub = data.curMonSub;
          this.addPercent = data.addPercent;
          this.subPercent = data.subPercent;
          this.ciraddPercent  = data.ciraddPercent;
          this.revertPercent  = data.revertPercent;
          this.jadd  = data.jadd;
          this.jaddPercent  = data.jaddPercent;
        }
      }, (err) => {})
    },
    getEachOrgNetWorkBandwidthMonthStatistics() {//查询各单位网络带宽面板cpu等情况
      let dataVal=[],arr=[],name = [];
      api(softhardApiList.getEachOrgNetWorkBandwidthMonthStatistics).then((res) => {
        if(res.status == 200 && res.data.data) {
          res.data.data.nameList.forEach((item,index) => {
            // name.push(item.orgname);
            // arr.push(parseInt(item.cpuCount));
            dataVal.push({value:res.data.data.numList[index],name:item});
          });
          this.drawServiceNum(res.data.data.nameList,res.data.data.numList)
          this.getDatabaseType(res.data.data.nameList,dataVal)
        }
      }, (err) => {})
    },
    getEachOrgNetWorkBandwidthYearStatistics() {//网络带宽面板 各部门网络带宽统计(近一年)
      let name =[],arr=[];
      api(softhardApiList.getEachOrgNetWorkBandwidthYearStatistics).then((res) => {
        if(res.status == 200 && res.data.data) {
          res.data.data.numList.forEach(item => {
            item.type = 'line';
            item.data = item.value;
          });
          this.getDatabaseCount(res.data.data.nameList,res.data.data.monthsList,res.data.data.numList);
          // this.drawServiceNum(name,arr)
        }
      }, (err) => {})
    },
    drawServiceNum (name,arr) {
      const vm = this
      const opts = {
        el: 'serviceNum',
        legend: {
          left: 'center',
          bottom: 10,
          textStyle: {
            fontSize: '16px'
          },
          data: name
        },
        xAxis: {
          data: name,
          axisLabel: {
            interval:0,
            rotate:40
          }
        },
        yAxis: {
          name: 'MB',
          min: 0,
          max: Math.max.apply(null, arr) + (Math.max.apply(null, arr)*0.2),
        },
        series: [{
          name: '网络带宽总量',
          data: arr,
          barWidth : (arr.length > 12) ? 20 : 40,
          itemStyle:{
              normal:{//柱子颜色
                  color:'#4F81BD'
              }
          },
        }]
      }
      vm.$refs.serviceNum.refresh(opts)
    },
    getDatabaseType (legendName,dataVal) {
      this.databaseType.legend.data = legendName;
      this.databaseType.series[0].data = dataVal;
      this.databaseType.title.text = '各部门网络带宽占比统计';
      this.$refs.databaseType.refresh()
    },
    getDatabaseCount (legendName,timeData,dataVal) {
      this.databaseCount.legend.data = legendName;
      this.databaseCount.xAxis.data = timeData;
      this.databaseCount.series = dataVal;
      // this.databaseCount.title.text = '各部门近12个月网络带宽总量统计';
      this.$refs.databaseCount.refresh()
    },
  }
}
</script>

<style lang="less" scoped>
.card-container{
  &:after{
    content: '';
    clear: both;
    display: block;
  }
  .card-list{
    float: left;
    width: 100%;
    margin-left: 4%;
    text-align: center;
    &:nth-child(1){
      margin-left: 0;
    }
    .card-content{
      width:25%;
      float:left;
      display: inline-block;
      text-align: center;
      font-size: 18px;
      font-weight: bold;
      height: 42px;
    }
  }
}
</style>
