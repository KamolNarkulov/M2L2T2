package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Cart;
import com.example.m2l2t2.projection.CustomCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "cart", collectionResourceRel = "cartList", excerptProjection = CustomCart.class)
public interface CartRepository extends JpaRepository<Cart, Integer> {


}
