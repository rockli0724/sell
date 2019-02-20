package com.immoc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lilin
 * @Title: ProductStatusEnum
 * @date 2018/10/20下午11:05
 */
@Getter
@AllArgsConstructor
public enum ProductStatusEnum {
    UP(0, "在架"), DOWN(1, "下架"),

    ////
    ;

    private Integer code;
    private String msg;

}
