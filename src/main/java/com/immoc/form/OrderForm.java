package com.immoc.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @author lilin
 * @Title: OrderForm
 * @date 2018/10/21下午4:01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotNull(message = "姓名必填")
    private String name;

    /**
     * 买家电话
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信openID
     */
    @NotEmpty(message = "openId必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
