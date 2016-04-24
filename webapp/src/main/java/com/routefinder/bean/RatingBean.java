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
 * Created by offsp on 24.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RatingBean {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RatingService ratingService;

    @Autowired
    private RouteService routeService;

    public void like() {

        Route route = getRoute();

        Rating rating = new Rating(1);
        rating.setRoute(route);

        Account account = accountService.findOneAccountByLogin(AccountBean.getUsername());
        rating.setAccount(account);

        List<Rating> ratings = ratingService.findAllOrderByAccountId(account.getId());
        for (Rating rating1 : ratings) {
            if (Objects.equals(rating1.getRoute().getId(), route.getId()) && rating1.getValue() == -1) {

                ratingService.delete(rating1);
                break;
            }
        }

        ratingService.saveAndFlush(rating);
    }

    public void dislike() {

        Route route = getRoute();

        Rating rating = new Rating(-1);
        rating.setRoute(route);

        Account account = accountService.findOneAccountByLogin(AccountBean.getUsername());
        rating.setAccount(account);

        List<Rating> ratings = ratingService.findAllOrderByAccountId(account.getId());
        for (Rating rating1 : ratings) {
            if (Objects.equals(rating1.getRoute().getId(), route.getId()) && rating1.getValue() == 1) {

                ratingService.delete(rating1);
                break;
            }
        }

        ratingService.saveAndFlush(rating);
    }

    public String getRating(Integer id){

        List<Rating> ratings = ratingService.findAllOrderByRoute_Id(id);

        int x = 0;
        for(Rating rating : ratings){
            x += rating.getValue();
        }

        return String.valueOf(x);
    }

    public List<Rating> getMyRatings(){

        String username = AccountBean.getUsername();

        return ratingService.findAllOrderByAccount_Login(username);
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
