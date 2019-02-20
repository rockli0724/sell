package com.immoc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lilin
 * @Title: ResultEnum
 * @date 2018/10/21上午11:38
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
    PARAM_ERROR(1, "参数不正确"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_DETAIL_NOT_EXIST(12, "订单详细不存在"),
    ORDER_STATUS_ERROR(13, "订单状态不正确"),
    ORDER_UPDATE_FAIL(14, "订单更新失败"),
    ORDER_DETAIL_EMPTY(15, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(16, "订单支付状态不正确"),
    ORDER_OWNER_ERROR(17, "该订单不属于当前用户"),
    CART_EMPTY(18, "购物车为空"),
    ORDER_NOT_EXIST(19, "订单不存在"),
    ////
    ;

    private Integer code;
    private String msg;
}
