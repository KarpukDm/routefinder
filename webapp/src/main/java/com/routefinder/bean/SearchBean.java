package com.routefinder.bean;

import com.routefinder.algorithm.SearchAlgorithm;
import com.routefinder.amcharts.helper.ConfigGenerator;
import com.routefinder.maps.google.api.helper.DistanceCalculator;
import com.routefinder.model.Neighbor;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.model.SearchResult;
import com.routefinder.service.PointService;
import com.routefinder.service.RouteService;
import com.routefinder.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
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

    @Autowired
    private RouteService routeService;

    private String a;
    private String b;
    @SuppressWarnings("FieldCanBeLocal")
    private Integer maxLevel = 3;

    private int index;

    private List<List<Point>> routes = new LinkedList<>();

    private ConfigGenerator configGenerator = new ConfigGenerator();

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

    public Page<SearchResult> getLastRequests(){

        return searchResultService.findLastRecords(new PageRequest(0, 10, Sort.Direction.DESC, "id"));
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

        this.routes = searchAlgorithm.getRoutes(neighbors);

        return this.routes;
    }

    public String getDuration(){

        return configGenerator.getDuration(getRoute());
    }

    public Route getRoute(){

        Double d = 0d;

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        for (int i = 0; i < routes.get(index).size() - 1; i++) {

            if(d == 0){
                d += distanceCalculator.getDistance(routes.get(index).get(i), routes.get(index).get(i + 1));
            }
        }

        return new Route(d);
    }

    public String getLats() {

        return configGenerator.getLats(routes.get(index));
    }

    public String getLngs() {

        return configGenerator.getLngs(routes.get(index));
    }

    public String  getZoomLat(){

        return configGenerator.getZoomLat(routes.get(index));
    }

    public String getZoomLng(){

        return configGenerator.getZoomLng(routes.get(index));
    }

    public String getZoomLevel(){

        return configGenerator.getZoomLevel(getRoute());
    }

    public String getPointNames(){

        return configGenerator.getPointNames(routes.get(index));
    }

    public void setRoutes(List<List<Point>> routes) {
        this.routes = routes;
    }

    public List<Route> getRoutesForSearchResult(){

        List<Route> routes = new LinkedList<>();

        for(int i = 0; i < this.routes.get(index).size() - 1; i++){

            List<Point> points = new LinkedList<>();
            points.add(this.routes.get(index).get(i));
            points.add(this.routes.get(index).get(i + 1));

            List<Route> r = routeService.findAllOrderByPoints(points);

            if(r != null) {
                routes.addAll(r);
            }
        }

        return routes;
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

    public int getIndex() {
        return index;
    }


    public void setIndex(int index) {
        this.index = index;
    }
}
