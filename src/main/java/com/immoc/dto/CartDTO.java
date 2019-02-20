package com.immoc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 购物车
 * @author lilin
 * @Title: CartDTO
 * @date 2018/10/21下午12:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private String productId;

    private Integer productQuantity;
}
