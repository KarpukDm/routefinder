package com.routefinder.algorithm;

import com.routefinder.model.Neighbor;
import com.routefinder.model.Point;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 23.04.2016.
 */

public class SearchAlgorithm {

    private int maxLevel;

    private String endPoint;

    private List<Neighbor> neighborList = new LinkedList<>();

    private List<Neighbor> points = new LinkedList<>();

    public SearchAlgorithm(String endPoint, int maxLevel, List<Neighbor> neighbors) {
        this.endPoint = endPoint;

        this.maxLevel = maxLevel;

    }

    public List<Neighbor> getRoutes(List<Neighbor> neighbors, int level){

       // pList.add(neighbors.get(0).getPoint());

        if(level <= maxLevel && !neighbors.get(0).getPoint().getName().equals(endPoint)){

            points.add(neighbors.get(0));
            neighbors = getRoutes(neighbors.get(0).getPoint().getNeighbors(), level + 1);
        }
        if(level > maxLevel){
            neighbors.remove(0);
            points.clear();
            //pList.clear();
        }

        if(neighbors.size() != 0 && neighbors.get(0).getPoint().getName().equals(endPoint)){
           // points = new LinkedList<>();
            //points.add(pList);
            neighborList.addAll(points);
            neighborList.add(neighbors.get(0));
            neighbors.remove(0);
        }

        return neighborList;
    }
}
