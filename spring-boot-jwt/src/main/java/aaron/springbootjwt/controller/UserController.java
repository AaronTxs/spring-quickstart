package aaron.springbootjwt.controller;

import aaron.springbootjwt.annotation.LoginToken;
import aaron.springbootjwt.entity.User;
import aaron.springbootjwt.service.*;

import aaron.springbootjwt.service.UserService;
import com.alibaba.fastjson.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiecf
 * @title: UserController
 * @projectName sping-quickstart
 * @date 2019/06/06 16:17
 * @description: TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    //登录
    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase= userService.findByUserName(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPass_word().equals(user.getPass_word())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @LoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }
}
