package com.hengyunsoft.security.auth.account;

import com.hengyunsoft.security.auth.common.util.jwt.IJWTInfo;
import com.hengyunsoft.security.auth.common.util.jwt.JWTHelper;

/**
 * @author tyh
 * @createTime 2018-01-02 16:26
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//@Log4j2
public class AccountTest {

    //@Test
    public void testGenToken(){
        //Token token = JWTHelper.generateToken(
        //        new JWTInfo("admin", -1L, "最后", null)
        //        , "app/pri.key", 24 * 1000);
        //System.out.println(token.getToken());
        //System.out.println(token.getExpire());
    }


    //@Test
    public void testParseToken(){
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImFkbWluSWQiOi0xLCJuYW1lIjoi5pyA5ZCOIiwiZXhwIjoxNTE5NjU2NDc1fQ.cFRN6w2kVsb383if7OltYADglAjDbEw-rMaO-yYrYHuWC0mYhw88dl4IL16ncF7pOZhwLGaVIrwTH0a7P2kHwrTkTfAGGbllI9VyvXPQISCQ-rItPQVPcDetHwvLyYYDU38p5-XW6D5xM1Ecgb3Rp-JPETOkjWTZ7EyFfuajRDY";
        IJWTInfo infoFromToken = JWTHelper.getInfoFromToken(token, "app/pub.key");
        //
        //System.out.println(infoFromToken.getAppId());
        //System.out.println(infoFromToken.getAdminId());
        //System.out.println(infoFromToken.getUserName());
        //System.out.println(infoFromToken.getName());
    }
}
