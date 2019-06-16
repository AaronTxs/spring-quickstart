Spring Boot集成Jpa
===

## 1.引入依赖包
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

## 2.设置数据库配置
```properties
#\u6570\u636E\u5E93\u914D\u7F6E
spring.datasource.url=jdbc:mysql://localhost:3306/springquickstart?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.username=root
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

#JPA\u914D\u7F6E
spring.jpa.properties.hibernate.hbm2ddl.auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.show-sql= true
```

## 3.创建实体
```java
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String userName;

	@Column(nullable = false)
	private String passWord;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = true, unique = true)
	private String nickName;

	@Column
	private Date regTime;

	public User() {
	}

	public User(String userName, String passWord, String email, String nickName, Date regTime) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.nickName = nickName;
		this.regTime = regTime;
	}
	
	//getter and setter方法省略...
}
```

## 4.创建数据访问层
```java
package aaron.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aaron.spring.boot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
```

## 5.进行数据操作
```java
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() throws Exception {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);
		String formattedDate = dateFormat.format(date);

		userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",date));
		userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",date));
		userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",date));

		Assert.assertEquals(3, userRepository.findAll().size());
		Assert.assertEquals("bb", userRepository.findByUserName("bb2").getEmail());
		userRepository.delete(userRepository.findByUserName("aa1"));
	}
}
```
