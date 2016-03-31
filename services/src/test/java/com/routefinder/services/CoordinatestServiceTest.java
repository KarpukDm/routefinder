package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Coordinates;
import com.routefinder.service.CoordinatesService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class CoordinatestServiceTest extends GenericServiceTest<Coordinates, Integer, CoordinatesService> {
    @Override
    protected Coordinates getEntity() {
        return entityGenerator.getCoordinatesEntity();
    }
}
