package com.example.demo.repository;

import com.example.demo.entity.Product;
import com.example.demo.util.DiscountUtil;
import com.example.demo.util.model.AffiliateDiscount;
import com.example.demo.util.model.GoldCardDiscount;
import com.example.demo.util.model.MoreThanTwoYearsDiscount;
import com.example.demo.util.model.SilverCardDiscount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class DiscountRepository {

    private final List<Product> products;
    private final DiscountUtil discountUtil;

    public DiscountRepository() {
        products = new ArrayList<>();

        products.add(new Product("Computer", 5000.0));
        products.add(new Product("Phone", 500.0));
        products.add(new Product("Book", 50.0));

        discountUtil = new GoldCardDiscount(
                new SilverCardDiscount(
                        new AffiliateDiscount(
                                new MoreThanTwoYearsDiscount(null)
                        )
                )
        );
    }

    public double getDiscount(DiscountUtil.DiscountType type, Product product) {
        assignPriceToProduct(product);

        double netPrice = product.getPrice();

        if (product.getName().equalsIgnoreCase("Phone")) {
            return netPrice;
        }

        double discount = discountUtil.getDiscount(type, product);
        return netPrice - discount;
    }

    private void assignPriceToProduct(Product product) {
        product.setPrice(getPriceByProduct(product));

        int discountWithoutPercentage = discountUtil.calculateDiscountWithoutPercentage(product);
        double netPriceWithoutPercentage = product.getPrice() - discountWithoutPercentage;
        product.setPrice(netPriceWithoutPercentage);
    }

    /**
     * @throws NoSuchElementException exception if not exist product
     */
    private double getPriceByProduct(Product product) {
        Product productFromDatabase = products.stream().filter(o -> o.getName().equalsIgnoreCase(product.getName().trim()))
                .findFirst()
                .orElseThrow();

        return productFromDatabase.getPrice();
    }
}
