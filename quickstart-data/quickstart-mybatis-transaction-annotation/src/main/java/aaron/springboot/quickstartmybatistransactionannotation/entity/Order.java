package aaron.springboot.quickstartmybatistransactionannotation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Aaron.Tse
 * @title: Order
 * @projectName quickstart
 * @date 2019/7/9 22:11
 * @description: TODO
 */
@Data
@TableName("t_order")
public class Order {
    @TableId
    private String id;

    private String customerId;

    private String productId;

    private BigDecimal price;

    private int number;

    private BigDecimal totalPrice;

    private String status;
}
