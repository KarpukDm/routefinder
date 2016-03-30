package com.routefinder.service.impl;

import com.routefinder.model.Route;
import com.routefinder.repository.RouteRepository;
import com.routefinder.service.RouteService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class RouteServiceImpl extends GenericServiceImpl<Route, Integer, RouteRepository>
        implements RouteService{
}
