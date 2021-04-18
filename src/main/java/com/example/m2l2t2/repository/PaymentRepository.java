package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Payment;
import com.example.m2l2t2.projection.CustomPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "payment", collectionResourceRel = "paymentList", excerptProjection = CustomPayment.class)
public interface PaymentRepository extends JpaRepository<Payment, Integer> {


}
