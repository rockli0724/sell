package com.immoc.repository;

import com.immoc.dataobject.ProductCategory;
import com.immoc.enums.CategoryTypeEnum;
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
 * @Title: ProductCategoryRepositoryTest
 * @ProjectName sell
 *
 * @date 2018/10/20下午8:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory dto = repository.findOne(1);
        System.out.println(dto);
    }

    @Test
    public void addOneTest() {
        List<ProductCategory> categories = Arrays.asList(
                ProductCategory.builder().categoryType(CategoryTypeEnum.FRUIT1.getCode()).categoryName("水果").build(),
                ProductCategory.builder().categoryType(CategoryTypeEnum.SNACK.getCode()).categoryName("零食").build(),
                ProductCategory.builder().categoryType(CategoryTypeEnum.DRINKING.getCode()).categoryName("饮料").build(),
                ProductCategory.builder().categoryType(CategoryTypeEnum.RICE_PORRIDGE.getCode()).categoryName("粥类").build()
        );
        List<ProductCategory> dto = repository.save(categories);
        System.out.println(dto);
    }

    @Test
    public void updateOneTest() {
        ProductCategory category = repository.findOne(1);
        if (category == null) {
            Assert.assertNotNull(category);
        }
        ProductCategory dto = repository.save(ProductCategory.builder().categoryId(1).categoryName("辣条").categoryType(2).build());
        System.out.println(dto);
    }

    @Test
    public void findByCategoryTypesTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> categories = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, categories.size());
    }


}