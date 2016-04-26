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

    private List<List<Point>> points;

    private List<Point> pList = new LinkedList<>();

    private String endPoint;

    private List<Neighbor> neighborList = new LinkedList<>();

    private List<Neighbor> neighbors;

    public SearchAlgorithm(String endPoint, int maxLevel, List<Neighbor> neighbors) {
        this.endPoint = endPoint;
        points = new LinkedList<>();
        this.maxLevel = maxLevel;
        this.neighbors = neighbors;
    }

    public List<Neighbor> getRoutes(List<Neighbor> neighbors, int level){

        pList.add(neighbors.get(0).getPoint());

        if(level <= maxLevel && !neighbors.get(0).getPoint().getName().equals(endPoint)){

            neighbors = getRoutes(neighbors.get(0).getPoint().getNeighbors(), level + 1);
        }
        if(level > maxLevel){
            neighbors.remove(0);
            pList.clear();
        }

        if(neighbors.size() != 0 && neighbors.get(0).getPoint().getName().equals(endPoint)){
            points = new LinkedList<>();
            points.add(pList);
            neighborList.add(neighbors.get(0));
            neighbors.remove(0);
        }

        return neighborList;
    }
}
