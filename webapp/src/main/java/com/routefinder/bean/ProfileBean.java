package com.routefinder.bean;

import com.routefinder.model.FavoriteRoute;
import com.routefinder.model.Rating;
import com.routefinder.service.FavoriteRouteService;
import com.routefinder.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

/**
 * Created by offsp on 13.05.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class ProfileBean {

    @Autowired
    private FavoriteRouteService favoriteRouteService;

    @Autowired
    private RatingService ratingService;

    private Page<FavoriteRoute> lastSubscriptions;

    private Page<Rating> lastEvaluations;

    public Page<FavoriteRoute> getSubscriptions(){

        lastSubscriptions = favoriteRouteService.findLastSubscriptions(new PageRequest(0, 4, Sort.Direction.DESC, "id"), AccountBean.getUsername());
        return lastSubscriptions;
    }

    public Page<Rating> getEvaluations(){

        lastEvaluations = ratingService.findLastEvaluations(new PageRequest(0, 6, Sort.Direction.DESC, "id"), AccountBean.getUsername());
        return lastEvaluations;
    }

    public boolean isEmptySubscribes() {

        return lastSubscriptions == null || lastSubscriptions.getSize() == 0;

    }

    public boolean isEmptyEvaluations() {

        return lastEvaluations == null || lastEvaluations.getSize() == 0;

    }

    public boolean isLike(Rating rating){

        return rating.getAccount().getLogin().equalsIgnoreCase(AccountBean.getUsername()) && rating.getValue().equals(1);
    }

    public Page<Rating> getLastEvaluations() {
        return lastEvaluations;
    }

    public void setLastEvaluations(Page<Rating> lastEvaluations) {
        this.lastEvaluations = lastEvaluations;
    }

    public Page<FavoriteRoute> getLastSubscriptions() {
        return lastSubscriptions;
    }

    public void setLastSubscriptions(Page<FavoriteRoute> lastSubscriptions) {
        this.lastSubscriptions = lastSubscriptions;
    }
}
