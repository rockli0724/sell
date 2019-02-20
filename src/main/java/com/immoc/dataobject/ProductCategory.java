package com.immoc.dataobject;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author lilin
 * @Title: ProductCategory
 * @ProjectName sell
 * @date 2018/10/20下午8:38
 */
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;
    private String categoryName;
    private Integer categoryType;
    private Date createTime;
    private Date updateTime;

}
