package com.routefinder.repository;

import com.routefinder.model.Neighbor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */
public interface NeighborRepository extends JpaRepository<Neighbor, Integer> {
}
