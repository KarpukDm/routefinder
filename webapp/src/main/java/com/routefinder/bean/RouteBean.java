package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.maps.google.api.helper.CoordinateFinder;
import com.routefinder.maps.google.api.helper.DistanceCalculator;
import com.routefinder.model.MyRoute;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.model.Schedule;
import com.routefinder.service.MyRouteService;
import org.primefaces.json.JSONException;
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
    private MyRouteService myRouteService;

    private String startPoint;
    private String endPoint;
    private Point startPointCoordinate;
    private Point endPointCoordinate;
    private String info;
    private List<Schedule> schedules;
    private List<Point> points;
    private Route route;
    private ConfigGenerator configGenerator;

    public void addPoints() throws IOException, JSONException {
        CoordinateFinder coordinateFinder = new CoordinateFinder();
        configGenerator = new ConfigGenerator();

        route = new Route(15.0);
        points = new LinkedList<>();

        startPointCoordinate = coordinateFinder.getPoint(startPoint);
        endPointCoordinate = coordinateFinder.getPoint(endPoint);

        points.add(startPointCoordinate);
        points.add(endPointCoordinate);

        route.setPoints(points);

        route.setCounter(0);

        route.setDistance(new DistanceCalculator().getDistance(startPointCoordinate, endPointCoordinate));
    }

    public void addInfo() {
        route.setInfo(this.info);
    }

    public void addSchedule() {

    }

    public String getLats() {

        if(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null){
            return "48.8567, 43.8163, 34.3, 23";
        }

        return configGenerator.getLats(this.points);
    }

    public String getLngs() {

        if(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null){
            return "2.3510, -79.4287, -118.15, -82";
        }

        return configGenerator.getLngs(this.points);
    }

    public String  getZoomLat(){

        if(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null){
            return "42";
        }

        return configGenerator.getZoomLat(this.points);
    }

    public String getZoomLng(){

        if(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null){
            return "-55";
        }

        return configGenerator.getZoomLng(this.points);
    }

    public String getZoomLevel(){

        if(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null){
            return "3.5";
        }

        return configGenerator.getZoomLevel(this.route);
    }

    public String getPointNames(){

        if(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null){
            return "{\n" +
                    "            svgPath: targetSVG,\n" +
                    "            title: \"Paris\",\n" +
                    "            latitude: 48.8567,\n" +
                    "            longitude: 2.3510\n" +
                    "        }, {\n" +
                    "            svgPath: targetSVG,\n" +
                    "            title: \"Toronto\",\n" +
                    "            latitude: 43.8163,\n" +
                    "            longitude: -79.4287\n" +
                    "        }, {\n" +
                    "            svgPath: targetSVG,\n" +
                    "            title: \"Los Angeles\",\n" +
                    "            latitude: 34.3,\n" +
                    "            longitude: -118.15\n" +
                    "        }, {\n" +
                    "            svgPath: targetSVG,\n" +
                    "            title: \"Havana\",\n" +
                    "            latitude: 23,\n" +
                    "            longitude: -82\n" +
                    "        }";
        }

        return configGenerator.getPointNames(this.points);
    }

    public void createRoute() throws IOException {

        MyRoute myRoute = new MyRoute();
        myRoute.setRoute(route);

        myRouteService.save(myRoute);
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

    public MyRouteService getMyRouteService() {
        return myRouteService;
    }

    public void setMyRouteService(MyRouteService myRouteService) {
        this.myRouteService = myRouteService;
    }

}
