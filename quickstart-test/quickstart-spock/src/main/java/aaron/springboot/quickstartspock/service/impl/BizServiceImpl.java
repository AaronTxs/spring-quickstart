package aaron.springboot.quickstartspock.service.impl;

import aaron.springboot.quickstartspock.dao.BizDao;
import aaron.springboot.quickstartspock.entity.PersonEntity;
import aaron.springboot.quickstartspock.service.BizService;
import aaron.springboot.quickstartspock.uitl.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author xiecf
 * @title: BizServiceImpl
 * @projectName quickstart
 * @date 2019/06/28 11:05
 * @description: TODO
 */
public class BizServiceImpl implements BizService {
    @Autowired
    private BizDao dao;

    public String insert(String id, String name, int age) {

        if (StringUtils.isAnyEmpty(id, name)) {
            return "";
        }

        PersonEntity bean = new PersonEntity();
        bean.setAge(age);
        bean.setPersonId(id);
        bean.setPersonName(name);
        dao.insert(bean);
        return name;

    }

    public String remove(String id) {

        if (StringUtils.isEmpty(id)) {
            return "";
        }

        dao.remove(id);
        return id;
    }

    public String update(String name, int age) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }

        dao.update(name, age);
        return name;
    }

    public String finds(String name) {

        if (StringUtils.isEmpty(name)) {
            return null;
        }

        List<PersonEntity> beans = dao.finds(name);

        StringBuilder sb = new StringBuilder();

        sb.append("#");

        for (PersonEntity bean : beans) {
            sb.append(bean.getAge()).append("#");
        }

        return sb.toString();

    }

    public boolean isAdult(int age) throws Exception {
        if (age < 0) {
            throw new Exception("age is less than zero.");
        }

        return age >= 18;
    }

    public BizDao getDao() {
        return dao;
    }

    public void setDao(BizDao dao) {
        this.dao = dao;
    }
}
