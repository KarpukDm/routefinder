package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.MyRoute;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class MyRouteServiceTest extends GenericServiceTest<MyRoute, Integer, MyRouteService> {
    @Override
    protected MyRoute getEntity() {
        return entityGenerator.getMyRouteEntity();
    }
}
