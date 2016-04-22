package com.routefinder.service.impl;

import com.routefinder.model.Rating;
import com.routefinder.repository.RatingRepository;
import com.routefinder.service.RatingService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class RatingServiceImpl extends GenericServiceImpl<Rating, Integer, RatingRepository>
        implements RatingService{

    @Override
    public List<Rating> findAllOrderByAccountId(Integer id) {
        return repository.findAllOrderByAccountId(id);
    }
}
