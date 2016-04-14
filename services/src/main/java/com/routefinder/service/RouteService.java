package com.routefinder.service;

import com.routefinder.model.Account;
import com.routefinder.model.Route;
import com.routefinder.service.common.GenericService;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface RouteService extends GenericService<Route, Integer> {

    Route findOneRouteById(Integer id);
}
