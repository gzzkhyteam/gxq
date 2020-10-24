<!-- 应用预警关联分析 -->
<template>
  <Table highlight-row :columns="tableList.columns" :data="tableList.data" id="appRelationTable"></Table>
</template>

<script>
export default {
  data () {
    return {
      tableList: {
        columns: [
          {
            type: 'index',
            title: '序号',
            width: 60,
            align: 'center'
          },
          {
            title: '关联规则',
            key: 'source',
            render: (h, params) => {
              return h('span', `${params.row.source} => ${params.row.target}`)
            }
          },
          {
            title: '支持度',
            key: 'supportDegree',
            render: (h, params) => {
              return h('span', `${params.row.supportDegree}%`)
            }
          },
          {
            title: '置信度',
            key: 'confidenceDegree',
            render: (h, params) => {
              return h('span', `${params.row.confidenceDegree}%`)
            }
          }
        ],
        data: []
      }
    }
  },
  methods: {
    refresh (data) {
      this.tableList.data = data
    }
  }
}
</script>

<style lang="less">
#appRelationTable{
  .ivu-table-body{
    max-height: 260px;
    overflow: auto;
  }
}
</style>
