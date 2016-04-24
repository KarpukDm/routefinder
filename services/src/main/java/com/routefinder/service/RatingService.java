package com.routefinder.service;

import com.routefinder.model.Rating;
import com.routefinder.service.common.GenericService;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface RatingService extends GenericService<Rating, Integer> {

    List<Rating> findAllOrderByAccountId(Integer id);

    List<Rating> findAllOrderByRoute_Id(Integer id);

    List<Rating> findAllOrderByAccount_Login(String login);
}
