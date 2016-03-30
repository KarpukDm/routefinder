package com.routefinder.service.impl;

import com.routefinder.model.Feedback;
import com.routefinder.repository.FeedbackRepository;
import com.routefinder.service.FeedbackService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class FeedbackServiceImpl extends GenericServiceImpl<Feedback, Integer, FeedbackRepository>
        implements FeedbackService {
}
