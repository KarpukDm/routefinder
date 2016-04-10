package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGeneratorJson;
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

    public void addPoints() {

    }

    public void addInfo() {

    }

    public String getConfig() {
        return "{" +
                "type: \"map\",\n" +
                "\n" +
                "            dataProvider: {\n" +
                "                map: \"worldLow\",\n" +
                "                zoomLevel: 3.5,\n" +
                "                zoomLongitude: -55,\n" +
                "                zoomLatitude: 42,\n" +
                "\n" +
                "                lines: [{\n" +
                "                    id: \"line1\",\n" +
                "                    arc: -0.85,\n" +
                "                    alpha: 0.3,\n" +
                "                    latitudes: [48.8567, 43.8163, 34.3, 23],\n" +
                "                    longitudes: [2.3510, -79.4287, -118.15, -82]\n" +
                "                }, {\n" +
                "                    id: \"line2\",\n" +
                "                    alpha: 0,\n" +
                "                    color: \"#000000\",\n" +
                "                    latitudes: [48.8567, 43.8163, 34.3, 23],\n" +
                "                    longitudes: [2.3510, -79.4287, -118.15, -82]\n" +
                "                }],\n" +
                "                images: [{\n" +
                "                    svgPath: targetSVG,\n" +
                "                    title: \"Paris\",\n" +
                "                    latitude: 48.8567,\n" +
                "                    longitude: 2.3510\n" +
                "                }, {\n" +
                "                    svgPath: targetSVG,\n" +
                "                    title: \"Toronto\",\n" +
                "                    latitude: 43.8163,\n" +
                "                    longitude: -79.4287\n" +
                "                }, {\n" +
                "                    svgPath: targetSVG,\n" +
                "                    title: \"Los Angeles\",\n" +
                "                    latitude: 34.3,\n" +
                "                    longitude: -118.15\n" +
                "                }, {\n" +
                "                    svgPath: targetSVG,\n" +
                "                    title: \"Havana\",\n" +
                "                    latitude: 23,\n" +
                "                    longitude: -82\n" +
                "                }, {\n" +
                "                    svgPath: planeSVG,\n" +
                "                    positionOnLine: 0,\n" +
                "                    color: \"#000000\",\n" +
                "                    alpha: 0.1,\n" +
                "                    animateAlongLine: true,\n" +
                "                    lineId: \"line2\",\n" +
                "                    flipDirection: true,\n" +
                "                    loop: true,\n" +
                "                    scale: 0.03,\n" +
                "                    positionScale: 1.3\n" +
                "                }, {\n" +
                "                    svgPath: planeSVG,\n" +
                "                    positionOnLine: 0,\n" +
                "                    color: \"#585869\",\n" +
                "                    animateAlongLine: true,\n" +
                "                    lineId: \"line1\",\n" +
                "                    flipDirection: true,\n" +
                "                    loop: true,\n" +
                "                    scale: 0.03,\n" +
                "                    positionScale: 1.8\n" +
                "                }]\n" +
                "            },\n" +
                "\n" +
                "            areasSettings: {\n" +
                "                unlistedAreasColor: \"#8dd9ef\"\n" +
                "            },\n" +
                "\n" +
                "            imagesSettings: {\n" +
                "                color: \"#585869\",\n" +
                "                rollOverColor: \"#585869\",\n" +
                "                selectedColor: \"#585869\",\n" +
                "                pauseDuration: 0.2,\n" +
                "                animationDuration: 2.5,\n" +
                "                adjustAnimationSpeed: true\n" +
                "            },\n" +
                "\n" +
                "            linesSettings: {\n" +
                "                color: \"#585869\",\n" +
                "                alpha: 0.4\n" +
                "            },\n" +
                "\n" +
                "            export: {\n" +
                "                enabled: true\n" +
                "            }" +
                "}";
    }

    public String getMapConfigJson() throws JSONException {

        if (startPoint == null || endPoint == null ||
                startPointCoordinate == null || endPointCoordinate == null) {
            return getConfig();
        } else {
            List<Point> points = new LinkedList<>();

            points.add(startPointCoordinate);
            points.add(endPointCoordinate);

           String x = new ConfigGeneratorJson().generateJson(points).toString();

            return x;

            //return getConfig();
        }
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

        route.setCounter(0);

        route.setDistance(new DistanceCalculator().getDistance(startPointCoordinate, endPointCoordinate));

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
