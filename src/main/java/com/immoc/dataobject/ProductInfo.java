package com.immoc.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author lilin
 * @Title: ProductInfo
 * @ProjectName sell
 *
 * @date 2018/10/20下午10:22
 */
@Entity
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductInfo {

    @Id
    private String productId;

    /**
     * 名字
     */
    private String productName;

    /**
     * 库存
     */
    private Integer productStock;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图
     */
    private String productIcon;

    /**
     * 状态
     * 0正常 1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;


}
