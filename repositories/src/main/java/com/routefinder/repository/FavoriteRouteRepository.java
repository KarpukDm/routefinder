package com.routefinder.repository;

import com.routefinder.model.FavoriteRoute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by karpukdm on 26.03.16.
 */

public interface FavoriteRouteRepository extends JpaRepository<FavoriteRoute, Integer> {

    List<FavoriteRoute> findAllOrderByAccount_Login(String login);

    Page<FavoriteRoute> findAllOrderByAccount_Login(String login, Pageable pageable);

   // void deleteOrderByAccount_Id();

    void deleteOrderByRoute_Id(Integer id);

    FavoriteRoute findOneOrderByAccount_IdAndRoute_Id(Integer account_Id, Integer route_Id);

}
