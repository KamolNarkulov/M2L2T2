package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Cart;
import org.springframework.data.rest.core.config.Projection;


import java.util.Date;

@Projection(types = Cart.class)
public interface CustomCart {

    Integer getId();

    Integer getCustomer();

    Date getCreatedDate();

}
