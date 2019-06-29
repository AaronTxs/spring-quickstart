package aaron.springboot.quickstartspock.uitl;

/**
 * @author xiecf
 * @title: StringUtils
 * @projectName quickstart
 * @date 2019/06/28 11:14
 * @description: TODO
 */
public class StringUtils {

    //任意一个为空
    public static boolean isAnyEmpty(String... strings) {
        boolean flag = false;
        if (strings == null) {
            return true;
        }

        for (int i = 0, len = strings.length; i < len; i++) {
            if (isEmpty(strings[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    //不为空
    public static boolean isNotEmpty(String... strings) {
        boolean flag = true;
        if (strings == null) {
            return false;
        }
        for (int i = 0, len = strings.length; i < len; i++) {
            if (isEmpty(strings[i])) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //为空
    public static boolean isEmpty(String text) {
        return isNull(text) || text.length() < 1;
    }

    //为空
    private static boolean isNull(Object object) {
        if (object == null) {
            return true;
        }

        if (object instanceof String && "".equals(((String) object).trim())) {
            return true;
        }

        return false;
    }
}
