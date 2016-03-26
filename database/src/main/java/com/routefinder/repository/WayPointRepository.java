package com.routefinder.repository;

import com.routefinder.model.WayPoint;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */
public interface WayPointRepository extends JpaRepository<WayPoint, Integer> {
}
