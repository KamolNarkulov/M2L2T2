package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Blog;
import com.example.m2l2t2.projection.CustomBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "blog", collectionResourceRel = "blogList", excerptProjection = CustomBlog.class)
public interface BlogRepository extends JpaRepository<Blog, Integer> {


}
