package aaron.springbootmybatis.mapper;

import aaron.springbootmybatis.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author xiecf
 * @title: UserMapper
 * @projectName sping-quickstart
 * @date 2019/05/30 20:19
 * @description: TODO
 */
@Repository
public interface UserMapper {
    User Query(int id);
}
