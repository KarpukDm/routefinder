package com.routefinder.bean;

import com.routefinder.algorithm.SearchAlgorithm;
import com.routefinder.model.Neighbor;
import com.routefinder.model.Point;
import com.routefinder.service.PointService;
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

    private String a;
    private String b;

    public List<Point> getRoutes(){

        Point points = pointService.findOneByName(this.a);

        if(a == null || b == null){
            return null;
        }

        SearchAlgorithm searchAlgorithm = new SearchAlgorithm(b, 4, points.getNeighbors());

        List<Neighbor> neighbors = searchAlgorithm.getRoutes(points.getNeighbors(), 0);

        List<Point> result = new LinkedList<>();
        result.add(points);

        for(Neighbor n : neighbors){
            result.add(n.getPoint());
        }

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
}
