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

    private List<List<Point>> routePoints = new LinkedList<>();

    private List<Point> rp = new LinkedList<>();

    public SearchAlgorithm(String endPoint, int maxLevel) {
        this.endPoint = endPoint;

        this.maxLevel = maxLevel;

    }

    private List<Neighbor> getRoutes(List<Neighbor> neighbors, int level) {

        for(int i = 0; i < neighbors.size(); i++){

            if(neighbors.get(i) != null) {

                if(!rp.contains(neighbors.get(i).getPoint())) {
                    rp.add(neighbors.get(i).getPoint());
                }

                if (!neighbors.get(i).getPoint().getName().equals(endPoint) && level < maxLevel) {

                    neighbors.get(i).getPoint().setNeighbors(getRoutes(neighbors.get(i).getPoint().getNeighbors(), level + 1));
                }

                if (level > maxLevel || (neighbors.get(i).getPoint().getNeighbors() == null
                        || neighbors.get(i).getPoint().getNeighbors().size() == 0)) {

                    neighbors.remove(i);
                    i--;

                    rp = rp.subList(0, level);

                    continue;
                }

                if (neighbors.get(i).getPoint().getName().equals(endPoint)) {

                    List<Point> x = new LinkedList<>();
                    x.addAll(rp);
                    routePoints.add(x);
                    rp = rp.subList(0, level);

                    neighbors.remove(i);
                    i--;
                }
            }

            rp = rp.subList(0, level);
        }

        return neighbors;
    }

    public List<List<Point>> getRoutes(List<Neighbor> neighbors) {

        if(neighbors.get(0).getPoint() == null){
            return null;
        }
        getRoutes(neighbors, 0);

        for(int i = 0; i < routePoints.size(); i++){

            if(routePoints.get(i).size() > maxLevel + 2){

                routePoints.remove(i);
                i--;
            }
        }

        for(int i = 0; i < routePoints.size(); i++){

            boolean flag = true;

            for(int j = 0; j < routePoints.get(i).size(); j++){

                for(int l = 0; l < routePoints.get(i).size(); l++){

                    if(routePoints.get(i).get(j).getName().equals(routePoints.get(i).get(l).getName()) && j != l) {
                        routePoints.remove(i);
                        flag = false;
                        break;
                    }
                }

                if(!flag){
                    i--;
                    break;
                }
            }
        }

        return routePoints;
    }

}
