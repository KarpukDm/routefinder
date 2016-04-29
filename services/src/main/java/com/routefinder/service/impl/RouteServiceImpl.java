package com.routefinder.service.impl;

import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.repository.RouteRepository;
import com.routefinder.service.RouteService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class RouteServiceImpl extends GenericServiceImpl<Route, Integer, RouteRepository>
        implements RouteService{
    @Override
    public Route findOneRouteById(Integer id) {
        return repository.findOneRouteById(id);
    }

    @Override
    public List<Route> findAllOrderByAccount_Login(String route) {
        return repository.findAllOrderByAccount_Login(route);
    }

    @Override
    public List<Route> findAllOrderByStartPointAndEndPoint(String start, String end) {
        return repository.findAllOrderByStartPointAndEndPoint(start, end);
    }

    @Override
    public void deleteOneById(Integer id) {
        repository.deleteOneById(id);
    }
}
