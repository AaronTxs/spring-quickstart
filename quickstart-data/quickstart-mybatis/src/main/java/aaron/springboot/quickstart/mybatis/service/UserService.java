package aaron.springboot.quickstart.mybatis.service;

import aaron.springboot.quickstart.mybatis.mapper.UserMapper;
import aaron.springboot.quickstart.mybatis.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiecf
 * @title: UserService
 * @projectName sping-quickstart
 * @date 2019/05/30 20:19
 * @description: TODO
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Query(int id){
        return userMapper.Query(id);
    }
}
