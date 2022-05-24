package com.example.demo.controller;

import com.example.demo.entity.DiscountRequest;
import com.example.demo.entity.DiscountResponse;
import com.example.demo.service.DiscountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("/calculateDiscount")
    public DiscountResponse calculateDiscount(@RequestBody DiscountRequest discountRequest) {
        return discountService.calculateDiscount(discountRequest);
    }
}
