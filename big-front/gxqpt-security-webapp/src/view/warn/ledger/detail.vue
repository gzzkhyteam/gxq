<template>
  <table class="table table-title-left">
    <tbody>
      <tr>
        <th width="250">应用程序名称</th>
        <td>{{detailContent.appName}}</td>
        <th width="250">预警标题</th>
        <td>{{detailContent.title}}</td>
      </tr>
      <tr>
        <th>业务类型</th>
        <td>{{detailContent.bizType}}</td>
        <th>业务责任名称</th>
        <td>{{detailContent.name}}</td>
      </tr>
      <tr>
        <th>预警类型</th>
        <td>{{detailContent.type}}</td>
        <th>预警时间</th>
        <td>{{detailContent.warntime}}</td>
      </tr>
      <tr>
        <th>预警状态</th>
        <td>{{detailContent.status}}</td>
        <th>预警内容</th>
        <td>{{detailContent.content}}</td>
      </tr>
      <tr>
        <th>预警级别</th>
        <td>{{detailContent.level}}</td>
        <th>预警最近处理时间</th>
        <td>{{detailContent.hanTime}}</td>
      </tr>
      <tr>
        <th width="250px">预警接收人姓名、类型及接收时间</th>
        <td colspan="3" v-html="detailContent.recName"></td>
      </tr>
    </tbody>
    <tbody>
      <tr>
        <th width="250px">确认信息</th>
        <td colspan="3" v-html="conremarks"></td>
      </tr>
      <tr>
        <th width="250px">处理信息</th>
        <td colspan="3" v-html="hanremarks"></td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import {mapState} from 'vuex'
import api from '@/api/axiosApi'
import warnApiList from '@/api/warnApiList'

const allBizTypes = {
  personnel: '人员',
  department: '部门',
  company: '单位',
  application: '应用'
}
const recTypes = ['', '确认人', '抄送人', '责任人']
const allStatus = ['', '未确认', '已确认属实', '已确认不属实', '已处理']
const levels = ['', '一般', '较重', '严重', '特别严重']
export default {
  data () {
    return {
      detailContent: {

      },
      // 确认信息
      conremarks: '',
      // 处理信息
      hanremarks: ''
    }
  },
  methods: {
    refresh (id) {
      const vm = this
      api(warnApiList.warnGetById, { id })
      .then(res => {
        if (res.data.errcode === 0) {
          const {warn, list = [], list1 = []} = res.data.data
          const appNames = []
          const bizTypes = []
          const names = []
          const recNames = []
          list1.map(app => {
            appNames.push(app['app_name'])
            if (app['biz_type']) {
              bizTypes.push(allBizTypes[app['biz_type']])
            }
            if (app['name_']) {
              names.push(app['name_'])
            }
          })
          list.map(rec => {
            if (rec['rec_name'] && rec['rec_type']) {
              recNames.push(`${rec['rec_name']}:${recTypes[rec['rec_type']]};${rec['rec_time']}`)
            }
          })
          vm.detailContent = {
            ...warn,
            appName: appNames.join(','),
            bizType: bizTypes.join(','),
            name: names.join(','),
            recName: recNames.join('<br>'),
            status: allStatus[warn.status] || '--',
            level: levels[warn.level] || '--'
          }
        }
      }, error => {console.log(error)})

      api(warnApiList.getConById, { id })
      .then(res => {
        if (res.data.errcode === 0) {
          const data = res.data.data || []
          const remarks = []
          data.map(r => {
            if (r.remarks) {
              const txt = r.result ? '属实' : '不属实'
              remarks.push(`${r.recName}:确认${txt};输入的信息内容为：${r.remarks}`)
            }
          })
          vm.conremarks = remarks.join('<br>')
        }
      }, error => {console.log(error)})

      api(warnApiList.getHanById, { id })
      .then(res => {
        if (res.data.errcode === 0) {
          const data = res.data.data || []
          const remarks = []
          data.map(r => {
            if (r.remarks) {
              remarks.push(`${r.recName}:输入的处理信息内容为：${r.remarks}`)
            }
          })
          vm.hanremarks = remarks.join('<br>')
        }
      }, error => {console.log(error)})
    }
  }
}
</script>

<style lang="less" scoped>
/*
 * 表格样式 start
 * 说明
 * .table-title-top 标题在顶部
 * .table-title-left 标题在左边
 * .tab-border-no 无边框，标题在左表格
 * .tab-img-id 图片
 */
.table{
  border-collapse: collapse;
}
.table > thead > tr > th, .table > tbody > tr > th, .table > tfoot > tr > th, .table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td{padding:3px;}
.table-title-left{width: 100%; table-layout: fixed;}
.table-title-left tbody tr th,.table-title-left tbody tr td{border: 1px solid #ddd; font-size: 14px; color: #000; text-align: center; vertical-align: middle; padding: 6px;}
.table-title-left tbody tr th{ background: #f5f5f5; font-weight: normal;}
.table-title-left tbody tr td{ text-align: left;}
.table-title-left tbody tr td img{width: 120px; height: 90px;}
.table tr td input.inp-form,.table tr td select.set-form {width: 100%;}
.table tr td textarea.textarea-form{width: 100%; resize: none; margin-bottom: 10px;}
/*-----------表格样式 end-------------------*/
</style>
