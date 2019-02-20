package com.immoc.repository;

import com.immoc.common.KeyUtil;
import com.immoc.dataobject.ProductInfo;
import com.immoc.enums.CategoryTypeEnum;
import com.immoc.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author lilin
 * @Title: ProductInfoRepositoryTest
 * @ProjectName sell
 *
 * @date 2018/10/20下午10:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest() {

        List<ProductInfo> productInfos = Arrays.asList(
                ProductInfo.builder()
                        .productId(KeyUtil.getUniqueKey())
                        .productName("皮蛋粥")
                        .productPrice(new BigDecimal(3.2))
                        .productStock(100)
                        .productDescription("超好吃")
                        .productIcon("http://xxx.jpg")
                        .productStatus(ProductStatusEnum.UP.getCode())
                        .categoryType(CategoryTypeEnum.RICE_PORRIDGE.getCode())
                        .build(),
                ProductInfo.builder()
                        .productId(KeyUtil.getUniqueKey())
                        .productName("芒果冰")
                        .productPrice(new BigDecimal(20))
                        .productStock(100)
                        .productDescription("超好吃")
                        .productIcon("http://xxx.jpg")
                        .productStatus(ProductStatusEnum.UP.getCode())
                        .categoryType(CategoryTypeEnum.DRINKING.getCode())
                        .build(),
                ProductInfo.builder()
                        .productId(KeyUtil.getUniqueKey())
                        .productName("皮皮虾")
                        .productPrice(new BigDecimal(3.25))
                        .productStock(100)
                        .productDescription("超好吃")
                        .productIcon("http://xxx.jpg")
                        .productStatus(ProductStatusEnum.UP.getCode())
                        .categoryType(CategoryTypeEnum.SNACK.getCode())
                        .build()
        );
        List<ProductInfo> result = repository.save(productInfos);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() {
        List<ProductInfo> result = repository.findByProductStatus(ProductStatusEnum.UP.getCode());
        Assert.assertNotEquals(0, result.size());

    }
}