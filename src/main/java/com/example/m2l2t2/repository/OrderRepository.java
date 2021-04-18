package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Order;
import com.example.m2l2t2.projection.CustomOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "order", collectionResourceRel = "orderList", excerptProjection = CustomOrder.class)
public interface OrderRepository extends JpaRepository<Order, Integer> {


}
