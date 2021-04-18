package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Detail;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = Detail.class)
public interface CustomDetail {

    Integer getId();

    Integer getProduct();

    Integer getFeature();

    String getValue();
}
