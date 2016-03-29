package com.routefinder.service.impl;

import com.routefinder.model.Schedule;
import com.routefinder.repository.ScheduleRepository;
import com.routefinder.service.ScheduleService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class ScheduleServiceImpl extends GenericServiceImpl<Schedule, Integer, ScheduleRepository>
        implements ScheduleService{
}
