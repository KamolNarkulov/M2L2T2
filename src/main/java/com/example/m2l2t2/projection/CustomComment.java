package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Comment;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(types = Comment.class)
public interface CustomComment {

    Integer getId();

    Integer getCustomer();

    String getMessage();

    Date getDate();

    double getMark();

    Integer getProduct();

}
