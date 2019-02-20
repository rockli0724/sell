package com.immoc.repository;

import com.immoc.dataobject.OrderDetail;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lilin
 * @Title: OrderDetailRepositoryTest
 * @date 2018/10/21上午11:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;


    @Test
    public void saveTest(){
        OrderDetail orderDetail = OrderDetail.builder()
                .detailId("1234455")
                .orderId("1234")
                .productIcon("http://xxxjpg")
                .productId("123312")
                .productName("红豆粥啊")
                .productPrice(new BigDecimal(4))
                .productQuantity(20)
                .build();
        OrderDetail detail = repository.save(orderDetail);
        Assert.assertNotNull(detail);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> detail = repository.findByOrderId("1234");
        Assert.assertNotEquals(0,detail.size());
    }
}