package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.maps.google.api.helper.CoordinateFinder;
import com.routefinder.maps.google.api.helper.DistanceCalculator;
import com.routefinder.model.*;
import com.routefinder.service.AccountService;
import com.routefinder.service.MyRouteService;
import com.routefinder.service.RouteService;
import org.primefaces.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SpringSessionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by offsp on 07.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RouteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RouteService routeService;

    private String startPoint;
    private String endPoint;
    private Point startPointCoordinate;
    private Point endPointCoordinate;

    private List<Schedule> schedules;
    private List<Point> points;
    private String info;
    private String price;

    private Route route;
    private ConfigGenerator configGenerator;
    private Account account;

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

        List<Rating> ratings = new LinkedList<>();
        ratings.add(new Rating(0));
        route.setRatings(ratings);

        route.setDistance(new DistanceCalculator().getDistance(startPointCoordinate, endPointCoordinate));
    }

    public void addInfo() {

        route.setPrice(Double.valueOf(this.price));
        route.setInfo(this.info);
    }

    public void addSchedule() {

    }

    public void createRoute() throws IOException {

        MyRoute myRoute = new MyRoute();
        myRoute.setRoute(route);

        String username = AccountBean.getUsername();
        if(account == null || !Objects.equals(account.getLogin(), username)) {
           this.account = accountService.findOneAccountByLogin(username);
        }

        account.addRoute(myRoute);

        accountService.save(account);
    }

    public String getDuration(){

        if(isExistRoute()){
            return "5";
        }

        return configGenerator.getDuration(route);
    }

    public String getLats() {

        if(isExistRoute()){
            return "48.8567, 43.8163, 34.3, 23";
        }

        return configGenerator.getLats(this.points);
    }

    public String getLngs() {

        if(isExistRoute()){
            return "2.3510, -79.4287, -118.15, -82";
        }

        return configGenerator.getLngs(this.points);
    }

    public String  getZoomLat(){

        if(isExistRoute()){
            return "42";
        }

        return configGenerator.getZoomLat(this.points);
    }

    public String getZoomLng(){

        if(isExistRoute()){
            return "-55";
        }

        return configGenerator.getZoomLng(this.points);
    }

    public String getZoomLevel(){

        if(isExistRoute()){
            return "3.5";
        }

        return configGenerator.getZoomLevel(this.route);
    }

    private boolean isExistRoute(){

        return (startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null);
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

    public List<Route> getRoutes(){

        return routeService.findAll();
    }

    public List<MyRoute> getMyRoutes(){

        String login = AccountBean.getUsername();

        String username = AccountBean.getUsername();
        if(account == null || !Objects.equals(account.getLogin(), username)) {
           this.account = accountService.findOneAccountByLogin(login);
        }

        return account.getMyRoutes();
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

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
