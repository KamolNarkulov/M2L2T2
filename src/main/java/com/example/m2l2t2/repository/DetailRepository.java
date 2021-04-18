package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Detail;
import com.example.m2l2t2.projection.CustomDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "detail", collectionResourceRel = "detailList", excerptProjection = CustomDetail.class)
public interface DetailRepository extends JpaRepository<Detail, Integer> {


}
