package com.immoc.repository;

import com.immoc.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author lilin
 * @Title: OrderDetailRepository
 * @date 2018/10/21上午10:50
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
