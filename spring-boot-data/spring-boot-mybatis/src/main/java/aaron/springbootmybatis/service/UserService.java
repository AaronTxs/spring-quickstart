package aaron.springbootmybatis.service;

import aaron.springbootmybatis.entity.User;
import aaron.springbootmybatis.mapper.UserMapper;
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
