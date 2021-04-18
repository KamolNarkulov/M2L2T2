package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Attachment;
import com.example.m2l2t2.entity.Product;
import org.springframework.data.rest.core.config.Projection;


import java.util.List;

@Projection(types = Product.class)
public interface CustomProduct {

    Integer getId();

    String getName();

    String getDescription();

    Integer getCategory();

    double getPrice();

    List<Attachment> getPhotos();
}
