/**
 * axiosApi封装，接口属于mock，可以修改
 * author：liuguangrui
 */
/* eslint-disable */
import axios from 'axios'
import qs from 'qs'
import store from '@/store'
import '@static/login'

var roots = process.env.API_ROOT
function toLoginUI(){
  loginController.toLoginOut()
}
function loginTimeoutCheck(){
  var currentDatetime = new Date().getTime();
  var next_time_out = localStorage.getItem("login_time_out");
  var update_next_time_out = new Date().getTime() + 30*60*1000;
  if(!next_time_out){

    localStorage.setItem("login_time_out",update_next_time_out+"");
    return true;
  } else {
    next_time_out = parseFloat(next_time_out);
    if(currentDatetime > next_time_out){
      localStorage.removeItem("login_time_out");
      toLoginUI();
      return false;
    } else {

      localStorage.setItem("login_time_out",update_next_time_out+"");
      return true;
    }
  }
}
//请求拦截器配置
axios.interceptors.request.use(config => {
    return config
}, error => {
    return Promise.reject(error)
})

// 返回拦截器配置
axios.interceptors.response.use(response => {
	if(response.data.errcode == '-9999'){//已退出登陆
		loginController.emptyLoginUserInfo();
		loginController.loginFlow();
	}
	if(response.data && response.data.data && response.data.data.total){
		response.data.data.total = Number(response.data.data.total);
	}
    return response
}, error => {
    return Promise.resolve(error.response)
})

// 错误返回
function errorState(response) {
    //加入loading  
    console.log(response)
    // 如果http状态码正常，则直接返回数据  
    if (response && response.data.errcode == 0) {
        return response
    // token过期失效码，重新向安卓请求
    } else if (response && (response.data["errcode"] == 40001 || response.data["errcode"] == 40003 || response.data["errcode"] == 40005)) {
        store.commit('GETUSERINFO');//重新获取userId和token
        store.state.alertText = response.data.msg;
        store.state.isAlert = true;
    } else {
        store.state.alertText = res.data.msg || '网络异常，请检查网络后重试！';
        store.state.isAlert = true;
        console.log('网络异常1');
    }

}
// 成功后返回
function successState(res) {
    //加入loading 
    //统一判断后端返回的错误码  
    if (res.data.errcode == 0) {
        console.log('接口返回正常');
    } else if (res.data.errcode != 0 && res.data.errcode != '0') {
        store.state.alertText = res.data.msg || '网络异常，请检查网络后重试！';
        store.state.isAlert = true;
        console.log('网络异常2');
    }
}

