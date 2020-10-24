/*获取token*/
function getToken() {
    // return 'eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiIxIiwibmFtZSI6ImFkbWlubGxsIiwiYXBwSWQiOiIyNWtqNjM1NSIsImV4cCI6MTUyMzUxNDM3MX0.TGtvRgTikLwBx5F1JtobpoTPO4ylvlh4ksKYGpJYnd_UE2JGdg3PYGocY3k6YdSBG6qVvSMGjYw351UqQQPcT4pBaxKs2xDTDnD4tgGrXE2rtDR4LMLfr91OkfGS3-c0MGK7nynh6YyZGGci7SuGuKcUnHZIv5eoOhPwDmD1BIw';
    return 'eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiI0NWtqNjM1MiIsImFwcE5hbWUiOiLkupHnm5jnrqHnkIbns7vnu58iLCJleHAiOjE1MjQxMzQwOTR9.kmHYfDqILcCV2Ebt2zq4P074gk8wa_-KKs-4GbsizjDqz44cy1y03deK8_r7KLaH8cU1tkFfKZM1f6-TryopTHyUVdSbdbWtmdf2p7lU59UyWvwDjhDewkIpW0FJpvknm2wxtPJHw46fUUcifGS_BNqSKvXqbby_Hb7Bs_sF_-U';
}

function getHeaders(){
    return {
        "token": $.cookie("_token")
    }
}
function getUrlPrev(gateUrl) {
    return gateUrl+'/api/developer/';//服务器的服务
    // return 'http://192.168.1.54:10003/api/admin/';//厚兵的服务
    //  return 'http://192.168.1.36:10003/api/developer/';//灯波的服务
    // return 'http://192.168.1.124:10003/api/admin/';//王镇的服务
    // return 'http://192.168.1.62:10003/api/admin/';//昌宏的服务
    // return 'http://192.168.1.36:10003/api/admin/';
}