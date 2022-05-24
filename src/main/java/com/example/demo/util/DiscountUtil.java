package com.example.demo.util;

import com.example.demo.entity.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DiscountUtil {
    protected DiscountUtil nextDiscount;

    public abstract double getDiscount(DiscountType discountType, Product product);

    public int calculateDiscountWithoutPercentage(Product product) {
        return ((int) product.getPrice() / 200) * 5;
    }

    public enum DiscountType {
        GOLD_CARD,
        SILVER_CARD,
        AFFILIATE,
        MORE_THAN_TWO_YEARS
    }
}
