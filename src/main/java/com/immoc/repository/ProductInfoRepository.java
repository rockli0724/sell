package com.immoc.repository;

import com.immoc.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lilin
 * @Title: ProductInfoRepository
 * @ProjectName sell
 *
 * @date 2018/10/20下午10:26
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
