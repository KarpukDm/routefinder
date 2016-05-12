package com.routefinder.service.impl;

import com.routefinder.model.PointInfo;
import com.routefinder.repository.PointInfoRepository;
import com.routefinder.service.PointInfoService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by offsp on 12.05.2016.
 */
@Service
@Transactional
public class PointInfoServiceImpl extends GenericServiceImpl<PointInfo, Integer, PointInfoRepository>
        implements PointInfoService {

}
