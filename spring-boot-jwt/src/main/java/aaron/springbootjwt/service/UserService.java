package aaron.springbootjwt.service;

import aaron.springbootjwt.entity.User;
import aaron.springbootjwt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiecf
 * @title: UserService
 * @projectName sping-quickstart
 * @date 2019/06/11 10:24
 * @description: TODO
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User findByUserName(User user){
        return userMapper.findByUserName(user.getUser_Name());
    }

    public User findUserById(String userId) {

        return userMapper.findUserById(userId);
    }
}
