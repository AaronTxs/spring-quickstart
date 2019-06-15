package aaron.springbootmybatis.controller;

import aaron.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiecf
 * @title: UserController
 * @projectName sping-quickstart
 * @date 2019/05/30 20:17
 * @description: TODO
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }
}
