package com.routefinder.repository;

import com.routefinder.model.RouteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */
public interface RouteInfoRepository extends JpaRepository<RouteInfo, Integer> {
}
