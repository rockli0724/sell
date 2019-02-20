package com.immoc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lilin
 * @Title: OrderStatusEnum
 * @date 2018/10/21上午10:31
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {
    NEW(0, "新下单"),
    FINISHED(1, "已完结"),
    CANCELED(2, "已取消"),


    ////
    ;

    private Integer code;
    private String msg;

}
