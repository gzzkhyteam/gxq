<!-- 环节配置 -->
<template>
  <Layout>
    <Content>
      <Breadcrumb>
        <BreadcrumbItem>统一监管平台</BreadcrumbItem>
        <BreadcrumbItem>数据存储监管配置中心</BreadcrumbItem>
        <BreadcrumbItem>历史数据</BreadcrumbItem>
      </Breadcrumb>
      <Card style="min-height: 600px;">
        <Form ref="formValidate" inline :label-width="110" :model="searchData">
          <FormItem label="开始时间：">
            <DatePicker :value="searchData.startTime" type="datetime" style="width: 200px" clearable @on-change="startTimeChange"></DatePicker>
          </FormItem>
          <FormItem label="结束时间：">
             <DatePicker :value="searchData.endTime" type="datetime" style="width: 200px" clearable @on-change="endTimeChange"></DatePicker>
          </FormItem>
          <FormItem :label-width="20">
            <Button type="primary" @click="perSearch">查询</Button>
            <Button type="primary" @click="goback">返回</Button>
          </FormItem>
        </Form>
        <hy-table
          highlight-row
          border
          ref="unitTable"
          :current="pageInfo.pageNo"
          :columns="tableList.columns"
          :data="tableList.data"
          :total="Number(pageInfo.total)"
          :pageSize="Number(pageInfo.pageSize)"
          pageType="small"
          show-elevator
          @on-page-change="pageChange"
          show-sizer/>
      </Card>
    </Content>
  </Layout>
</template>

<script>
  import api from '@/api/axiosApi'
  import superviseApiList from '@/api/superviseApiList'
  export default {
    data() {
      return {
        searchData: {
          startTime: '',
          endTime: '',
          storageId: this.$route.params.id
        },
        tableList: {
          columns: [
            {
              type: 'index',
              title: '序号',
              width: 60,
              align: 'center'
            },
            {
              title: '数据库空间阈值(G)',
              key: 'dbSpaceNum'
            },
            {
              title: '日志空间阀值(G)',
              key: 'logSpaceNum'
            },
            {
              title: '文件空间阀值(G)',
              key: 'fileSpaceNum'
            },
            {
              title: '采集时间',
              key: 'createTime'
            }
          ],
          data: []
        },
        // 分页数据
        pageInfo: {
          pageNo: 1,
          pageSize: 10,
          total: 0
        }
      }
    },
    mounted() {
      this.perSearch();
    },
    methods: {
      startTimeChange (dateString) {
        this.searchData.startTime = dateString
      },
      endTimeChange (dateString) {
        this.searchData.endTime = dateString
      },
      perSearch () {
        this.pageInfo.pageNo = 1
        this.getList()
      },
      pageChange (pageNo, pageSize) {
        this.pageInfo.pageNo = pageNo
        this.pageInfo.pageSize = pageSize
        this.getList()
      },
      getList () {
        let data = {
          data: this.searchData,
          pageNo: this.pageInfo.pageNo,
          pageSize: this.pageInfo.pageSize
        }
        api(superviseApiList.pageHistory, data).then((res) => {
            if (res.data && res.data.errcode === 0) {
              this.tableList.data = res.data.data.list
              this.pageInfo.total = res.data.data.total
            } else {
              this.tableList.data = []
            }
        }, (err) => {})
      },
      goback () {
        this.$router.go(-1)
      }
    }
  }
</script>

<style lang='less' scoped>
  .ivu-btn-small {
    margin: 0 3px;
  }
  .handle{
    color:red;
    cursor: pointer;
  }
  .queryItem {
    width: 200px;
  }
  .access-list {
    span.handle {
      margin: 0 5px;
      display: inline-block;
      cursor: pointer;
      &:hover {
        color: #57a3f3;
      }
    }
  }
</style>
