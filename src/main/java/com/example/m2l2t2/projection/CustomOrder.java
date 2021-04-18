package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Order;
import org.springframework.data.rest.core.config.Projection;


import java.util.Date;

@Projection(types = Order.class)
public interface CustomOrder {

    Integer getId();

    Integer getCustomer();

    Date getDate();

    Integer getCart();
}
