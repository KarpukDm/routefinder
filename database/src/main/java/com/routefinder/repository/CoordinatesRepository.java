package com.routefinder.repository;

import com.routefinder.model.Comment;
import com.routefinder.model.Coordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface CoordinatesRepository extends JpaRepository<Coordinates, Integer>{
}
