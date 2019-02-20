package com.immoc.controller;

import com.immoc.common.ResponseUtil;
import com.immoc.convert.OrderFormOrderDTOConvert;
import com.immoc.dto.OrderDTO;
import com.immoc.dto.ResultDTO;
import com.immoc.enums.ResultEnum;
import com.immoc.exception.SellExcepiton;
import com.immoc.form.OrderForm;
import com.immoc.service.BuyerService;
import com.immoc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lilin
 * @Title: BuyerOrderController
 * @date 2018/10/21下午3:58
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    private final OrderService orderService;
    private final BuyerService buyerService;

    @Autowired
    public BuyerOrderController(OrderService orderService, BuyerService buyerService) {
        this.orderService = orderService;
        this.buyerService = buyerService;
    }

    //创建订单
    @PostMapping("/create")
    public ResultDTO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                 BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellExcepiton(ResultEnum.ORDER_UPDATE_FAIL.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFormOrderDTOConvert.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetails())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellExcepiton(ResultEnum.CART_EMPTY);
        }
        OrderDTO creatResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", creatResult.getOrderId());
        return ResponseUtil.success(map);

    }

    //订单列表
    @GetMapping("/list")
    private ResultDTO<List<OrderDTO>> list(@RequestParam("openid") String openId,
                                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openId)) {
            log.error("【查询订单列表】openid 为空");
            throw new SellExcepiton(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openId, request);
        return ResponseUtil.success(orderDTOPage.getContent());


    }

    //订单详情
    @GetMapping("/detail")
    public ResultDTO<OrderDTO> detail(@RequestParam("openid") String openId,
                                      @RequestParam("orderId") String orderId) {
        OrderDTO detailDTO = buyerService.findOrderOne(openId, orderId);
        return ResponseUtil.success(detailDTO);

    }

    //取消订单
    @PostMapping("/cancel")
    public ResultDTO<OrderDTO> cancel(@RequestParam("openid") String openId,
                                      @RequestParam("orderId") String orderId) {
        buyerService.cancelOrderOne(openId, orderId);
        return ResponseUtil.success();

    }

}
