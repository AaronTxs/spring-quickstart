package aaron.springbootjwt.mapper;

import aaron.springbootjwt.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author xiecf
 * @title: UserMapper
 * @projectName sping-quickstart
 * @date 2019/06/11 10:23
 * @description: TODO
 */
@Repository
public interface UserMapper {

    User findByUserName(@Param("user_name") String username);

    User findUserById(@Param("Id") String Id);
}
