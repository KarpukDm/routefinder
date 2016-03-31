package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.FavoriteRoute;
import com.routefinder.service.FavoriteRouteService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class FavoriteRouteServiceTest extends GenericServiceTest<FavoriteRoute, Integer, FavoriteRouteService> {
    @Override
    protected FavoriteRoute getEntity() {
        return entityGenerator.getFavoriteRouteEntity();
    }
}
