/**
 * Created by hy on 2018/6/20
 * 全局加载
 */
import store from '../../store'
const state = {
    loadingList: [],
    networkOk:true
}

const mutations = {
    PUSH_LOADING(state, playload) {
        if (state.networkOk){
            state.loadingList.push({ text: playload || '加载中...' })
        }else{
            store.state.alertText = '未连接到互联网，请检查网络后重试试！';
            store.state.isAlert = true;
        }
    },
    SHIFT_LOADING(state) {
        state.loadingList.shift()
    }
}
const getters = {
    isLoading(state) {
        return state.loadingList.length > 0
    },
    loadingText(state) {
        return state.loadingList.length > 0 ? state.loadingList[0].text : null
    }
}
const actions = {
    openLoading(contaxt, playload) {
        contaxt.commit('PUSH_LOADING', playload)
    },
    closeLoading(contaxt) {
        contaxt.commit('SHIFT_LOADING')
    }
}
export default {
    state,
    mutations,
    getters,
    actions
};
// module.exports = {
//     state,
//     mutations,
//     getters,
//     actions
// }