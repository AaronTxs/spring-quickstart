package aaron.springbootmybatisannotation.entity;

import aaron.springbootmybatisannotation.enums.Sex;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiecf
 * @title: User
 * @projectName spring-boot-data
 * @date 2019/06/13 19:50
 * @description: TODO
 */
@Data
public class User implements Serializable {
    /*
     * 用户Id（主键）
     */
    private Long id;

    /*
     * 用户名
     */
    private String userName;

    /*
     * 密码
     */
    private String password;

    /*
     * 性别
     */
    private Sex sex;

    public User(){}

    public User(String userName, String password, Sex sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }
}
