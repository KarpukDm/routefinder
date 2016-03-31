package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Statistics;
import com.routefinder.service.StatisticsService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class StatisticsServiceTest extends GenericServiceTest<Statistics, Integer, StatisticsService> {
    @Override
    protected Statistics getEntity() {
        return entityGenerator.getStatisticsEntity();
    }
}
