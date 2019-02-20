package com.immoc.service.impl;

import com.immoc.dataobject.ProductCategory;
import com.immoc.repository.ProductCategoryRepository;
import com.immoc.service.CategoryService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilin
 * @Title: CategoryServiceImpl
 * @ProjectName sell
 *
 * @date 2018/10/20下午10:10
 */
@Service
@Log4j
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findALl() {
        return categoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryIds) {
        return categoryRepository.findByCategoryTypeIn(categoryIds);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return categoryRepository.save(productCategory);
    }
}
