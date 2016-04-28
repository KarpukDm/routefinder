package com.routefinder.bean;

import com.routefinder.algorithm.SearchAlgorithm;
import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.model.Neighbor;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.model.SearchResult;
import com.routefinder.service.PointService;
import com.routefinder.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 23.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class SearchBean {

    @Autowired
    private PointService pointService;

    @Autowired
    private SearchResultService searchResultService;

    private String a;
    private String b;

    private List<Point> points;

    private ConfigGenerator configGenerator = new ConfigGenerator();

    @SuppressWarnings("FieldCanBeLocal")
    private Integer maxLevel = 3;

    public void saveRequest(){

        if(a != null && b != null) {
            SearchResult searchResult = new SearchResult();
            searchResult.setStartPoint(a);
            searchResult.setEndPoint(b);
            searchResult.setSearch("result");

            searchResultService.save(searchResult);
        }
    }

    public void findByLastRequest(SearchResult searchResult){

        this.a = searchResult.getStartPoint();
        this.b = searchResult.getEndPoint();
        this.maxLevel = 4;

    }

    public List<SearchResult> getLastRequests(){

        return searchResultService.findTop10BySearch("result");
    }

    public List<List<Point>> getRoutes(){

        Point point = pointService.findOneByName(this.a);

        if(a == null || b == null){
            return null;
        }

        List<Neighbor> neighbors = new LinkedList<>();
        Neighbor neighbor = new Neighbor();
        neighbor.setPoint(point);
        neighbors.add(neighbor);

        SearchAlgorithm searchAlgorithm = new SearchAlgorithm(b, maxLevel);


        return searchAlgorithm.getRoutes(neighbors);
    }

    public String getDuration(){

        return configGenerator.getDuration(getRoute());
    }

    public Route getRoute(){

        Double d = 0d;

        for (Point point : points) {

            d += point.getNeighbors().get(0).getDistance();
        }

        return new Route(d);
    }

    public String getLats() {

        return configGenerator.getLats(points);
    }

    public String getLngs() {

        return configGenerator.getLngs(points);
    }

    public String  getZoomLat(){

        return configGenerator.getZoomLat(points);
    }

    public String getZoomLng(){

        return configGenerator.getZoomLng(points);
    }

    public String getZoomLevel(){

        return configGenerator.getZoomLevel(getRoute());
    }

    public String getPointNames(){

        return configGenerator.getPointNames(points);
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }
}
