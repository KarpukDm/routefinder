package com.routefinder.service.impl;

import com.routefinder.model.Statistics;
import com.routefinder.repository.StatisticsRepository;
import com.routefinder.service.StatisticsService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class StatisticsServiceImpl extends GenericServiceImpl<Statistics, Integer, StatisticsRepository>
        implements StatisticsService{
}
