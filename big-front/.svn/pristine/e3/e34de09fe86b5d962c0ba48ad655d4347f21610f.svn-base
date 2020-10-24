<!-- 
  对iview rate的二次封装
  原有prop
    count star总数 Number  5
    value 当前star数，可以使用 v-model 双向绑定数据 Number  0
    allow-half  是否允许半选  Boolean false
    disabled  是否只读，无法进行交互 Boolean false
    show-text 是否显示提示文字  Boolean false
    clearable 是否可以取消选择 Boolean false
  增加prop
    sglValue 单颗星星的数值 Number 1
-->

<template>
  <Rate
    :count="count"
    :value="realValue"
    :allowHalf="allowHalf"
    :disabled="disabled"
    :showText="showText"
    :clearable="clearable"
    @on-change="onChange">
    <slot></slot>
  </Rate>
</template>

<script>

export default {
  props: {
    count: {
      type: Number,
      default: 5
    },
    value: {
      type: Number,
      default: 0
    },
    allowHalf: {
      type: Boolean,
      default: false
    },
    disabled: {
      type: Boolean,
      default: false
    },
    showText: {
      type: Boolean,
      default: false
    },
    clearable: {
      type: Boolean,
      default: false
    },
    sglValue: {
      type: Number,
      default: 1
    }
  },
  computed: {
    realValue () {
      return this.value / this.sglValue
    }
  },
  methods: {
    onChange (val) {
      this.$emit('input', val * this.sglValue)
      this.$emit('on-change', val * this.sglValue)
    }
  }
}
</script>
