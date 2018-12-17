package cn.et;

import java.util.Base64;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	/**
	 * 用戶首次訪問設置狀態 401 
	 *  設置響應頭"WWW-Authenticate", "Basic realm=\"Test Authenticate\"
	 *    客戶端一般會彈出輸入輸入用戶名和密碼框
	 *  輸入用戶名和密碼會重新發一個請求 會有一個  
	 *    Authorization 請求頭格式一般是 base64編碼的字符串
	 *  比如： Authorization: Basic YWRtaW46YWRtaW4=    
	 * @param response
	 * @param authorization
	 * @return
	 */
	 @RequestMapping("/user")
     String home(HttpServletResponse response,@RequestHeader(value="Authorization",required=false) String authorization) {
		 if(authorization!=null) {
			String userPass=authorization.split(" ")[1];
			String userPassUrl=new String(Base64Utils.decodeFromString(userPass));
			String userName = userPassUrl.split(":")[0];
			String password = userPassUrl.split(":")[1];
			if("zs".equals(userName) && "123456".equals(password)) {
				return "/t.html";
			}
		 }
		 response.setHeader("WWW-Authenticate", "Basic realm=\"Test Authenticate\"");
		 response.setStatus(401);
		 return null;
     }
}
