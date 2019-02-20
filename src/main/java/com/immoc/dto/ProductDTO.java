package com.immoc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author lilin
 * @Title: ProductDTO
 * @date 2018/10/21上午12:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoDTO> productInfoDTOS;

}
