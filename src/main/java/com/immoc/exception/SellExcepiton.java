package com.immoc.exception;

import com.immoc.enums.IEcode;
import com.immoc.enums.ResultEnum;

/**
 * @author lilin
 * @Title: SellExcepiton
 * @date 2018/10/21上午11:36
 */
public class SellExcepiton extends RuntimeException {

    private Integer code;

    public SellExcepiton(IEcode iEcode) {
        super(iEcode.getMsg());
        this.code = iEcode.getCode();
    }

    public SellExcepiton(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public SellExcepiton(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public SellExcepiton setCode(Integer code) {
        this.code = code;
        return this;
    }
}
