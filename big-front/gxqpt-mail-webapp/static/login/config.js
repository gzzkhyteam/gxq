/* window.serverInfoConfi={
  sso_ip: "127.0.0.1",
  sso_port: "10087",
  local_ip: "192.168.1.40",
  local_port: "8081"
}
window.loginConfig = {
  //测试环境地址
  sso_login_url: "https://"+serverInfoConfi.sso_ip+":"+serverInfoConfi.sso_port+"/gxqpt-center/slogin",
  sso_validate_url: "https://"+serverInfoConfi.sso_ip+":"+serverInfoConfi.sso_port+"/gxqpt-center/svalidate",
  sso_logout_url: "https://"+serverInfoConfi.sso_ip+":"+serverInfoConfi.sso_port+"/gxqpt-center",
  email_local_service_url: "https://"+serverInfoConfi.local_ip+":"+serverInfoConfi.local_port+"/gxqpt-email/index.html",
  "gxqpt-email_appKey": "2xN3tstuZifXtfvCTwv1zMBe6K2nb.Zej1bztFPgtmrWeXD8JxB0e",
  //生产环境地址
  sso_login_url: "/gxqpt-center/slogin",
  sso_validate_url: "/gxqpt-center/svalidate",
  sso_logout_url: "/gxqpt-center",
  email_local_service_url: "/gxqpt-email/index.html",
  "gxqpt-email_appKey": "2xN3tstuZifXtfvCTwv1zMBe6K2nb.Zej1bztFPgtmrWeXD8JxB0e",
}; */
window.loginConfig = {
  sso_login_url: "http://" + window.location.host + "/gxqpt-center/slogin",
  sso_validate_url: "http://" + window.location.host + "/gxqpt-center/svalidate",
  sso_logout_url: "http://" + window.location.host + "/gxqpt-center/logout",
  email_local_service_url: "http://" + window.location.host + "/gxqpt-email/index.html",
  "gxqpt-email_appKey": "2xN3tstuZifXtfvCTwv1zMBe6K2nb.Zej1bztFPgtmrWeXD8JxB0e",
};
