package com.routefinder.repository;


import com.routefinder.model.Account;
import com.routefinder.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface RouteRepository extends JpaRepository<Route, Integer> {

    Route findOneRouteById(Integer id);
}
