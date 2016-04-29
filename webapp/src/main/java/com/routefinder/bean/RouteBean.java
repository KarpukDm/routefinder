package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.maps.google.api.helper.CoordinateFinder;
import com.routefinder.maps.google.api.helper.DistanceCalculator;
import com.routefinder.model.*;
import com.routefinder.service.AccountService;
import com.routefinder.service.PointService;
import com.routefinder.service.RouteService;
import org.primefaces.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by offsp on 07.04    .2016.
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

    @Autowired
    private PointService pointService;

    private String startPoint;
    private String endPoint;
    private Point startPointCoordinate;
    private Point endPointCoordinate;

    private String info;
    private String price;

    private Route route;
    private ConfigGenerator configGenerator;
    private Account account;

    private String duration;
    private String lats;
    private String lngs;
    private String zoomLat;
    private String zoomLng;
    private String zoomLevel;
    private String pointsNames;

    public void addPoints() throws IOException, JSONException, IllegalAccessException {

        CoordinateFinder coordinateFinder = new CoordinateFinder();
        configGenerator = new ConfigGenerator();

        route = new Route();
        List<Point> points = new LinkedList<>();

        if(startPoint != null || endPoint != null) {

            List<Neighbor> neighborsS = new LinkedList<>();
            List<Neighbor> neighborsE = new LinkedList<>();

            startPointCoordinate = pointService.findOneByName(startPoint);
            if(startPointCoordinate == null) {
                startPointCoordinate = coordinateFinder.getPoint(startPoint);
            }else{
                neighborsS = startPointCoordinate.getNeighbors();
            }

            endPointCoordinate = pointService.findOneByName(endPoint);
            if(endPointCoordinate == null) {
                endPointCoordinate = coordinateFinder.getPoint(endPoint);
            }else{
                neighborsE = endPointCoordinate.getNeighbors();
            }

            Double distance = new DistanceCalculator().getDistance(startPointCoordinate, endPointCoordinate);

            Neighbor neighbor = new Neighbor(endPointCoordinate, distance);
            if(!neighborsS.contains(neighbor)) {
                neighborsS.add(neighbor);
            }

            neighbor = new Neighbor(startPointCoordinate, distance);
            if(!neighborsE.contains(neighbor)) {
                neighborsE.add(new Neighbor(startPointCoordinate, distance));
            }

            startPointCoordinate.setNeighbors(neighborsS);
            endPointCoordinate.setNeighbors(neighborsE);

            route.setCounter(0);

            route.setDistance(distance);

            points.add(startPointCoordinate);
            points.add(endPointCoordinate);

            route.setPoints(points);

            this.duration = configGenerator.getDuration(route);
            this.lats = configGenerator.getLats(points);
            this.lngs = configGenerator.getLngs(points);
            this.zoomLat = configGenerator.getZoomLat(points);
            this.zoomLng = configGenerator.getZoomLng(points);
            this.zoomLevel = configGenerator.getZoomLevel(route);
            this.pointsNames = configGenerator.getPointNames(points);


            route.setRouteConfig(new RouteConfig(this.duration,
                    this.lats, this.lngs, this.zoomLat, this.zoomLng, this.zoomLevel, this.pointsNames));
        }

    }

    public void addInfo() {

        route.setPrice(Double.valueOf(this.price));
        route.setInfo(this.info);
    }

    public void addSchedule(List<Schedule> schedules) {

        route.setSchedules(schedules);
    }

    public void createRoute() throws IOException {

        String username = AccountBean.getUsername();
        if(account == null || !Objects.equals(account.getLogin(), username)) {
           this.account = accountService.findOneAccountByLogin(username);
        }

        if(isExistRoute()) {

            route.setAccount(account);

            route.setStartPoint(startPoint);

            route.setEndPoint(endPoint);

            List<Rating> ratings = new LinkedList<>();
            ratings.add(new Rating(0));
            route.setRatings(ratings);

            startPointCoordinate.addRoute(route);
            endPointCoordinate.addRoute(route);

            account.addRoute(route);

            accountService.saveAndFlush(account);

            reset();
        }
    }

    private void reset(){
        this.startPoint = "";
        this.endPoint = "";
        this.startPointCoordinate = null;
        this.endPointCoordinate = null;
        this.info = "";
        this.price = "";
        List<Schedule> schedules = null;
    }

    public String getDuration(){

        if(!isExistRoute()){
            return "5";
        }
        this.duration = configGenerator.getDuration(route);
        return duration;
    }

    public String getLats() {

        if(!isExistRoute()){
            return "48.8567, 43.8163, 34.3, 23";
        }
        return lats;
    }

    public String getLngs() {

        if(!isExistRoute()){
            return "2.3510, -79.4287, -118.15, -82";
        }

        return lngs;
    }

    public String  getZoomLat(){

        if(!isExistRoute()){
            return "42";
        }

        return zoomLat;
    }

    public String getZoomLng(){

        if(!isExistRoute()){
            return "-55";
        }


        return zoomLng;
    }

    public String getZoomLevel(){

        if(!isExistRoute()){
            return "3.5";
        }

        return zoomLevel;
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

        return pointsNames;
    }

    private boolean isExistRoute(){

        return !(startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null);
    }

    public List<Route> getRoutes(){

        return routeService.findAll();
    }

    public List<Route> getMyRoutes(){

        String username = AccountBean.getUsername();

        return routeService.findAllOrderByAccount_Login(username);
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
