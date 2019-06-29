package aaron.springbootmybatisannotation.mapper;

import aaron.springbootmybatisannotation.entity.User;
import aaron.springbootmybatisannotation.enums.Sex;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xiecf
 * @title: UserMapper
 * @projectName spring-boot-data
 * @date 2019/06/13 19:49
 * @description: TODO
 */
public interface UserMapper {
    @Insert("INSERT INTO user(user_name,password,sex) VALUES(#{userName}, #{password}, #{sex})")
    void insert(User user);

    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);

    @Update("UPDATE user SET password=#{password} WHERE id =#{id}")
    void update(User user);

    @Select("select * from user")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "sex", column = "sex", javaType = Sex.class)
    })
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "userName", column = "user_name"),
            @Result(property = "password", column = "password"),
            @Result(property = "sex", column = "sex", javaType = Sex.class)
    })
    User getOne(Long id);
}
