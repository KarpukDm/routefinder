package com.routefinder.bean;

import com.routefinder.algorithm.SearchAlgorithm;
import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    private String a;
    private String b;


    private List<List<Route>> result;

    public void findRoute(){

        Point points = pointService.findOneByName(this.b);

        this.result = new SearchAlgorithm(points.getRoutes()).findRoute(a, b);
        int x = 0;
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

    public List<List<Route>> getResult() {
        return result;
    }

    public void setResult(List<List<Route>> result) {
        this.result = result;
    }
}
