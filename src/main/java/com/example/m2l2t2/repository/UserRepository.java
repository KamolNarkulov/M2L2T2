package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.User;
import com.example.m2l2t2.projection.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "user", collectionResourceRel = "userList", excerptProjection = CustomUser.class)
public interface UserRepository extends JpaRepository<User, Integer> {

}
