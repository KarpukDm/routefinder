package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Address;
import com.routefinder.service.FeedbackService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class AddressServiceTest extends GenericServiceTest<Address, Integer, FeedbackService> {
    @Override
    protected Address getEntity() {
        return entityGenerator.getFeedbackEntity();
    }
}
