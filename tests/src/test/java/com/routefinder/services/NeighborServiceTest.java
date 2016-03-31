package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Neighbor;
import com.routefinder.service.NeighborService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class NeighborServiceTest extends GenericServiceTest<Neighbor, Integer, NeighborService> {
    @Override
    protected Neighbor getEntity() {
        return entityGenerator.getNeighborEntity();
    }
}
