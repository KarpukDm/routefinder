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

    private List<Rating> ratings;

    public boolean isLike(Integer id){

        for(Rating r : ratings){
            if(r.getRoute().getId().equals(id)){
                return r.getValue() == 1;
            }
        }

        return ratingService.findOneOrderByRoute_IdAndAccount_Login(id, AccountBean.getUsername()).getValue() == 1;
    }

    public void like() {

        Route route = getRoute();

        Rating rating = new Rating(1);
        rating.setRoute(route);

        Account account = accountService.findOneAccountByLogin(AccountBean.getUsername());
        rating.setAccount(account);

        if(account.getRatings() == null || account.getRatings().size() == 0){
            account.addRatind(rating);
        }else {

            for (int i = 0; i < account.getRatings().size(); i++) {

                if (account.getRatings().get(i).getRoute().getId().equals(route.getId())) {


                    account.getRatings().get(i).setValue(1);

                    //ratingService.delete(account.getRatings().get(i));
                    break;
                }
            }
        }

       /* List<Rating> ratings = ratingService.findAllOrderByAccountId(account.getId());
        for (Rating rating1 : ratings) {
            if (Objects.equals(rating1.getRoute().getId(), route.getId()) && rating1.getValue() == -1) {

                ratingService.delete(rating1);
                break;
            }
        }
        ratingService.saveAndFlush(rating);*/

        //account.addRatind(rating);

        accountService.saveAndFlush(account);
    }

    public void dislike() {

        Route route = getRoute();

        Rating rating = new Rating(-1);
        rating.setRoute(route);

        Account account = accountService.findOneAccountByLogin(AccountBean.getUsername());
        rating.setAccount(account);

        if(account.getRatings() == null || account.getRatings().size() == 0){
            account.addRatind(rating);
        }else {

            for (int i = 0; i < account.getRatings().size(); i++) {

                if (account.getRatings().get(i).getRoute().getId().equals(route.getId())) {
                    account.getRatings().get(i).setValue(-1);
                    //ratingService.delete(account.getRatings().get(i));
                    break;
                }
            }
        }

       /* rating.setAccount(account);

        List<Rating> ratings = ratingService.findAllOrderByAccountId(account.getId());
        for (Rating rating1 : ratings) {
            if (Objects.equals(rating1.getRoute().getId(), route.getId()) && rating1.getValue() == 1) {

                ratingService.delete(rating1);
                break;
            }
        }

        ratingService.saveAndFlush(rating);*/

        //account.addRatind(rating);

        accountService.saveAndFlush(account);
    }

    public List<Rating> getMyRatings(){

        String username = AccountBean.getUsername();

        this.ratings = ratingService.findAllOrderByAccount_Login(username);

        return ratings;
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

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
}
