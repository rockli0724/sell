package com.immoc.exception;

import com.immoc.common.ResponseUtil;
import com.immoc.dto.ResultDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lilin
 * @Title: SellExceptionHandler
 * @date 2019/3/2下午11:14
 */
@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(value = SellExcepiton.class)
    @ResponseBody
    public ResultDTO handler(SellExcepiton sellExcepiton) {
        return ResponseUtil.error(sellExcepiton.getCode(), sellExcepiton.getMessage(), null);
    }
}
