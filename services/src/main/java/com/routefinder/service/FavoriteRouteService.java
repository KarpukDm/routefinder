package com.routefinder.service;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.service.common.GenericService;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface FavoriteRouteService extends GenericService<FavoriteRoute, Integer> {

    List<FavoriteRoute> findAllOrderByAccount_Login(String login);
}
