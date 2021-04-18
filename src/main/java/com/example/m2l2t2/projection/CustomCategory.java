package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Category;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();

    String getDescription();

    Integer getParentCategory();

    Integer getPhoto();

}
