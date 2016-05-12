package com.routefinder.bean;

import com.routefinder.algorithm.SearchAlgorithm;
import com.routefinder.entity.GeneratedRoute;
import com.routefinder.model.*;
import com.routefinder.service.PointService;
import com.routefinder.service.RouteService;
import com.routefinder.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

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
    private RouteService routeService;

    @Autowired
    private SearchResultService searchResultService;

    private String a;
    private String b;

    private String maxPrice;
    private String maxTime;
    @SuppressWarnings("FieldCanBeLocal")
    private Integer maxLevel = 3;

    private String requestValue;

    private int requestCounter;

    private List<List<Point>> result;

    private List<GeneratedRoute> generatedRoutes;

    public void saveRequest(){

        if(a != null && b != null && !Objects.equals(a, "") && !Objects.equals(b, "")) {
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

        return searchResultService.findLastRecords(new PageRequest(0, 16, Sort.Direction.DESC, "id"));
    }

    public List<GeneratedRoute> getRoutes(){

        requestCounter++;

        Point point = pointService.findOneByName(this.a);

        if(a == null || b == null && Objects.equals(a, "") || Objects.equals(b, "") || pointService.count() == 0){

            this.a = "";
            this.b = "";

            return null;
        }

        List<Neighbor> neighbors = new LinkedList<>();
        Neighbor neighbor = new Neighbor();
        neighbor.setPoint(point);
        neighbors.add(neighbor);

        SearchAlgorithm searchAlgorithm = new SearchAlgorithm(b, maxLevel);

        this.result = searchAlgorithm.getRoutePoints(neighbors);
        this.requestValue = a + " - " + b;
        this.a = "";
        this.b = "";
        this.maxLevel = 4;
        this.generatedRoutes = getGeneratedRoutes(result);
        return this.generatedRoutes;
    }

    public boolean isEmptyResponse(){

        return (generatedRoutes == null || generatedRoutes.size() == 0) && requestCounter > 1;
    }

    private List<GeneratedRoute> getGeneratedRoutes(List<List<Point>> result){

        if(result == null){
            return null;
        }

        List<GeneratedRoute> generatedRoutes = new LinkedList<>();
        for(List<Point> p : result){

            GeneratedRoute generatedRoute = new GeneratedRoute();
            generatedRoute.setRoutes(getRoutesForSearchResult(p));

            generatedRoute.setPoints(p);

            generatedRoute.setPrice(getTotalPrice(generatedRoute.getRoutes()));

            generatedRoute.setTime(getTotalTime(generatedRoute.getRoutes()));

            generatedRoutes.add(generatedRoute);
        }

        return generatedRoutes;
    }

    private List<Route> getRoutesForSearchResult(List<Point> pointList){

        List<Route> routes = new LinkedList<>();

        for(int i = 0; i < pointList.size() - 1; i++){

            List<Route> r = routeService.findAllOrderByStartPointAndEndPoint(pointList.get(i).getName(),
                    pointList.get(i + 1).getName());

            if(r == null || r.size() == 0) {
                r = routeService.findAllOrderByStartPointAndEndPoint(pointList.get(i + 1).getName(),
                        pointList.get(i).getName());
            }

            if(r != null && r.size() > 0){
                routes.addAll(r);
            }
        }

        return routes;
    }

    public boolean isMatch(List<Route> routes){

        return (maxPrice == null || Objects.equals(maxPrice, "") || Double.valueOf(getTotalPrice(routes)) <= Double.valueOf(maxPrice)) &&
                (maxTime == null || Objects.equals(maxTime, "") || Double.valueOf(getTotalTime(routes)) <= Double.valueOf(maxTime));
    }

    private String getTotalPrice(List<Route> routes){

        double x = 0;
        for(Route r : routes){

            x += r.getPrice();
        }

        return String.valueOf(x);
    }

    private String getTotalTime(List<Route> routes){

        double y = 0;
        for(Route r : routes){
            y = 0;
            for(Schedule s : r.getSchedules()){


                String a[] = s.getDepartureTime().split(":");
                String b[] = s.getArrivalTime().split(":");

                y = Double.valueOf(b[0]) * 60 + Double.valueOf(b[1]) - Double.valueOf(a[0]) * 60 + Double.valueOf(a[1]);
            }
            if(Objects.equals(maxTime, "") || maxTime == null || y <= Double.valueOf(maxTime)){
                return String.valueOf(y);
            }
        }

        return String.valueOf(y);
    }

    public void saveSearchParameters(){

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

    public String getRequestValue() {
        return requestValue;
    }

    public void setRequestValue(String requestValue) {
        this.requestValue = requestValue;
    }

    public List<List<Point>> getResult() {
        return result;
    }

    public void setResult(List<List<Point>> result) {
        this.result = result;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(String maxTime) {
        this.maxTime = maxTime;
    }

    public List<GeneratedRoute> getGeneratedRoutes() {
        return generatedRoutes;
    }

    public void setGeneratedRoutes(List<GeneratedRoute> generatedRoutes) {
        this.generatedRoutes = generatedRoutes;
    }

    public int getRequestCounter() {
        return requestCounter;
    }

    public void setRequestCounter(int requestCounter) {
        this.requestCounter = requestCounter;
    }
}
