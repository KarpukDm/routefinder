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

    public void deleteRoute() {

        //Route route = getRoute();

        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("routeId");

        routeService.deleteOneById(Integer.valueOf(id));
    }

    private Route getRoute() {
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("routeId");

        return getRoute(Integer.valueOf(id));
    }

    public void subscribe(){

        FavoriteRoute favoriteRoute = new FavoriteRoute();
        favoriteRoute.setRoute(getRoute());
        favoriteRoute.setAccount(accountService.findOneAccountByLogin(AccountBean.getUsername()));

        favoriteRouteService.save(favoriteRoute);
    }

    private Route getRoute(Integer id) {
        return routeService.findOneRouteById(id);
    }

}
