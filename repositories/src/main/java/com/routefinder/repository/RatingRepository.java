package com.routefinder.repository;


import com.routefinder.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findAllOrderByAccountId(Integer id);

    Rating findOneOrderByRoute_IdAndAccount_Login(Integer id, String login);

    List<Rating> findAllOrderByRoute_Id(Integer id);

    List<Rating> findAllOrderByAccount_Login(String login);
}
