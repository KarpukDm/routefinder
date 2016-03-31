package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Rating;
import com.routefinder.service.RatingService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class RatingServiceTest extends GenericServiceTest<Rating, Integer, RatingService> {
    @Override
    protected Rating getEntity() {
        return entityGenerator.getRatingEntity();
    }
}
