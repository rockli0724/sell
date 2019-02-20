package com.immoc;

import com.immoc.dataobject.ProductCategory;
import com.immoc.repository.ProductCategoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellApplicationTests {

//    @Autowired
//    private ProductCategoryRepository repository;

    @Test
    public void test() {
//        ProductCategory category =  repository.findOne(1);
        System.out.println(1);
    }

}
