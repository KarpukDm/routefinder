package com.routefinder.bean;

import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.calculators.DistanceCalculator;
import com.routefinder.entity.GeneratedRoute;
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

    private GeneratedRoute result;

    private String requestValue;

    private ConfigGenerator configGenerator = new ConfigGenerator();

    public String getDuration(){

        return configGenerator.getDuration(getRoute());
    }

    public Route getRoute(){

        Double d = 0d;

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        for (int i = 0; i < result.getPoints().size() - 1; i++) {

            if(d == 0){
                d += distanceCalculator.getDistance(result.getPoints().get(i), result.getPoints().get(i + 1));
            }
        }

        return new Route(d);
    }

    public String getLats() {

        return configGenerator.getLats(result.getPoints());
    }

    public String getLngs() {

        return configGenerator.getLngs(result.getPoints());
    }

    public String  getZoomLat(){

        return configGenerator.getZoomLat(result.getPoints());
    }

    public String getZoomLng(){

        return configGenerator.getZoomLng(result.getPoints());
    }

    public String getZoomLevel(){

        return configGenerator.getZoomLevel(getRoute());
    }

    public String getPointNames(){

        return configGenerator.getPointNames(result.getPoints());
    }

    public GeneratedRoute getResult() {
        return result;
    }

    public void setResult(GeneratedRoute result) {
        this.result = result;
    }

    public String getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }
}
