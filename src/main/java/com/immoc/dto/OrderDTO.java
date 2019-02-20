package com.immoc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.immoc.dataobject.OrderDetail;
import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author lilin
 * @Title: OrderDTO
 * @date 2018/10/21上午11:19
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDTO {

    private String orderId;
    /* 买家电话*/
    private String buyerPhone;
    /* 买家名字*/
    private String buyerName;
    /* 买家地址*/
    private String buyerAddress;
    /* 买家微信id*/
    private String buyerOpenid;
    /* 订单总金额*/
    private BigDecimal orderAmount;
    /* 订单状态 默认0新下单*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /*支付状态，默认0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /*更新时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /*创建时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /*订单详情*/
    private List<OrderDetail> orderDetails;
}


