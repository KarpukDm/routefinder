package com.routefinder.bean;

import com.routefinder.algorithm.SearchAlgorithm;
import com.routefinder.model.Neighbor;
import com.routefinder.model.Point;
import com.routefinder.model.SearchResult;
import com.routefinder.service.PointService;
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
    private SearchResultService searchResultService;

    private String a;
    private String b;

    private String maxPrice;
    private String maxTime;
    @SuppressWarnings("FieldCanBeLocal")
    private Integer maxLevel = 3;

    private String requestValue;

    private List<List<Point>> result;

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

    public List<List<Point>> getRoutes(){

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

        this.result = searchAlgorithm.getRoutes(neighbors);
        this.requestValue = a + " - " + b;
        this.a = "";
        this.b = "";
        this.maxLevel = 4;

        return result;
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
}
