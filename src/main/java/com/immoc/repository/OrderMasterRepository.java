package com.immoc.repository;

import com.immoc.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author lilin
 * @Title: OrderMasterRepository
 * @date 2018/10/21上午10:41
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid (String buyerOpenid, Pageable pageable);
}
