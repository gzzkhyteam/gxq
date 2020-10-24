//import java.util.List;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.hengyunsoft.platform.commons.sec.UserTokenExtInfo;
//import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
//
//public class BitEncryptUserTokenTest {
//
//	public static void main(String[] args) throws Exception {
//
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
//		BitEncryptUserToken e = new BitEncryptUserToken(objectMapper );
//		UserTokenExtInfo extInfo = new UserTokenExtInfo();
//		extInfo.setAccount("sdf");
//		extInfo.setLogoutFlag(1L);
//		String tt = e.encoder("sdf", "sdf", "潘定遥", extInfo);
//		System.out.println(tt);
//		List s = e.uncoder(tt);
//		System.out.println(s);
//
//		 tt = e.encoder("sdf", "sdf", "潘定遥", null);
//		System.out.println(tt);
//		 s = e.uncoder(tt);
//		System.out.println(s);
//	}
//
//
//}
