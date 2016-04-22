package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.Route;
import com.routefinder.service.AccountService;
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

        public void deleteRoute(){

        Route route = getRoute();

        routeService.delete(route);
    }

    public void like(){

        Route route = getRoute();

        route.like(route.getId());

        routeService.save(route);

        Account account = accountService.findOneAccountByLogin(AccountBean.getUsername());

        account.like(route.getId());

        accountService.save(account);
    }

    public void dislike(){

        Route route = getRoute();

        route.dislike(route.getId());

        routeService.save(route);

        Account account = accountService.findOneAccountByLogin(AccountBean.getUsername());

        account.dislike(route.getId());

        accountService.save(account);
    }

    private Route getRoute() {
        Map<String, String> params =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String id = params.get("routeId");

        return getRoute(Integer.valueOf(id));
    }

    private Route getRoute(Integer id){
        return routeService.findOneRouteById(id);
    }
}
