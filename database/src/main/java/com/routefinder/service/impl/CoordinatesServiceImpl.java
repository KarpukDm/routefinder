package com.routefinder.service.impl;

import com.routefinder.model.Coordinates;
import com.routefinder.repository.CoordinatesRepository;
import com.routefinder.service.CoordinatesService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class CoordinatesServiceImpl extends GenericServiceImpl<Coordinates, Integer, CoordinatesRepository>
        implements CoordinatesService{
}
