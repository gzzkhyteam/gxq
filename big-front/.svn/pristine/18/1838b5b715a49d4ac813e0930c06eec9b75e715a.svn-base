<!-- 
  对iview table和分页进行二次封装，融合在一起
  table属性事件等和iview的table一样
  page属性变化如下：
    size更换为pageType
  page的slot需要指定name为page
  新增方法
    onPageChange，返回值为(pageNo,pageSize),页码变化时触发
  slot: 出现在table和page之间
  新增属性
    needPage: 默认为true,是否需要显示分页信息
-->

<template>
  <div class="hy-table">
    <Table
      :data="data"
      :columns="columns"
      :size="size"
      :width="width"
      :height="height"
      :stripe="stripe"
      :border="border"
      :showHeader="showHeader"
      :highlightRow="highlightRow"
      :rowClassName="rowClassName"
      :noDataText="noDataText"
      :noFilteredDataText="noFilteredDataText"
      :disabledHover="disabledHover"
      :loading="loading"
      @on-current-change="onCurrentChange"
      @on-select="onSelect"
      @on-select-cancel="onSelectCancel"
      @on-select-all="onSelectAll"
      @on-selection-change="onSelectionChange"
      @on-sort-change="onSortChange"
      @on-filter-change="onFilterChange"
      @on-row-click="onRowClick"
      @on-row-dbclick="onRowDbClick"
      @on-expand="onExpand"
      ref="hyTable">
      <slot name="header"></slot>
      <slot name="footer"></slot>
      <slot name="loading"></slot>
    </Table>
    <slot></slot>
    <div class="bottom-bar clearfix" v-if="needPage">
      <Button v-if="showElevator" type="primary" size="small" @click="goElevatorPage" style="float:right; margin: 5px;">跳转</Button>
      <Page
        :id="pageId"
        :current="current"
        :total="total"
        :page-size="pageSize"
        :page-size-opts="pageSizeOpts"
        :placement="placement"
        :transfer="transfer"
        :size="sizeType"
        :simple="simple"
        :show-total="showTotal"
        :show-elevator="showElevator"
        :show-sizer="showSizer"
        :class-name="className"
        :styles="styles"
        @on-change="onChange"
        @on-page-size-change="onPageSizeChange"
        style="float: right;">
          <slot name="page"></slot>
      </Page>
    </div>
  </div>
</template>

<script>
function oneOf (value, validList) {
  for (let i = 0; i < validList.length; i++) {
    if (value === validList[i]) {
      return true;
    }
  }
  return false;
}
export default {
  props: {
    data: {
      type: Array,
      default () {
        return [];
      }
    },
    columns: {
      type: Array,
      default () {
        return [];
      }
    },
    size: {
      validator (value) {
        return oneOf(value, ['small', 'large', 'default']);
      }
    },
    width: {
      type: [Number, String],
      default: ''
    },
    height: {
      type: [Number, String],
      default: ''
    },
    stripe: {
      type: Boolean,
      default: false
    },
    border: {
      type: Boolean,
      default: false
    },
    showHeader: {
      type: Boolean,
      default: true
    },
    highlightRow: {
      type: Boolean,
      default: false
    },
    rowClassName: {
      type: Function,
      default () {
        return '';
      }
    },
    noDataText: {
      type: String
    },
    noFilteredDataText: {
      type: String
    },
    disabledHover: {
      type: Boolean
    },
    loading: {
      type: Boolean,
      default: false
    },
    current: {
      type: Number,
      default: 1
    },
    total: {
      type: Number,
      default: 0
    },
    pageSize: {
      type: Number,
      default: 10
    },
    pageSizeOpts: {
      type: Array,
      default () {
        return [10, 20, 30, 40];
      }
    },
    placement: {
      validator (value) {
        return oneOf(value, ['top', 'bottom']);
      },
      default: 'bottom'
    },
    transfer: {
      type: Boolean,
      default: false
    },
    sizeType: {
      validator (value) {
        return oneOf(value, ['small']);
      }
    },
    simple: {
      type: Boolean,
      default: false
    },
    showTotal: {
      type: Boolean,
      default: false
    },
    showElevator: {
      type: Boolean,
      default: false
    },
    showSizer: {
      type: Boolean,
      default: false
    },
    className: {
      type: String
    },
    styles: {
      type: Object
    },
    needPage: {
      type: Boolean,
      default: true
    }
  },
  data () {
    return {
      pageId: 'pageOne',
      pageInfo: {
        pageSize: this.pageSize,
        pageNo: this.current
      }
    }
  },
  methods: {
    onCurrentChange (currentRow, oldCurrentRow) {
      this.$emit('on-current-change', currentRow, oldCurrentRow)
    },
    onSelect (selection, row) {
      this.$emit('on-select', selection, row)
    },
    onSelectCancel (selection, row) {
      this.$emit('on-select-cancel', selection, row)
    },
    onSelectAll (selection) {
      this.$emit('on-select-all', selection)
    },
    onSelectionChange (selection) {
      this.$emit('on-selection-change', selection)
    },
    onSortChange (column, key, order) {
      this.$emit('on-sort-change', column, key, order)
    },
    onFilterChange (row) {
      this.$emit('on-filter-change', row)
    },
    onRowClick (index) {
      this.$emit('on-row-click', index)
    },
    onRowDbClick (index) {
      this.$emit('on-row-dbclick', index)
    },
    onExpand (row, status) {
      this.$emit('on-expand', row, status)
    },
    exportCsv (data) {
      this.$refs.hyTable.exportCsv(data)
    },
    clearCurrentRow () {
      this.$refs.hyTable.clearCurrentRow()
    },
    onChange (pageNo) {
      this.$emit('on-change', pageNo)
      this.pageInfo.pageNo = pageNo
      this.onPageChange()
    },
    onPageSizeChange (pageSize) {
      this.$emit('on-page-size-change', pageSize)
      this.pageInfo.pageSize = pageSize
      this.onPageChange()
    },
    onPageChange () {
      this.$emit('on-page-change', this.pageInfo.pageNo, this.pageInfo.pageSize)
    },
    goElevatorPage () {
      var evtObj
      var thisPage=document.getElementById(this.pageId)
      var elevatorDiv=thisPage.getElementsByClassName("ivu-page-options-elevator")
      if(elevatorDiv && elevatorDiv.length>0){
        var pageInput = elevatorDiv[0].getElementsByTagName("input")[0]
        if (window.KeyEvent) {// firefox 浏览器下模拟事件
          evtObj = document.createEvent('KeyEvents')
          evtObj.initKeyEvent("keyup", true, true, window, true, false, false, false, 13, 0)
        } else {// chrome 浏览器下模拟事件
          evtObj = document.createEvent('UIEvents')
          evtObj.initUIEvent("keyup", true, true, window, 1)
          delete evtObj.keyCode
          if (typeof evtObj.keyCode === "undefined") {// 为了模拟keycode
            Object.defineProperty(evtObj, "keyCode", { value: 13 })
          } else {
            evtObj.key = String.fromCharCode(13)
          }
        }
        pageInput.dispatchEvent(evtObj)
      }
    }
  }
}
</script>
<style lang="less">
.hy-table{
  margin-bottom: 20px;
}
.bottom-bar{
	text-align: right;
  margin-top:30px;
}
</style>
