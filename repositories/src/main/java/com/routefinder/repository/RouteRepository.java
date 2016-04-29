package com.routefinder.repository;


import com.routefinder.model.Account;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import org.primefaces.component.rating.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface RouteRepository extends JpaRepository<Route, Integer> {

    Route findOneRouteById(Integer id);

    Route findOneRouteByPoints(List<Point> points);

    Route findOneRouteOrderByPoints(List<Point> list);

    List<Route> findAllOrderByAccount_Login(String route);

    void deleteOneById(Integer id);
}
