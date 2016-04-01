package com.routefinder.repository;


import com.routefinder.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface FeedbackRepository extends JpaRepository<Address, Integer> {
}
