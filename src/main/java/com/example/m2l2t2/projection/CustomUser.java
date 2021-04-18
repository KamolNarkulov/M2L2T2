package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Attachment;
import com.example.m2l2t2.entity.User;
import org.springframework.data.rest.core.config.Projection;


@Projection(types = User.class)
public interface CustomUser {

    Integer getId();

    String getFirstname();

    String getLastname();

    String getEmail();

    String getPhoneNumber();

    Attachment getPhoto();
}
