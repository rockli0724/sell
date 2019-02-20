package com.immoc.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author lilin
 * @Title: CategoryTypeEnum
 * @date 2018/10/21下午1:36
 */
@Getter
@AllArgsConstructor
public enum CategoryTypeEnum {

    FRUIT1(1, "水果"),
    SNACK(2, "零食"),
    DRINKING(3, "饮料"),
    RICE_PORRIDGE(4, "粥类"),
    ///
    ;


    private Integer code;
    private String msg;

}
