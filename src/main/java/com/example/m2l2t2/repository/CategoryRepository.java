package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Category;
import com.example.m2l2t2.projection.CustomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "category", collectionResourceRel = "categoryList", excerptProjection = CustomCategory.class)
public interface CategoryRepository extends JpaRepository<Category, Integer> {


}
