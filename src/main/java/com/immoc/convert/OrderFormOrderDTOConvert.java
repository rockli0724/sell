package com.immoc.convert;

import com.alibaba.fastjson.JSONObject;
import com.immoc.dataobject.OrderDetail;
import com.immoc.dataobject.OrderMaster;
import com.immoc.dto.OrderDTO;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellExcepiton;
import com.immoc.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author lilin
 * @Title: OrderMaster2OrderDTOConvert
 * @date 2018/10/21下午2:20
 */
@Slf4j
public class OrderFormOrderDTOConvert {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = OrderDTO.builder()
                .buyerName(orderForm.getName())
                .buyerPhone(orderForm.getPhone())
                .buyerAddress(orderForm.getAddress())
                .buyerOpenid(orderForm.getOpenid())
                .build();

        List<OrderDetail> details = null;
        try {
            details = Optional.ofNullable(JSONObject.parseArray(orderForm.getItems(), OrderDetail.class)).orElse(new ArrayList<>());
            orderDTO.setOrderDetails(details);
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellExcepiton(ResultEnum.PARAM_ERROR);
        }
        return orderDTO;
    }

//    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
//        return orderMasters
//                .stream()
//                .map(e -> convert(e))
//                .collect(Collectors.toList());
//    }

}
