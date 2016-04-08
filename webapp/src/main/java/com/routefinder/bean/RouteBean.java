package com.routefinder.bean;

import com.routefinder.model.*;
import com.routefinder.service.AccountService;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 07.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RouteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private RouteService routeService;

    private String startPoint;
    private String endPoint;
    private Point startPointCoordinate;
    private Point endPointCoordinate;
    private String info;
    private List<Schedule> schedules;

    public void addPoints(){

    }

    public void addInfo(){

    }

    public void createRoute(){
        Route route = new Route(15.0);
        List<Point> points = new LinkedList<>();
        route.setPoints(points);
        route.setInfo(this.info);

        routeService.save(route);
    }

    public RouteService getRouteService() {
        return routeService;
    }

    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Point getStartPointCoordinate() {
        return startPointCoordinate;
    }

    public void setStartPointCoordinate(Point startPointCoordinate) {
        this.startPointCoordinate = startPointCoordinate;
    }

    public Point getEndPointCoordinate() {
        return endPointCoordinate;
    }

    public void setEndPointCoordinate(Point endPointCoordinate) {
        this.endPointCoordinate = endPointCoordinate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }
}
