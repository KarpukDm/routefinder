package com.routefinder.repository;

import com.routefinder.model.RouteConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by offsp on 15.04.2016.
 */
public interface RouteConfigRepository extends JpaRepository<RouteConfig, Integer> {
}
