package com.routefinder.service;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.model.Rating;
import com.routefinder.service.common.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface RatingService extends GenericService<Rating, Integer> {

    List<Rating> findAllOrderByAccountId(Integer id);

    Rating findOneOrderByRoute_IdAndAccount_Login(Integer id, String login);

    Page<Rating> findLastEvaluations(Pageable pageable, String login);

    List<Rating> findAllOrderByAccount_Login(String login);

    List<Rating> findAllOrderByRoute_Id(Integer id);

    void deleteOrderByRoute_Id(Integer id);
}
