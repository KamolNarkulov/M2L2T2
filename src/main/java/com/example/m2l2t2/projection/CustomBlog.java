package com.example.m2l2t2.projection;

import com.example.m2l2t2.entity.Attachment;
import com.example.m2l2t2.entity.Blog;
import org.springframework.data.rest.core.config.Projection;


import java.util.List;

@Projection(types = Blog.class)
public interface CustomBlog {

    Integer getId();

    String getTitle();

    String getBody();

    List<Attachment> getPhotos();

}
