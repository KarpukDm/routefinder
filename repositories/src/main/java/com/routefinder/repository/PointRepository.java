package com.routefinder.repository;


import com.routefinder.model.Comment;
import com.routefinder.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface PointRepository extends JpaRepository<Point, Integer> {

    Point findOneByName(String a);
}
