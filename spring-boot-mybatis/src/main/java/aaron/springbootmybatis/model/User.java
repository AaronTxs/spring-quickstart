package aaron.springbootmybatis.model;

import aaron.springbootmybatis.enums.UserSexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User  {
	private Long id;
	private String userName;
	private String passWord;
	private UserSexEnum userSex;	 
}
