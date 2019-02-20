package com.immoc.service.impl;

import com.immoc.dto.OrderDTO;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellExcepiton;
import com.immoc.service.BuyerService;
import com.immoc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lilin
 * @Title: BuyerServiceImpl
 * @date 2018/10/21下午6:49
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    private final OrderService orderService;

    @Autowired
    public BuyerServiceImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid 不一致, openid={},orderDt{}", openid, orderDTO);
            throw new SellExcepiton(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrderOne(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查询不到该订单, orderId={}", orderId);
            throw new SellExcepiton(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderDTO;
    }
}
