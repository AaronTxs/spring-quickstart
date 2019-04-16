package aaron.springbootmybatis.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import aaron.springbootmybatis.enums.*;
import aaron.springbootmybatis.mapper.UserMapper;
import aaron.springbootmybatis.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User(1L,"a", "123456a", Sex.MAN));
		userMapper.insert(new User(2L,"b", "123456b", Sex.WOMAN));
		userMapper.insert(new User(3L,"c", "123456c", Sex.MAN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.getAll();
		for (User user : users) {
			System.out.println(user);	
		}		
		System.out.println(users.toString());
	}
		
	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(1L);
		System.out.println(user.toString());
		user.setUserName("a");
		userMapper.update(user);
		Assert.assertTrue(("a".equals(userMapper.getOne(1L).getUserName())));
	}
}
