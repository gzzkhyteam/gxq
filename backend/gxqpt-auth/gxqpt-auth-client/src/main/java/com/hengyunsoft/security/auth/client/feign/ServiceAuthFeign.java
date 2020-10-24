package com.hengyunsoft.security.auth.client.feign;

/**
 * @author tyh
 * @createTime 2017-12-13 16:04
 */
//@FeignClient(value = "${auth.serviceId}", configuration = {})
//public interface ServiceAuthFeign {

    //注意： 1，这里不能用@PostMapping/@GetMapping
    //2，@RequestParam @PathVariable 必须明确写上 value值
    // 否则会报错！！！
    //@RequestMapping(value = "/client/token", method = RequestMethod.POST)
    //Result<TokenVo> getAccessToken(@RequestParam("clientId") String clientId, @RequestParam("secret") String secret);

//}