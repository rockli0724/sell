package com.immoc.service.impl;

import com.immoc.dataobject.ProductInfo;
import com.immoc.enums.ProductStatusEnum;
import com.immoc.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lilin
 * @Title: ProductServiceImplTest
 * @date 2018/10/20下午11:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductService service;

    @Test
    public void findOne() {
        ProductInfo productInfo = service.findOne("123456");
        Assert.assertEquals("123456", productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfos = service.findUpAll();
        Assert.assertNotEquals(0,productInfos.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> infos = service.findAll(request);
        System.out.println(infos.getTotalElements());
    }

    @Test
    public void save() {
        Integer num = (int)(Math.random() * 100 + 1);
        ProductInfo productInfo = ProductInfo.builder()
                .productId("12357")
                .productName(String.format("瘦肉粉%s元", num))
                .productPrice(new BigDecimal(num))
                .productStock(100)
                .productDescription("超好吃的哈哈哈哈")
                .productIcon("http://xxx.jpg")
                .productStatus(ProductStatusEnum.DOWN.getCode())
                .categoryType(2)
                .build();
        ProductInfo info = service.save(productInfo);
        System.out.println(info);

    }
}