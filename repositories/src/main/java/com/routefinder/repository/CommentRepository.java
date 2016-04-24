package com.routefinder.repository;


import com.routefinder.model.Comment;
import com.routefinder.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findAllOrderByRouteId(Integer id);

    List<Comment> findAllOrderByAccount_Login(String login);
}
