package com.routefinder.service.impl;

import com.routefinder.model.Comment;
import com.routefinder.repository.CommentRepository;
import com.routefinder.service.CommentService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class CommentServiceImpl extends GenericServiceImpl<Comment, Integer, CommentRepository>
        implements CommentService{

}
