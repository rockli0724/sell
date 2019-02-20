package com.immoc.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author lilin
 * @Title: ResultDTO
 * @date 2018/10/21上午12:22
 */
@Data
@Builder
public class ResultDTO<T> {

    private Integer code;
    private String msg;
    private T data;
}
