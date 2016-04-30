package com.routefinder.service.impl;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.repository.FavoriteRouteRepository;
import com.routefinder.service.FavoriteRouteService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class FavoriteRouteServiceImpl extends GenericServiceImpl<FavoriteRoute, Integer, FavoriteRouteRepository>
        implements FavoriteRouteService{
    @Override
    public List<FavoriteRoute> findAllOrderByAccount_Login(String login) {
        return repository.findAllOrderByAccount_Login(login);
    }
/*
    @Override
    public void deleteOrderByAccount_Id() {
        repository.deleteOrderByAccount_Id();
    }

    @Override
    public void deleteOrderByRoute_Id() {
        repository.deleteOrderByRoute_Id();
    }*/

    @Override
    public FavoriteRoute findOneOrderByAccount_IdAndRoute_Id(Integer account_Id, Integer route_Id) {
        return repository.findOneOrderByAccount_IdAndRoute_Id(account_Id, route_Id);
    }
}
