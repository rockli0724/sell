package com.immoc.service;

import com.immoc.dto.OrderDTO;

/**
 * @author lilin
 * @Title: BuyerService
 * @date 2018/10/21下午6:47
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrderOne(String openid, String orderId);
}
