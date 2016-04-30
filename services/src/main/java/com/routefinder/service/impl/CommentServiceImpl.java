package com.routefinder.service.impl;

import com.routefinder.model.Comment;
import com.routefinder.repository.CommentRepository;
import com.routefinder.service.CommentService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class CommentServiceImpl extends GenericServiceImpl<Comment, Integer, CommentRepository>
        implements CommentService{

    @Override
    public List<Comment> findAllOrderByRouteId(Integer id) {
        return repository.findAllOrderByRouteId(id);
    }
    @Override
    public List<Comment> findAllOrderByAccount_Login(String login) {
        return repository.findAllOrderByAccount_Login(login);
    }

    @Override
    public void deleteOrderByRoute_Id(Integer id) {
        repository.deleteOrderByRoute_Id(id);
    }
}
