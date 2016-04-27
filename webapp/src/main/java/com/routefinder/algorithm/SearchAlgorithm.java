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

    public List<Neighbor> getRoutes(List<Neighbor> neighbors, int level) {

        for(Neighbor n : neighbors){
            neighborList.add(n);
            if(!n.getPoint().getName().equals(endPoint) && level <= maxLevel){

                getRoutes(n.getPoint().getNeighbors(), level + 1);
            }

            if(level > maxLevel){
                neighborList.remove(n);
                return null;
            }
        }



        return neighborList;
    }
}
