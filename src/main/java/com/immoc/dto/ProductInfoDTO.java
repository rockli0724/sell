package com.immoc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 商品详情
 *
 * @author lilin
 * @Title: ProductInfo
 * @ProjectName sell
 * @date 2018/10/20下午10:22
 */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductInfoDTO {

    @JsonProperty("id")
    private String productId;

    /**
     * 名字
     */
    @JsonProperty("name")
    private String productName;


    /**
     * 单价
     */
    @JsonProperty("price")
    private BigDecimal productPrice;

    /**
     * 描述
     */
    @JsonProperty("description")
    private String productDescription;

    /**
     * 小图
     */
    @JsonProperty("icon")
    private String productIcon;


}
