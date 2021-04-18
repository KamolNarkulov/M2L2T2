package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Invoice;
import com.example.m2l2t2.projection.CustomInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "invoice", collectionResourceRel = "invoiceList", excerptProjection = CustomInvoice.class)
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
