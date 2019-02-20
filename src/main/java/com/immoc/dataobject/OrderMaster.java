package com.immoc.dataobject;

import com.immoc.enums.OrderStatusEnum;
import com.immoc.enums.PayStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lilin
 * @Title: OrderDTO
 * @date 2018/10/21上午10:21
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@DynamicUpdate
public class OrderMaster {


    /*'订单ID'.*/
    @Id
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
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;


}
