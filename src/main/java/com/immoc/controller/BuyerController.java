package com.immoc.controller;

import com.immoc.common.ResponseUtil;
import com.immoc.dataobject.ProductCategory;
import com.immoc.dataobject.ProductInfo;
import com.immoc.dto.ProductDTO;
import com.immoc.dto.ProductInfoDTO;
import com.immoc.dto.ResultDTO;
import com.immoc.service.CategoryService;
import com.immoc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lilin
 * @Title: BuyerController
 * @date 2018/10/21上午12:19
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public BuyerController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("list")
    public ResultDTO list() {
        //1.查询所有上架商品
        List<ProductInfo> productInfos = productService.findUpAll();

        //2.查询类目（一次性查询）
        List<Integer> categoryTypeList = productInfos
                .stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> categories = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼接
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (ProductCategory category : categories) {
            ProductDTO dto = ProductDTO.builder()
                    .categoryType(category.getCategoryType())
                    .categoryName(category.getCategoryName()).build();

            List<ProductInfoDTO> productInfoDTOS = new ArrayList<>();
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getCategoryType().equals(category.getCategoryType())) {
                    ProductInfoDTO infoDTO = new ProductInfoDTO();
                    BeanUtils.copyProperties(productInfo, infoDTO);
                    productInfoDTOS.add(infoDTO);
                }
            }
            dto.setProductInfoDTOS(productInfoDTOS);
            productDTOs.add(dto);
        }

        return ResponseUtil.success(productDTOs);
    }

}
