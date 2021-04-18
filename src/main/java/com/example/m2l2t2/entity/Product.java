package com.example.m2l2t2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @ManyToOne
    private Category category;

    private double price;

    @OneToMany
    private List<Attachment> photos;        // 1ta productni rasmlari ko'p bo'lishi mumkin



}
