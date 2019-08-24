package aaron.springboot.quickstartmybatistransactionannotation.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Aaron.Tse
 * @title: UserAccount
 * @projectName quickstart
 * @date 2019/7/9 22:08
 * @description: 资金账户
 */
@Data
@TableName("t_useraccount")
public class UserAccount {

    @TableId
    private String id;

    /**
     * 用户ID
     */
    private String customerId;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 可用金额
     */
    private BigDecimal usableAmount;

    /**
     * 冻结金额
     */
    private BigDecimal frozenAmount;
}
