package aaron.springbootjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiecf
 * @title: User
 * @projectName sping-quickstart
 * @date 2019/06/06 15:34
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  String Id;
    private String User_Name;
    private String Pass_word;
}
