package com.immoc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author lilin
 * @Title: OrderDTO
 * @date 2018/10/21上午10:21
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderDetailDTO {

    private String detailId;
    /*'订单ID'.*/
    private String orderId;
    /* 商品ID*/
    private String productId;
    /* 商品名字*/
    private String productName;
    /* 商品单价*/
    private BigDecimal productPrice;
    /* 商品数量*/
    private Integer productQuantity;
    /*商品小图*/
    private String productIcon;
//    /*创建时间*/
//    private Date createTime;
//
//    /*更新时间*/
//    private Date updateTime;


}
