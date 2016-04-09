package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGeneratorJson;
import com.routefinder.maps.google.api.helper.CoordinateFinder;
import com.routefinder.maps.google.api.helper.DistanceCalculator;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.model.Schedule;
import com.routefinder.service.RouteService;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
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

    public void createRoute() throws IOException, JSONException {

        CoordinateFinder coordinateFinder = new CoordinateFinder();

        Route route = new Route(15.0);
        List<Point> points = new LinkedList<>();

        startPointCoordinate = coordinateFinder.getPoint(startPoint);
        endPointCoordinate = coordinateFinder.getPoint(endPoint);

        points.add(startPointCoordinate);
        points.add(endPointCoordinate);

        route.setPoints(points);
        route.setInfo(this.info);

        route.setDistance(new DistanceCalculator().getDistance(startPointCoordinate, endPointCoordinate));

        ConfigGeneratorJson configGeneratorJson = new ConfigGeneratorJson();
        JSONObject jsonObject = configGeneratorJson.generateJson(points);
        route.setDataJson(jsonObject.toString());

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
