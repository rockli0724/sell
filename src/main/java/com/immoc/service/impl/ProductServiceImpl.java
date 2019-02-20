package com.immoc.service.impl;

import com.immoc.dataobject.ProductInfo;
import com.immoc.dto.CartDTO;
import com.immoc.enums.ProductStatusEnum;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellExcepiton;
import com.immoc.repository.ProductInfoRepository;
import com.immoc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lilin
 * @Title: ProductServiceImpl
 * @date 2018/10/20下午11:02
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductInfoRepository repository;

    @Autowired
    public ProductServiceImpl(ProductInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO : cartDTOS) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellExcepiton(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOS) {
        for (CartDTO cartDTO : cartDTOS) {
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellExcepiton(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellExcepiton(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }

    }
}
