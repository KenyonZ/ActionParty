package cn.edu.tju.rico.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

  
/**        
 * Title: Web上下文工具类
 */      
public class WebContextUtil {
	  
	/**     
	 * @description 获取HTTP请求    
	 * @return     
	 */
	public static HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		return request;
	}
}
