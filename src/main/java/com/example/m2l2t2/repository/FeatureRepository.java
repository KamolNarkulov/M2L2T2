package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Feature;
import com.example.m2l2t2.projection.CustomFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "feature", collectionResourceRel = "featureList", excerptProjection = CustomFeature.class)
public interface FeatureRepository extends JpaRepository<Feature, Integer> {


}
