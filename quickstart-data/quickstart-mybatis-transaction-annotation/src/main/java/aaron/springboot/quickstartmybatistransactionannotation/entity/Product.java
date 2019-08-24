package aaron.springboot.quickstartmybatistransactionannotation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Aaron.Tse
 * @title: Product
 * @projectName quickstart
 * @date 2019/7/9 22:04
 * @description: TODO
 */
@Data
@TableName("t_product")
public class Product {
    @TableId
    private String id;

    private String name;

    private String price;
}
