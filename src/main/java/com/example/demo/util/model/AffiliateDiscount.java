package com.example.demo.util.model;

import com.example.demo.entity.Product;
import com.example.demo.util.DiscountUtil;

public class AffiliateDiscount extends DiscountUtil {
    public AffiliateDiscount(DiscountUtil discountUtil) {
        super(discountUtil);
    }

    @Override
    public double getDiscount(DiscountType discountType, Product product) {
        if (discountType.equals(DiscountUtil.DiscountType.AFFILIATE)) {
            return product.getPrice() * 0.10;
        } else {
            return nextDiscount.getDiscount(discountType, product);
        }
    }
}