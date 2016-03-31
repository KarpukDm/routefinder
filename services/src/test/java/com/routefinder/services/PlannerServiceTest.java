package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Planner;
import com.routefinder.service.PlannerService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class PlannerServiceTest extends GenericServiceTest<Planner, Integer, PlannerService> {
    @Override
    protected Planner getEntity() {
        return entityGenerator.getPlannerEntity();
    }
}
