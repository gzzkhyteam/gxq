import hyRate from './hyRate'

hyRate.install = (Vue, options) => {
  Vue.component('hy-rate', hyRate)
}

export default hyRate
