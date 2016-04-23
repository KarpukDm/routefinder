package com.routefinder.service.impl;

import com.routefinder.model.Point;
import com.routefinder.repository.PointRepository;
import com.routefinder.service.PointService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class PointServiceImpl extends GenericServiceImpl<Point, Integer, PointRepository>
        implements PointService{
    @Override
    public Point findOneByName(String a) {
        return repository.findOneByName(a);
    }
}
