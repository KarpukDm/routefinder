package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Feedback;
import com.routefinder.service.FeedbackService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class FeedbackServiceTest extends GenericServiceTest<Feedback, Integer, FeedbackService> {
    @Override
    protected Feedback getEntity() {
        return entityGenerator.getFeedbackEntity();
    }
}
