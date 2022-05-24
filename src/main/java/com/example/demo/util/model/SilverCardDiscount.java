package com.example.demo.util.model;

import com.example.demo.entity.Product;
import com.example.demo.util.DiscountUtil;

public class SilverCardDiscount extends DiscountUtil {
    public SilverCardDiscount(DiscountUtil discountUtil) {
        super(discountUtil);
    }

    @Override
    public double getDiscount(DiscountType discountType, Product product) {
        if (discountType.equals(DiscountUtil.DiscountType.SILVER_CARD)) {
            return product.getPrice() * 0.20;
        } else {
            return nextDiscount.getDiscount(discountType, product);
        }
    }
}