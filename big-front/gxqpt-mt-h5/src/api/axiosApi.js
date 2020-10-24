/**
 * axiosApi封装，接口属于mock，可以修改
 * author：liuguangrui
 */
// import axios from 'axios'
import qs from 'qs'
import store from '../store'
axios.defaults.timeout = 5000
var roots = process.env.API_ROOT;
//请求拦截器配置
axios.interceptors.request.use(config => {
    return config
}, error => {
    return Promise.reject(error)
})
//判断是否断网
var EventUtil = {
    addHandler: function (element, type, handler) {
        if (element.addEventListener) {
            element.addEventListener(type, handler, false);
        } else if (element.attachEvent) {
            element.attachEvent("on" + type, handler);
        } else {
            element["on" + type] = handler;
        }
    }
};
EventUtil.addHandler(window, "online", function () {
    store.state.loading.networkOk = true;
    console.log("Online---正常工作");
});
EventUtil.addHandler(window, "offline", function () {
    store.state.loading.networkOk = false;
    console.log("Offline ---离线");
});
// 返回拦截器配置
axios.interceptors.response.use(response => {
    console.log(response);
    return response
}, error => {
    return Promise.resolve(error.response)
})

// 错误返回
function errorState(res) {
    //加入loading  
    // // 如果http状态码正常，则直接返回数据  
    // if (response && response.data.errcode == 0) {
    //     return response
    // // token过期失效码，重新向安卓请求
    // } else if (response && (response.data["errcode"] == 40001 || response.data["errcode"] == 40003 || response.data["errcode"] == 40005)) {
    //     console.log("token过期");
    //     store.commit('getUserInfo');//重新获取userid和token
    //     store.state.alertText = 'token过期';
    //     store.state.isAlert = true;
    // } else {
    store.dispatch('closeLoading', false);
    console.log("失败");
    console.log(res);
    // store.state.alertText ='服务超时，请稍候再试!';
    // store.state.isAlert = true;
    console.log('服务超时，请稍候再试');
    // }

}
// 成功后返回
function successState(res) {
    console.log("成功");
    //加入loading 
    //统一判断后端返回的错误码  
    if (res.data.errcode == 0) {
        console.log('接口返回正常');
    } else if (res.data["errcode"] == 40001 || res.data["errcode"] == 40003 || res.data["errcode"] == 40005 || res.data["errcode"] == 75521) {
        console.log('用户信息');
        console.log(store.state.userInfo);
        store.dispatch('closeLoading', false);
        store.commit('getUserInfo');
        console.log(res.data.errmsg);
        // store.state.alertText = res.data.errmsg+"，请刷新后重试！";
        // store.state.isAlert = true;
    }else{
        console.log(res);
        if (res.data.errmsg.length>500){
          store.state.alertText = '网络异常，请检查网络后重试！';
          store.state.isAlert = true;
        }else{
            // store.state.alertText = res.data.errmsg;
        }
        console.log('未知返回码的错误异常');
    }
}
// http请求
const httpServer = (opts, data) => {
    const promise = new Promise(function (resolve, reject) {
        function doHttpRequest () {
            let Public = { //公共参数  
                userId: store.state.userInfo.userId,
                token: store.state.userInfo.token,
                unitId: store.state.userInfo.unitId,
                data: {
                    userId: store.state.userInfo.userId,
                    unitId: store.state.userInfo.unitId,
                }
            }
            if (!opts.loadHide) store.dispatch('openLoading')
            let httpDefaultOpts = { //http默认配置  
                method: opts.method,
                // baseURL: "http://" + location.host + "/api",
                baseURL: roots,
                url: opts.url,
                timeout: 10000,
                params: Object.assign(Public, data),
                data: Object.assign(Public, data),
                headers: opts.method == 'get' ? { //配置请求头数据
                    'X-Requested-With': 'XMLHttpRequest',
                    "Accept": "application/json",
                    "Content-Type": "application/json; charset=UTF-8",
                    "token": store.state.userInfo.token 
                } : {
                        '_user_id': store.state.userInfo.userId,
                        'X-Requested-With': 'XMLHttpRequest',
                        'Content-Type': opts.ContenType || 'application/json',
                        "token": store.state.userInfo.token
                    }
            }
            if (opts.method == 'get') {
                delete httpDefaultOpts.data
            } else {
                if (opts.type) {//判断post请求条件下是否有设置contentType
                    delete httpDefaultOpts.data
                } else {
                    delete httpDefaultOpts.params
                } 
            }
            axios(httpDefaultOpts).then(
                (res) => {
                    successState(res)
                    resolve(res)
                    setTimeout(() => {
                        store.dispatch('closeLoading', false);
                    }, 500);
                }
            ).catch(
                (response) => {
                    errorState(response)
                    reject(response)
                    setTimeout(() => {
                        store.dispatch('closeLoading');
                    }, 500);
                }
            )
        }
        let tryCount = 0;
        // 尝试10次，如果10次还没返回用户信息，那就放弃接口请求
        const timeInterval = setInterval(() => {
            tryCount++;
            if (store.state.userInfo.userId && tryCount < 10) {
                clearInterval(timeInterval);
                doHttpRequest();
            } else if (tryCount >= 10) {
                store.state.alertText = '获取用户信息失败！';
                store.state.isAlert = true;
                resolve();
                clearInterval(timeInterval);
            }
        }, 200)
        
        tryCount = 0;

    })
    return promise
}

export default httpServer  