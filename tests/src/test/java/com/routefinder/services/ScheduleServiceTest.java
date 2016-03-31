package com.routefinder.services;

import com.routefinder.common.GenericServiceTest;
import com.routefinder.model.Schedule;
import com.routefinder.service.ScheduleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 31.03.16.
 */
@Transactional
public class ScheduleServiceTest extends GenericServiceTest<Schedule, Integer, ScheduleService> {
    @Override
    protected Schedule getEntity() {
        return entityGenerator.getScheduleEntity();
    }
}
