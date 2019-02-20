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
public enum PayStatusEnum {
    WAIT(0,"未支付"),
    SUCCESS(1,"支付成功"),
    

    ////
    ;

    private Integer code;
    private String msg;

}
