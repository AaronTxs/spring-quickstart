package aaron.springboot.quickstartspock.entity;

import lombok.Data;

/**
 * @author xiecf
 * @title: PersonEntity
 * @projectName quickstart
 * @date 2019/06/28 11:06
 * @description: TODO
 */
@Data
public class PersonEntity {
    private String personId;

    private String personName;

    private int age;
}
