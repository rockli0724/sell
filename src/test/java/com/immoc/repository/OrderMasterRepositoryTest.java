package com.immoc.repository;

import com.immoc.dataobject.OrderMaster;
import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author lilin
 * @Title: OrderMasterRepositoryTest
 * @date 2018/10/21上午10:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMasterRepositoryTest {

    private static String openId = "110121";

    @Autowired
    private OrderMasterRepository repository;


    @Test
    public void saveTest() {

        OrderMaster orderMaster = OrderMaster.builder()
                .orderId("123457")
                .buyerName("大师兄XXX")
                .buyerPhone("13122091271")
                .buyerAddress("慕课网")
                .buyerOpenid("110121")
                .orderAmount(new BigDecimal(2.7))
                .orderStatus(OrderStatusEnum.NEW.getCode())
                .payStatus(PayStatusEnum.WAIT.getCode())
                .build();
        OrderMaster master = repository.save(orderMaster);
        System.out.println(master);


    }


    @Test
    public void findByBuyerOpenid() {
        PageRequest request = new PageRequest(0,1);
        Page<OrderMaster> masters = repository.findByBuyerOpenid(openId,request);
        Assert.assertNotEquals(0,masters.getTotalElements());
    }
}