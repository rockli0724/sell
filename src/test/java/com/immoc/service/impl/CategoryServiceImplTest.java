package com.immoc.service.impl;

import com.immoc.dataobject.ProductCategory;
import com.immoc.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author lilin
 * @Title: CategoryServiceImplTest
 * @ProjectName sell
 *
 * @date 2018/10/20下午10:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findOne() {
        ProductCategory category = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    public void findALl() {
        List<ProductCategory> categories = categoryService.findALl();
        Assert.assertNotEquals(0, categories.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
        Assert.assertNotEquals(0, categories.size());
        Assert.assertNotEquals(0, categories.size());
    }

    @Test
    public void save() {
        ProductCategory category = categoryService.save(ProductCategory.builder().categoryName("情趣").categoryType(3).build());
        Assert.assertNotNull(category);
    }
}