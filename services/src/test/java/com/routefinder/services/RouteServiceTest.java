package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Route;
import com.routefinder.service.RouteService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class RouteServiceTest extends GenericServiceTest<Route, Integer, RouteService> {
    @Override
    protected Route getEntity() {
        return entityGenerator.getRouteEntity();
    }
}
