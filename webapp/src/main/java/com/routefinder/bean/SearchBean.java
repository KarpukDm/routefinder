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

    private Integer maxLevel = 4;


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
