package com.routefinder.service;

import com.routefinder.model.Comment;
import com.routefinder.service.common.GenericService;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface CommentService extends GenericService<Comment, Integer> {

    List<Comment> findAllOrderByRouteId(Integer id);

    List<Comment> findAllOrderByAccount_Login(String login);
}
