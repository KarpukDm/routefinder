package com.routefinder.service.impl;

import com.routefinder.model.Planner;
import com.routefinder.repository.PlannerRepository;
import com.routefinder.service.PlannerService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class PlannerServiceImpl extends GenericServiceImpl<Planner, Integer, PlannerRepository>
        implements PlannerService{
}
