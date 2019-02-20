package com.immoc.service.impl;

import com.immoc.dataobject.OrderDetail;
import com.immoc.dto.OrderDTO;
import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
import com.immoc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @author lilin
 * @Title: OrderServiceImplTest
 * @date 2018/10/21下午12:42
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    private final String buyerOpenid = "110110";
    private final String orderId = "1540101954801630031";

    @Autowired
    private OrderService orderService;

    @Test
    public void create() {
        OrderDTO orderDTO = OrderDTO.builder()
                .buyerName("李林")
                .buyerAddress("保安西乡碧海湾花园小区")
                .buyerPhone("13122091271")
                .buyerOpenid(buyerOpenid)
                .build();
        //购物车
        orderDTO.setOrderDetails(Arrays.asList(
                OrderDetail.builder()
                        .productId("1540101727374995424")
                        .productQuantity(1)
                        .build(),
                OrderDetail.builder()
                        .productId("1540101727375205670")
                        .productQuantity(3)
                        .build()));

        OrderDTO orderDTO1 = orderService.create(orderDTO);
        log.info("【创建订单】result:{}", orderDTO1);
    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        log.info("【查询单个订单】,result={}", orderDTO);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> dtoPage = orderService.findList(buyerOpenid, request);
        log.info("【分页查询订单列表】result={}", dtoPage);

    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCELED, result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED, result.getOrderStatus());
    }

    @Test
    public void pay() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.pay(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS, result.getPayStatus());
    }
}