// http请求
const httpServer = (opts, data) => {


	var userInfo = loginController.getCurProjectLoginUserInfon();
    userInfo.userId = userInfo.userid;
    let HYtimestamp = (new Date()).getTime();
    let Public = { //公共参数  
        'HYtimestamp': HYtimestamp
        // userId: userInfo.userId,
        // token: userInfo.token,
        // unitId: userInfo.unitId
    }
//  store.dispatch('openLoading')
    // store.dispatch('openLoading');
    let httpDefaultOpts = { //http默认配置  
        method: opts.method,
        baseURL:roots,
        url: opts.url,
        timeout: 10000,
        params: Object.assign(Public, data),
        data: Object.assign(Public, data),
        headers: opts.method == 'get' ? { //配置请求头数据
            'X-Requested-With': 'XMLHttpRequest',
            "Accept": "application/json",
            "Content-Type": "application/json; charset=UTF-8",
//          "token": "TzH_xvPztSL_buXkJ8HpbFFM4apmXG8az02STEzXhQryHnpiRNjy5fTit7j4xR0lVqDIJiFi2cXEzpFl4Cr2RmNBfJTIbqlMxCBIrsH_hUfFZwvclEruxdr6vGVuLyJ_h9TLhkdspzxLfNd98gNrnBRpXsHljnnAhM6RnzzeRwv4jn6ulsXxza2LFcJZjD6.H6LaJiVkZ6Va8aH9zx2yRfN5PDdUtsZLTZfVxMfjTUPK6XhpbpLn4SteBsJRf8tKFpFnVFLa64DYvrvdlTtLDdHr6R5ctjdfJV0HXFjCd5REdThp8PTPt92bDJz60ltkXw4.zGfrxCZyNQ8VhLVjPmrshuttj6Lqz2tTHzxWlLjXzp6MNQP4DtrRlvp88xBtXd5izU5b69PKnTDSNef7rCrylXxOFyhrfo6kf_nVLoNSft0EPRbxDyfInJxxTvZHzBfWBI5QB0fWFfj6BP6IRFN2r6lPNqrOV2XUvdlsvPHAHl8FVabxrqvlTYNglnDMvBturxhsxQ64vavpbo8hxPlwHpFcJf6wpoLB5RB6t7vfbqXVpwxrni4UfnrrdGTk4O5qvuN_tifdLmhiNxpsvc4un7jfhL5mfaL.5aTtF2ltLazER6xZ2ndwDnfHN8fP0uPcjGFo6.8jtdJ6rHDr6UdxTmxi2ffhL9Mdm.y.wmIVzwN.k75o_39319d4mwuC.v7gTR_WtG_57Vl.3_oojqu_.e5HewKo5sfvzkF81YS..J7uWyMV7c.NNC_q54wZ9ZK5irVy.5vmYoo67UCr"
          "token": userInfo.token
        } : {
                '_user_id': userInfo.userId,
                'X-Requested-With': 'XMLHttpRequest',
                'Content-Type': opts.contentType || 'application/json',
//              "token": "TzH_xvPztSL_buXkJ8HpbFFM4apmXG8az02STEzXhQryHnpiRNjy5fTit7j4xR0lVqDIJiFi2cXEzpFl4Cr2RmNBfJTIbqlMxCBIrsH_hUfFZwvclEruxdr6vGVuLyJ_h9TLhkdspzxLfNd98gNrnBRpXsHljnnAhM6RnzzeRwv4jn6ulsXxza2LFcJZjD6.H6LaJiVkZ6Va8aH9zx2yRfN5PDdUtsZLTZfVxMfjTUPK6XhpbpLn4SteBsJRf8tKFpFnVFLa64DYvrvdlTtLDdHr6R5ctjdfJV0HXFjCd5REdThp8PTPt92bDJz60ltkXw4.zGfrxCZyNQ8VhLVjPmrshuttj6Lqz2tTHzxWlLjXzp6MNQP4DtrRlvp88xBtXd5izU5b69PKnTDSNef7rCrylXxOFyhrfo6kf_nVLoNSft0EPRbxDyfInJxxTvZHzBfWBI5QB0fWFfj6BP6IRFN2r6lPNqrOV2XUvdlsvPHAHl8FVabxrqvlTYNglnDMvBturxhsxQ64vavpbo8hxPlwHpFcJf6wpoLB5RB6t7vfbqXVpwxrni4UfnrrdGTk4O5qvuN_tifdLmhiNxpsvc4un7jfhL5mfaL.5aTtF2ltLazER6xZ2ndwDnfHN8fP0uPcjGFo6.8jtdJ6rHDr6UdxTmxi2ffhL9Mdm.y.wmIVzwN.k75o_39319d4mwuC.v7gTR_WtG_57Vl.3_oojqu_.e5HewKo5sfvzkF81YS..J7uWyMV7c.NNC_q54wZ9ZK5irVy.5vmYoo67UCr"
             "token": userInfo.token
            }
    }
    // 
    loginTimeoutCheck()
    if (opts.method == 'get') {
        delete httpDefaultOpts.data
    } else {
        httpDefaultOpts.url = httpDefaultOpts.url + '?HYtimestamp=' + HYtimestamp 
        if (opts.contentType){//判断post请求条件下是否有设置contentType
            delete httpDefaultOpts.data
        }else{
            delete httpDefaultOpts.params
        } 
    }

    let promise = new Promise(function (resolve, reject) {
        axios(httpDefaultOpts).then(
            (res) => {
                successState(res)
                resolve(res)
//              store.dispatch('closeLoading', false);
            }
        ).catch(
            (response) => {
                if (response.data["errcode"] == 40001 || response.data["errcode"] == 40003 || response.data["errcode"] == 40005) {
                    store.commit('GETUSERINFO');//重新获取userId和token
                    return 
                }
                errorState(response)
                reject(response)
//              store.dispatch('closeLoading');
            }
        )

    })
    return promise
}

export default httpServer  