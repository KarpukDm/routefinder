package com.routefinder.algorithm;

import com.routefinder.model.Point;
import com.routefinder.model.Route;
import com.routefinder.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by offsp on 23.04.2016.
 */

public class SearchAlgorithm {

    private List<List<Route>> result = new LinkedList<>();

    private List<Point> query = new LinkedList<>();

    private List<Route> routes;

    public SearchAlgorithm(List<Route> routes) {
        this.routes = routes;
    }

    public List<List<Route>> findRoute(String a, String b) {

        int r = find(routes, a);

        for(int i = 0; i < query.size(); i++){

            if(result.size() < 5){
                r = find(query.get(i).getRoutes(), query.get(i).getName());
            }
        }

        return result;
    }

    private int find(List<Route> routes, String a) {

        for (int i = 0; i < routes.size(); i++) {

            result.add(new LinkedList<Route>());
            for (int j = 0; j < routes.get(i).getPoints().size(); j++) {

                if (routes.get(i).getPoints().get(j).getName().equals(a)) {
                    result.get(i).add(routes.get(i));
                }
                if(!query.contains(routes.get(i).getPoints().get(j))) {
                    query.add(routes.get(i).getPoints().get(j));
                }
            }
        }

        return 1;
    }
}
