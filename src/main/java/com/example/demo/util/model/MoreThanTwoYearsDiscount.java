package com.example.demo.util.model;

import com.example.demo.entity.Product;
import com.example.demo.util.DiscountUtil;

public class MoreThanTwoYearsDiscount extends DiscountUtil {
    public MoreThanTwoYearsDiscount(DiscountUtil discountUtil) {
        super(discountUtil);
    }

    @Override
    public double getDiscount(DiscountType discountType, Product product) {
        if (discountType.equals(DiscountUtil.DiscountType.MORE_THAN_TWO_YEARS)) {
            return product.getPrice() * 0.5;
        } else {
            return nextDiscount.getDiscount(discountType, product);
        }
    }
}