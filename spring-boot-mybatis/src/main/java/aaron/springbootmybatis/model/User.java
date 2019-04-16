package aaron.springbootmybatis.model;

import java.io.Serializable;

import aaron.springbootmybatis.enums.Sex;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User implements Serializable  {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String userName;
	private String passWord;
	private Sex userSex;	 
}
