package com.immoc.service;

import com.immoc.dataobject.ProductCategory;

import java.util.List;

/**
 * @author lilin
 * @Title: CategoryService
 * @ProjectName sell
 *
 * @date 2018/10/20下午10:07
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findALl();


    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryIds);

    ProductCategory save(ProductCategory productCategory);
}
