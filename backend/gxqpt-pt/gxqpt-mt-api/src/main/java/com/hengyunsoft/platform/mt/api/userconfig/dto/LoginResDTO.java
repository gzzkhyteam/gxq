package com.hengyunsoft.platform.mt.api.userconfig.dto;

import com.hengyunsoft.security.auth.dto.TokenVo;
import com.hengyunsoft.security.auth.dto.UserDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * com.hengyunsoft.platform.mt.api.userconfig.dto
 * 版权：中科恒运软件科技股份有限公司贵阳分公司
 * 描述：登录返回
 * 修改人：gbl
 * 修改时间：2018/6/26
 * 修改内容：
 */
@Data
@ApiModel(value = "LoginRes", description = "登录返回")
public class LoginResDTO {
    @Autowired
    private UserDTO user;
    @Autowired
    private String token;

}
