package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Feature;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = Feature.class)
public interface CustomFeature {

    Integer getId();

    String getName();

    String getType();

    Integer getCategory();

}
