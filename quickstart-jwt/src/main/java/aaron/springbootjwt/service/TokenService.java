package aaron.springbootjwt.service;

import aaron.springbootjwt.entity.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

/**
 * @author xiecf
 * @title: TokenService
 * @projectName sping-quickstart
 * @date 2019/06/06 16:20
 * @description: TODO
 */
@Service
public class TokenService {

    //生成Token
    public String getToken(User user){
        String token= JWT.create()
                .withAudience(user.getId())
                .sign(Algorithm.HMAC256(user.getPass_word()));
        return token;
    }
}
