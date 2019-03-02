package com.immoc.common;

import com.immoc.dto.ResultDTO;
import com.immoc.enums.ResultEnum;

/**
 * @author lilin
 * @Title: ResponseUtil
 * @date 2018/10/21上午1:17
 */
public class ResponseUtil {

    public static final Integer SUCCESS = 0;
    public static final Integer FAIL = 1;
    public static final String SUCCESS_MSG = "success";
    public static final String FAIL_MSG = "fail";

    /**
     * 成功-带data
     *
     * @param object
     * @return
     */
    public static ResultDTO success(Object object) {
        return ResultDTO.builder()
                .code(SUCCESS)
                .msg(SUCCESS_MSG)
                .data(object)
                .build();
    }

    /**
     * 成功-不带data
     *
     * @return
     */
    public static ResultDTO success() {
        return success(null);
    }


    /**
     * 失败-带data
     *
     * @param errorData
     * @return
     */
    public static ResultDTO error(Object errorData) {
        return ResultDTO.builder()
                .code(FAIL)
                .msg(FAIL_MSG)
                .data(errorData)
                .build();
    }


    /**
     * 失败-不带data
     *
     * @return
     */
    public static ResultDTO error() {
        return ResultDTO.builder().code(FAIL).msg(FAIL_MSG).build();
    }

    /**
     * 失败-带失败返回码
     *
     * @param resultEnum
     * @return
     */
    public static ResultDTO error(ResultEnum resultEnum, Object object) {
        return error(resultEnum.getCode(), resultEnum.getMsg(), object);
    }

    /**
     * 失败-带失败返回码
     *
     * @param resultEnum
     * @return
     */
    public static ResultDTO error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg(), null);
    }

    public static ResultDTO error(int code, String msg, Object object) {
        return ResultDTO.builder().code(code)
                .msg(msg).data(object).build();
    }

}
