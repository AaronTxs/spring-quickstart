package aaron.springbootmybatisannotation.mapper;

import aaron.springbootmybatisannotation.entity.User;
import aaron.springbootmybatisannotation.enums.Sex;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author xiecf
 * @title: UserMapperTest
 * @projectName spring-boot-data
 * @date 2019/06/14 09:46
 * @description: TODO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() throws Exception {
        userMapper.insert(new User("aa1", "123456", Sex.MALE));
        userMapper.insert(new User("bb1", "123456", Sex.FEMALE));
        userMapper.insert(new User("cc1", "123456", Sex.FEMALE));

        Assert.assertEquals(3, userMapper.getAll().size());
    }

    @Test
    public void testDelete() throws Exception {
        List<User> userList = userMapper.getAll();
        System.out.println(userList.toString());

        userMapper.delete(3L);

        List<User> userList2 = userMapper.getAll();
        System.out.println(userList2.toString());
    }

    @Test
    public void testUpdate() throws Exception {
        User user = userMapper.getOne(1L);
        System.out.println(user.toString());

        user.setPassword("abcd1234");
        userMapper.update(user);

        System.out.println(user.toString());
        Assert.assertTrue(("abcd1234".equals(userMapper.getOne(1L).getPassword())));
    }

    @Test
    public void testQuery() throws Exception {
        List<User> users = userMapper.getAll();
        System.out.println(users.toString());
    }

    @Test
    public void testQueryOne() throws Exception {
        User user = userMapper.getOne(1L);
        System.out.println(user);
        Assert.assertEquals("aa1", user.getUserName());
    }
}
