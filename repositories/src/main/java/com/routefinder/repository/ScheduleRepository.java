package com.routefinder.repository;


import com.routefinder.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
