package com.routefinder.service.impl;

import com.routefinder.model.MyRoute;
import com.routefinder.repository.MyRouteRepository;
import com.routefinder.service.MyRouteService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class MyRouteServiceImpl extends GenericServiceImpl<MyRoute, Integer, MyRouteRepository>
        implements MyRouteService{
}
