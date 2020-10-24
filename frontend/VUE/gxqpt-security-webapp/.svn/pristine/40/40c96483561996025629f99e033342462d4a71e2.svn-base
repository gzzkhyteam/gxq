<template>
  <Form
    inline
    :label-width="100"
    :model="searchCondition">
    <FormItem label="日志类别：" :label-width="76">
      <Select v-model="searchCondition.logType" style="width:160px">
        <Option value="-1">全部</Option>
        <Option :value="item.code" v-for="item in logCode" :key="item.id">{{item.name}}</Option>
      </Select>
    </FormItem>
    <FormItem label="故障级别：" :label-width="76">
      <Select v-model="searchCondition.faultLevel" style="width:160px">
        <Option value="-1">全部</Option>
        <Option :value="item.code" v-for="item in faultLevel" :key="item.id">{{item.name}}</Option>
      </Select>
    </FormItem>
    <FormItem :label-width="20">
      <Button type="primary" @click="preSearch">查询</Button>
      <Button type="primary" @click="create">新增</Button>
    </FormItem>
  </Form>
</template>

<script>
export default {
  // 分别为 日志类别，故障分类，故障级别
  props: ['logCode', 'faultClass', 'faultLevel'],
  data () {
    return {
      // 预警搜索条件
      searchCondition: {
        logType: '-1',
        faultLevel: '-1'
      }
    }
  },
  methods: {
    // 新增
    create () {
      this.$emit('onCreate')
    },
    // 预备搜索
    preSearch () {
      const vm = this
      const condition = vm.getCondition()
      vm.$emit('searchClick', condition)
    },
    getCondition () {
      const vm = this
      return {
        logType: vm.searchCondition.logType === '-1' ? '' : vm.searchCondition.logType,
        faultLevel: vm.searchCondition.faultLevel === '-1' ? '' : vm.searchCondition.faultLevel
      }
    }
  }
}
</script>
