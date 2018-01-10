package cn.edu.tju.rico.authorization;

/**        
 * Title: REST 鉴权   
 * Description: 登录用户的身份鉴权
 */      
public interface TokenManager {

	String createToken(String username);  

    boolean checkToken(String token); 
    
    void deleteToken(String token);
}
