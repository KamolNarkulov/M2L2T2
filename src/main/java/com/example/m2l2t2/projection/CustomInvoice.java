package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Invoice;
import org.springframework.data.rest.core.config.Projection;


import java.util.Date;

@Projection(types = Invoice.class)
public interface CustomInvoice {

    Integer getId();

    Integer getCustomer();

    Integer getOrder();

    double getPrice();

    Date getCreatedDate();

    Date getDueDate();

    Integer getOrderStatus();
}
