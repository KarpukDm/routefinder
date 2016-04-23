package com.routefinder.service;

import com.routefinder.model.Point;
import com.routefinder.service.common.GenericService;

import java.util.List;

/**
 * Created by karpukdm on 29.03.16.
 */
public interface PointService extends GenericService<Point, Integer> {

    Point findOneByName(String a);
}
