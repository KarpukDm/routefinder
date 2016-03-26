package com.routefinder.repository;

import com.routefinder.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
