package cn.edu.tju.rico.utils;

import java.util.UUID;

  
/**        
 * Title: 生成UUID    
 */      
public class CodecUtil {
	
	public static String createUUID(){
		return UUID.randomUUID().toString();
	}
}
