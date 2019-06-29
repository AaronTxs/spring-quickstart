package aaron.spring.boot.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aaron.spring.boot.web.models.User;

@RestController
public class HelloController {

	@RequestMapping("/getUser")
	public User getUser() {
		User user=new User();
    	user.setUserName("小明");
    	user.setPassWord("xxxxaaa");
        return user;
	}
}
