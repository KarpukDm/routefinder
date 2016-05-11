package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.calculators.DistanceCalculator;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 30.04.2016.
 */
@ManagedBean
@ViewScoped
@Component
public class SearchResultBean {

    @Autowired
    private RouteService routeService;

    private List<Point> result;

    private String requestValue;

    private ConfigGenerator configGenerator = new ConfigGenerator();

    public String getDuration(){

        return configGenerator.getDuration(getRoute());
    }

    public Route getRoute(){

        Double d = 0d;

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        for (int i = 0; i < result.size() - 1; i++) {

            if(d == 0){
                d += distanceCalculator.getDistance(result.get(i), result.get(i + 1));
            }
        }

        return new Route(d);
    }

    public String getLats() {

        return configGenerator.getLats(result);
    }

    public String getLngs() {

        return configGenerator.getLngs(result);
    }

    public String  getZoomLat(){

        return configGenerator.getZoomLat(result);
    }

    public String getZoomLng(){

        return configGenerator.getZoomLng(result);
    }

    public String getZoomLevel(){

        return configGenerator.getZoomLevel(getRoute());
    }

    public String getPointNames(){

        return configGenerator.getPointNames(result);
    }

    public List<Route> getRoutesForSearchResult(){

        List<Route> routes = new LinkedList<>();

        for(int i = 0; i < result.size() - 1; i++){

            List<Route> r = routeService.findAllOrderByStartPointAndEndPoint(result.get(i).getName(),
                    result.get(i + 1).getName());

            if(r == null || r.size() == 0) {
                r = routeService.findAllOrderByStartPointAndEndPoint(result.get(i + 1).getName(),
                        result.get(i).getName());
            }

            if(r != null && r.size() > 0){
                routes.addAll(r);
            }
        }


        return routes;
    }

    public List<Point> getResult() {
        return result;
    }

    public void setResult(List<Point> result) {
        this.result = result;
    }

    public String getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }
}
