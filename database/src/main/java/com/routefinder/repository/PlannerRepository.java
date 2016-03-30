package com.routefinder.repository;

import com.routefinder.model.Planner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface PlannerRepository extends JpaRepository<Planner, Integer> {
}
