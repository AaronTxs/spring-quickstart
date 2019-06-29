package aaron.springboot.quickstartspock.service;

/**
 * @author xiecf
 * @title: BizService
 * @projectName quickstart
 * @date 2019/06/28 11:03
 * @description: TODO
 */
public interface BizService {
    String insert(String id, String name, int age);

    String remove(String id);

    String update(String name, int age);

    String finds(String name);

    boolean isAdult(int age) throws Exception;
}
