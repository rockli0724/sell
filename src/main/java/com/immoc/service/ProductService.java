package com.immoc.service;

import com.immoc.dataobject.ProductInfo;
import com.immoc.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author lilin
 * @Title: ProductService
 * @date 2018/10/20下午10:55
 */
public interface ProductService {

    /**
     * 查询单个商品
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     *
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 分页查询商品
     *
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     */
    void increaseStock(List<CartDTO> cartDTOS);

    /**
     * 减库存
     */
    void decreaseStock(List<CartDTO> cartDTOS);

}
