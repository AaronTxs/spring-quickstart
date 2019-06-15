package aaron.springbootmybatis.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author xiecf
 * @title: user
 * @projectName sping-quickstart
 * @date 2019/05/30 20:12
 * @description: TODO
 */
@Data
public class User {
    private Integer id;
    private String email;
    private String nick_name;
    private String pass_word;
    private Date reg_time;
    private String user_name;
}
