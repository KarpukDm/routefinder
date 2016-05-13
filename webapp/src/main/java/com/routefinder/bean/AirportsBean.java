package com.routefinder.bean;

import com.routefinder.model.Neighbor;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created by offsp on 12.05.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class AirportsBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private PointService pointService;

    private Point departureAirport;

    private Point landingAirport;

    private boolean isVisible = false;

    private int index;

    public List<Point> getDepartureAirports(){

        return pointService.findAll();
    }

    public List<Neighbor> getLandingAirport(){

        if(departureAirport == null){
            return null;
        }

        return departureAirport.getNeighbors();
    }

    public Route getRoute(){

        if(departureAirport == null){
            return null;
        }

        return departureAirport.getRoutes().get(index);
    }

    public void setDepartureAirport(Point point){

        this.isVisible = false;
        this.departureAirport = point;
    }

    public void setLandingAirport(int index){

        this.isVisible = true;
        this.index = index;
    }

    public Point getDepartureAirport() {
        return departureAirport;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }
}
