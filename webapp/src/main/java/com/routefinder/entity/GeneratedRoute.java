package com.routefinder.entity;

import com.routefinder.model.Point;
import com.routefinder.model.Route;

import java.util.List;

/**
 * Created by offsp on 11.05.2016.
 */
public class GeneratedRoute {

    private List<Point> points;
    private List<Route> routes;
    private String time;
    private String price;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }
}
