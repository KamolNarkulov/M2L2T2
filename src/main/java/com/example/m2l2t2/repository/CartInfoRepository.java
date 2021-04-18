package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.CartInfo;
import com.example.m2l2t2.projection.CustomCartInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cartInfo", collectionResourceRel = "cartInfoList", excerptProjection = CustomCartInfo.class)
public interface CartInfoRepository extends JpaRepository<CartInfo, Integer> {


}
