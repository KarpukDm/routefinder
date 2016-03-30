package com.routefinder.repository;

import com.routefinder.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
}
