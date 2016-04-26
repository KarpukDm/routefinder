package com.routefinder.algorithm;

import com.routefinder.model.Point;
import com.routefinder.model.Route;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 25.04.2016.
 */
public class RoutePoints {

    private Point point;

    private List<RoutePoints> routePointsList;

    public RoutePoints(Point point){
        this.point = point;
        routePointsList = new LinkedList<>();
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public List<RoutePoints> getRoutePointsList() {
        return routePointsList;
    }

    public void setRoutePointsList(List<RoutePoints> routePointsList) {
        this.routePointsList = routePointsList;
    }
}
