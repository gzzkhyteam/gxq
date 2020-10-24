/**
 * Created by hy on 2018/6/20
 * 全局加载
 */
const state = {
    alertList: []
}

const mutations = {
    PUSH_ALERT(state, playload) {
        state.alertList.push({ text: playload || '网络错误' })
    },
    SHIFT_ALERT(state) {
        state.alertList.shift()
    }
}
const getters = {
    isAlert(state) {
        return state.alertList.length > 0
    },
    alertText(state) {
        return state.alertList.length > 0 ? state.alertList[0].text : null
    }
}
const actions = {
    openAlert(contaxt, playload) {
        contaxt.commit('PUSH_ALERT', playload)
    },
    closeAlert(contaxt) {
        contaxt.commit('SHIFT_ALERT')
    }
}
module.exports = {
    state,
    mutations,
    getters,
    actions
}