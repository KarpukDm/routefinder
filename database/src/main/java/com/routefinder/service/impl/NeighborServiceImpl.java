package com.routefinder.service.impl;

import com.routefinder.model.Neighbor;
import com.routefinder.repository.NeighborRepository;
import com.routefinder.service.NeighborService;
import com.routefinder.service.common.impl.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by karpukdm on 29.03.16.
 */
@Service
@Transactional
public class NeighborServiceImpl extends GenericServiceImpl<Neighbor, Integer, NeighborRepository>
        implements NeighborService{
}
