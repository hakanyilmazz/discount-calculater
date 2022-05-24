package com.example.demo.service;

import com.example.demo.entity.DiscountRequest;
import com.example.demo.entity.DiscountResponse;
import com.example.demo.repository.DiscountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;

    public DiscountResponse calculateDiscount(DiscountRequest discountRequest) {
        try {
            double netPrice = discountRepository.getDiscount(discountRequest.getDiscountType(), discountRequest.getProduct());
            return new DiscountResponse(netPrice);
        } catch (NoSuchElementException exception) {
            throw new RuntimeException("This product name is not exist!");
        }
    }
}
