package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Point;
import com.routefinder.service.PointService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class PointServiceTest extends GenericServiceTest<Point, Integer, PointService> {
    @Override
    protected Point getEntity() {
        return entityGenerator.getPointEntity();
    }
}
