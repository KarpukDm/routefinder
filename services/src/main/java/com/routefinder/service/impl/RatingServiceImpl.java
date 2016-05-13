package com.routefinder.service.impl;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.model.Rating;
import com.routefinder.repository.RatingRepository;
import com.routefinder.service.RatingService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Rating findOneOrderByRoute_IdAndAccount_Login(Integer id, String login) {
        return repository.findOneOrderByRoute_IdAndAccount_Login(id, login);
    }

    @Override
    public Page<Rating> findLastEvaluations(Pageable pageable, String login) {
        return repository.findAllOrderByAccount_Login(pageable, login);
    }

    @Override
    public List<Rating> findAllOrderByAccount_Login(String login) {
        return repository.findAllOrderByAccount_Login(login);
    }

    @Override
    public List<Rating> findAllOrderByRoute_Id(Integer id) {
        return repository.findAllOrderByRoute_Id(id);
    }

    @Override
    public void deleteOrderByRoute_Id(Integer id) {
        repository.deleteOrderByRoute_Id(id);
    }
}
