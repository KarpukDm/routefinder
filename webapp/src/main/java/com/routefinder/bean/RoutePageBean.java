package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.Rating;
import com.routefinder.model.Route;
import com.routefinder.service.AccountService;
import com.routefinder.service.RatingService;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by offsp on 21.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RoutePageBean {

    @Autowired
    private RouteService routeService;

    public void deleteRoute() {

        Route route = getRoute();

        routeService.delete(route);
    }

    private Route getRoute() {
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("routeId");

        return getRoute(Integer.valueOf(id));
    }

    private Route getRoute(Integer id) {
        return routeService.findOneRouteById(id);
    }

}
