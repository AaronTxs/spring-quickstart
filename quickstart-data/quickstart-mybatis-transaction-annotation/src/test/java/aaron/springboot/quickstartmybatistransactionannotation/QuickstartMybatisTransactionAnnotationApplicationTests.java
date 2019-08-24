package aaron.springboot.quickstartmybatistransactionannotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuickstartMybatisTransactionAnnotationApplicationTests {

    @Test
    public void contextLoads() {
    }

    /**
     * 下单
     * 1.创建订单
     * 2.冻结库存
     */
    @Test
    public void testCreateOrder(){

    }

    public void testPayMoney(){

    }
}
