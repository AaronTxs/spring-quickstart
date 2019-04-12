package aaron.springbootlombok;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import aaron.springbootlombok.model.User;

@SpringBootTest
public class UserTest {

	@Test
	public void testUser() {
		User user = new User();
		user.setName("aaa");
		user.setAge(18);

		assertEquals(user.getAge(), 18);
		assertEquals(user.getName(), "aaa");
	}
}