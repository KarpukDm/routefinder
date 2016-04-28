package com.routefinder.bean;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.service.FavoriteRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by offsp on 28.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class FavoriteRouteBean {

    @Autowired
    private FavoriteRouteService favoriteRouteService;

    public List<FavoriteRoute> getFavoriteRoutes(){

        String username = AccountBean.getUsername();

        return favoriteRouteService.findAllOrderByAccount_Login(username);
    }
}
