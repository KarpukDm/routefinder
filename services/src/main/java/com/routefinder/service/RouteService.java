package com.routefinder.service;

import com.routefinder.model.Account;
import com.routefinder.model.Route;
import com.routefinder.service.common.GenericService;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface RouteService extends GenericService<Route, Integer> {

    Route findOneRouteById(Integer id);

    List<Route> findAllOrderByAccount_Login(String route);

    void deleteOneById(Integer id);
}
