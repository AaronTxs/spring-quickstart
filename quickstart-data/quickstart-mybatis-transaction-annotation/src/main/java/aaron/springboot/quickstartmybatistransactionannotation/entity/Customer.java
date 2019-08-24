package aaron.springboot.quickstartmybatistransactionannotation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Aaron.Tse
 * @title: Customer
 * @projectName quickstart
 * @date 2019/7/9 22:00
 * @description: TODO
 */
@Data
@TableName("t_customer")
public class Customer {
    @TableId
    private String id;

    private String nickName;
}
