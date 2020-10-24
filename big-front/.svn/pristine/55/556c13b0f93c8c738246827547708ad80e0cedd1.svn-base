<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>数据概览</BreadcrumbItem>
      </Breadcrumb>
      <Card>
        <div class="card-container">
          <div class="card-list" v-for="">
            <Card>
              <div class="card-content">
                <p>接口总数量：{{interface_all}}个</p>
                <p>设置阀值接口数量：{{set_num}}个</p>
              </div>
            </Card>
          </div>
          <div class="card-list">
            <Card>
              <div class="card-content">
                <p>数据应备份数量：{{all_num}}次</p>
                <p>昨天数据实际备份数量：{{yesterday_num}}次</p>
              </div>
            </Card>
          </div>
          <div class="card-list">
            <Card>
              <div class="card-content">
                <p>发生异常进程总数量：{{all_process}}次</p>
                <p>本月异常进程数量：{{month_process}}次</p>
              </div>
            </Card>
          </div>
          <div class="card-list">
            <Card>
              <div class="card-content">
                <p>发生异常服务总次数：{{all_server}}次</p>
                <p>本月异常服务次数：{{month_server}}次</p>
              </div>
            </Card>
          </div>
        </div>
        <Row type="flex" justify="space-between">
          <Col style="width: 49%">
            <chart-card title="接口调用数量top10">
              <barChart ref="bugDeal">
                <div id="bugDeal" style="height: 500px;"></div>
              </barChart>
            </chart-card>
          </Col>
          <Col style="width: 49%">
            <chart-card title="最近一周异常进程&服务趋势">
              <lineChart ref="serviceNum">
                <div id="serviceNum" style="height: 500px;"></div>
              </lineChart>
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
import api from '@/api/axiosApi'
import apiList from '@/api/securityApiList'
export default {
  components:{
    chartCard,
    lineChart,
    barChart
  },
  data() {
    return {
      interface_all: 0,
      set_num: 0,
      all_num: 0,//备份数
      yesterday_num: 0,
      all_process:0,//异常进程数
      month_process:0,
      all_server: 0,
      month_server: 0
    }
  },
  mounted () {
    this.init();
    this.drawServiceNum()
    window.onresize = () => {
      return (() => {
        let bugDealChart = this.$echarts.init(document.getElementById('bugDeal'));
        bugDealChart.resize();
        var serviceNumChart = this.$echarts.init(document.getElementById('serviceNum'));
        serviceNumChart.resize();
      })()
    }
  },
  methods: {
    init() {
      this.getStatInterfaceConfig();
      this.getStatAllBackupsAndYesterday();
      this.getStatExceptionProcess();
      this.getStatExceptionServer();
      this.statInterfaceExecuteTop10();
      this.statExceptionProcessIn7days();
    },
    getStatInterfaceConfig() {//统计接口总数量和配置接口数量
      api(apiList.statInterfaceConfig).then((res) => {
        if(res.status == 200) {
          this.interface_all = res.data.data.all_num;
          this.set_num = res.data.data.set_num;
        }
      }, (err) => {})
    },
    getStatAllBackupsAndYesterday() {//统计数据应备份数量和昨天数据备份数量
      api(apiList.statAllBackupsAndYesterday).then((res) => {
        if(res.status == 200) {
          this.all_num = res.data.data.all_num;
          this.yesterday_num = res.data.data.yesterday_num;
        }
      }, (err) => {})
    },
    getStatExceptionProcess() {//统计总异常进程数量和本月异常进程数量
      api(apiList.statExceptionProcess).then((res) => {
        if(res.status == 200) {
          this.all_process = res.data.data.all_process;
          this.month_process = res.data.data.month_process;
        }
      }, (err) => {})
    },
    getStatExceptionServer() {//统计总异常服务数量和本月异常服务数量
      api(apiList.statExceptionServer).then((res) => {
        if(res.status == 200) {
          this.all_server = res.data.data.all_server;
          this.month_server = res.data.data.month_server;
        }
      }, (err) => {})
    },
    statInterfaceExecuteTop10() {//统计接口调用数量排行前10位
      let name = [], arr = [];
      api(apiList.statInterfaceExecuteTop10).then((res) => {
        if(res.status == 200) {
          res.data.data.forEach(item => {
            name.push(item.api_name);
            arr.push(parseInt(item.num));
          });
          this.drawBugDeal(name,arr);
        }
      }, (err) => {})
    },
    statExceptionProcessIn7days() {//统计最近7天内每天异常进程数量
      let processArr = [];
      api(apiList.statExceptionProcessIn7days).then((res) => {
        if(res.status == 200) {
          res.data.data.forEach(item => {
            processArr.push(parseInt(item.num));
          });
          this.statExceptionServerIn7days(processArr);
        }
      }, (err) => {})
    },
    statExceptionServerIn7days(processArr) {//统计最近7天内每天异常服务数量
      let serverArr = [], date = [];
      api(apiList.statExceptionServerIn7days).then((res) => {
        if(res.status == 200) {
          res.data.data.forEach(item => {
            date.push(item.statDate);
            serverArr.push(parseInt(item.num));
          });
          this.drawServiceNum(date,processArr,serverArr);
        }
      }, (err) => {})
    },
    // 绘制最近一周异常进程&服务趋势
    drawServiceNum (date,processArr,serverArr) {
      const vm = this;
      let maxNum =  (Math.max.apply(null, processArr) > Math.max.apply(null, serverArr)) ? Math.max.apply(null, processArr) : Math.max.apply(null, serverArr);
      const opts = {
        el: 'serviceNum',
        backgroundColor:'#FFFFFF',                      // 背景色
        title: {
            text: '最近一周异常进程&服务趋势',
            x: '50%',
            bottom: '4%',
            textStyle: {
                color: '#000',
                fontSize: '20',
                fontWeight: 'normal'
            }
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                label: {
                    show: true,
                    backgroundColor: '#333'
                }
            },
            formatter: '{a0}: {c0}<br />{a1}: {c1}'
        },
        legend: {
            data: ['异常进程','异常服务'],
            textStyle: {
                color: '#ccc'
            }
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,  
            splitLine: {            
                show: false
            },
            data: date
        },
        yAxis: {
            type: 'value',
            name: '次数',
            min: 0,
            max: Math.ceil(maxNum*1.2),
            minInterval: 1,
            splitLine: {              
              show: false
            }
        },
        series: [
            {
                name:'异常进程',
                type:'line',
                data:processArr,
                itemStyle:{
                    normal:{
                        color:'#42588b'
                    }
                },
            },
            {
                name:'异常服务',
                type:'line',
                data:serverArr,
                itemStyle:{
                    normal:{
                        color:'#a62727'
                    }
                },
              
            }
        ]
      }
      vm.$refs.serviceNum.refresh(opts)
    },
    // 接口调用数量top10
    drawBugDeal (name,arr) {
      console.log(name);
      console.log(arr);
      // arr = arr.sort((a,b)=>{return b-a});
      const vm = this
      const opts = {
        el: 'bugDeal',
        backgroundColor:'#FFFFFF', 
        title: {
            text: '接口调用数量top10',
            x: '50%',
            bottom: '4%',
            textStyle: {
                color: '#000',
                fontSize: '20',
                fontWeight: 'normal'
            }
        },
        xAxis: {
            type: 'value',
            boundaryGap: [0, 0.01],
            min: 0,
            max: Math.max.apply(null, arr) + (Math.max.apply(null, arr)*0.2),
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    fontWeight: '80'
                }
            }
        },
        yAxis: {
            type: 'category',
            data: name,
            inverse:true,
            axisLabel: {
                show:true,
                interval: 0, //强制所有标签显示
                textStyle: {
                    fontWeight: '50',
                    fontSize:16
                },
                formatter: function (params){   //标签输出形式 ---请开始你的表演
                    var index = 10;
                    var newstr = '';
                    for(var i=0;i<params.length;i+=index){
                        var tmp=params.substring(i, i+index);
                        newstr+=tmp+'\n';
                    }
                    return (newstr.length > 8 ? (newstr.slice(0,8)+"...") : newstr ); 
                },
            },
            triggerEvent: true,
        },
        series: [{
            type: 'bar',
            label: {
                normal: {
                    show: true,
                    // formatter: '{c}',
                    formatter: function(v) {
                        var val = v.data;
                        if (val == 0) {
                            return '';
                        }
                        return val;
                    },
                    color: '#fff'
                }
            },
            barWidth : 20,
            itemStyle:{
                normal:{//柱子颜色
                    color:'#4F81BD'
                }
            },
            data: arr
        }]
      }
      vm.$refs.bugDeal.refresh(opts)
    }
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
    width: 22%;
    margin-left: 4%;
    text-align: center;
    &:nth-child(1){
      margin-left: 0;
    }
    .card-content{
      display: inline-block;
      text-align: left;
      font-size: 14px;
      height: 42px;
    }
  }
}
</style>
