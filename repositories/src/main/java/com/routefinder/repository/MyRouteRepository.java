package com.routefinder.repository;

import com.routefinder.model.MyRoute;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface MyRouteRepository extends JpaRepository<MyRoute, Integer> {
}
