package com.example.m2l2t2.repository;

import com.example.m2l2t2.entity.Comment;
import com.example.m2l2t2.projection.CustomComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "comment", collectionResourceRel = "commentList", excerptProjection = CustomComment.class)
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
