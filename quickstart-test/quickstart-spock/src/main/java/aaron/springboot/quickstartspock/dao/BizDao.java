package aaron.springboot.quickstartspock.dao;

import aaron.springboot.quickstartspock.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiecf
 * @title: BizDao
 * @projectName quickstart
 * @date 2019/06/28 11:05
 * @description: TODO
 */
@Repository
public class BizDao {
    public void insert(PersonEntity bean) {
        System.out.println("Dao insert person");
    }

    public void remove(String id) {
        System.out.println("Dao remove");
    }

    public void update(String name, int age) {
        System.out.println("Dao update");
    }

    public List<PersonEntity> finds(String name) {
        System.out.println("Dao finds");
        PersonEntity bean = new PersonEntity();
        bean.setPersonId("24336461423");
        bean.setPersonName("张三");
        bean.setAge(28);

        return Arrays.asList(bean);
    }
}
