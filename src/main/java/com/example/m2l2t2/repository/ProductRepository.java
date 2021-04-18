package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Product;
import com.example.m2l2t2.projection.CustomProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(path = "product" , collectionResourceRel = "productList", excerptProjection = CustomProduct.class)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @RestResource(path = "byPrice")
    //@RequestMapping(value = "/byPrice", method = RequestMethod.GET)
    Page<Product> findAllByPrice(@Param("price") double price , Pageable pageable);
}
