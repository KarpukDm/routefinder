package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.RouteInfo;
import com.routefinder.service.RouteInfoService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class RouteInfoServiceTest extends GenericServiceTest<RouteInfo, Integer, RouteInfoService> {
    @Override
    protected RouteInfo getEntity() {
        return entityGenerator.getRouteInfoEntity();
    }
}
