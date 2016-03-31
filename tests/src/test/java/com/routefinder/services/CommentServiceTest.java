package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Comment;
import com.routefinder.service.CommentService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class CommentServiceTest extends GenericServiceTest<Comment, Integer, CommentService> {
    @Override
    protected Comment getEntity() {
        return entityGenerator.getCommentEntity();
    }
}
