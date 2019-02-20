package com.immoc.repository;

import com.immoc.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lilin
 * @Title: ProductCategoryRepository
 * @ProjectName sell
 *
 * @date 2018/10/20下午8:39
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> ategoryTypeList);
}
