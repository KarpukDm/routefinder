package com.routefinder.bean;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.model.Route;
import com.routefinder.service.AccountService;
import com.routefinder.service.FavoriteRouteService;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by offsp on 21.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RoutePageBean {

    @Autowired
    private RouteService routeService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private FavoriteRouteService favoriteRouteService;

    private Route route;

    public void deleteRoute() {

        routeService.delete(route);
    }

    public void subscribe(){

        FavoriteRoute favoriteRoute = new FavoriteRoute();
        favoriteRoute.setRoute(getRoute());
        favoriteRoute.setAccount(accountService.findOneAccountByLogin(AccountBean.getUsername()));

        favoriteRouteService.save(favoriteRoute);
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }


}
