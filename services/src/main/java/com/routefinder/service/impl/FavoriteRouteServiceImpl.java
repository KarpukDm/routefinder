package com.routefinder.service.impl;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.repository.FavoriteRouteRepository;
import com.routefinder.service.FavoriteRouteService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class FavoriteRouteServiceImpl extends GenericServiceImpl<FavoriteRoute, Integer, FavoriteRouteRepository>
        implements FavoriteRouteService{
}
