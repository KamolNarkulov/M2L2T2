package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.CartInfo;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = CartInfo.class)
public interface CustomCartInfo {

    Integer getId();

    Integer getProduct();

    Integer getCart();

    double getQty();
}
