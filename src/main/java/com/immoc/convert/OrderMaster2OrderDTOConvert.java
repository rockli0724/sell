package com.immoc.convert;

import com.immoc.dataobject.OrderMaster;
import com.immoc.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lilin
 * @Title: OrderMaster2OrderDTOConvert
 * @date 2018/10/21下午2:20
 */
public class OrderMaster2OrderDTOConvert {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        return orderMasters
                .stream()
                .map(e -> convert(e))
                .collect(Collectors.toList());
    }

}
