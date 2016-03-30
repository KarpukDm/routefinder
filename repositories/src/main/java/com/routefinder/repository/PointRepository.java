package com.routefinder.repository;


import com.routefinder.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface PointRepository extends JpaRepository<Point, Integer> {
}
