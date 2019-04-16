package aaron.springbootmybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.*;

import aaron.springbootmybatis.enums.Sex;
import aaron.springbootmybatis.model.User;

public interface UserMapper {
	@Select("SELECT * FROM users")
	@Results({ @Result(property = "userSex", column = "user_sex", javaType = Sex.class) })
	List<User> getAll();

	@Select("SELECT * FROM users WHERE id = #{id}")
	@Results({ @Result(property = "userSex", column = "user_sex", javaType = Sex.class) })
	User getOne(Long id);

	@Insert("INSERT INTO users(userName,passWord,user_sex) VALUES(#{userName}, #{passWord}, #{userSex})")
	void insert(User user);

	@Update("UPDATE users SET userName=#{userName} WHERE id =#{id}")
	void update(User user);

	@Delete("DELETE FROM users WHERE id =#{id}")
	void delete(Long id);
}
