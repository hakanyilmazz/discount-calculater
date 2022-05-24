package com.example.demo.util.model;

import com.example.demo.entity.Product;
import com.example.demo.util.DiscountUtil;

public class GoldCardDiscount extends DiscountUtil {
    public GoldCardDiscount(DiscountUtil discountUtil) {
        super(discountUtil);
    }

    @Override
    public double getDiscount(DiscountType discountType, Product product) {
        if (discountType.equals(DiscountUtil.DiscountType.GOLD_CARD)) {
            return product.getPrice() * 0.30;
        } else {
            return nextDiscount.getDiscount(discountType, product);
        }
    }
}
