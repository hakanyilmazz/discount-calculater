package com.example.demo.entity;

import com.example.demo.util.DiscountUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DiscountRequest {

    private Product product;
    private DiscountUtil.DiscountType discountType;

}
