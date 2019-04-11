package aaron.springbootlombok;

import static org.junit.Assert.assertEquals;

import aaron.springbootlombok.model.User;

public class UserTest {

	public void testUser() {
		User user=new User();
		user.setName("aaa");
		user.setAge(18);
		
		assertEquals(user.getAge(), 18);
	}
}
