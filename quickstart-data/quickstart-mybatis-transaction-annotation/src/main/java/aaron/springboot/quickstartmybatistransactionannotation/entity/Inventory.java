package aaron.springboot.quickstartmybatistransactionannotation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Aaron.Tse
 * @title: Inventory
 * @projectName quickstart
 * @date 2019/7/9 22:14
 * @description: 库存
 */
@Data
@TableName("t_inventory")
public class Inventory {
    @TableId
    private String id;

    /**
     * 商品Id
     */
    private String productId;

    /**
     * 库存数量
     */
    private Integer amount;
}
