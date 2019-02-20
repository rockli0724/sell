package com.immoc.common;

import com.immoc.dto.ResultDTO;

/**
 * @author lilin
 * @Title: ResponseUtil
 * @date 2018/10/21上午1:17
 */
public class ResponseUtil {

    public static ResultDTO success(Object object) {
        return ResultDTO.builder()
                .code(0)
                .msg("成功")
                .data(object)
                .build();
    }

    public static ResultDTO success() {
        return success(null);
    }

    public static ResultDTO error(Object object) {
        return ResultDTO.builder()
                .code(1)
                .msg("失败")
                .data(object)
                .build();
    }

    public static ResultDTO error() {
        return error(null);
    }


}
