package com.routefinder.maps.google.api.helper;

import com.routefinder.model.Point;

import static java.lang.Math.*;

/**
 * Created by offsp on 09.04.2016.
 */
public class DistanceCalculator {

    public Double getDistance(Point a, Point b) {

        return 111.2 * Math.sqrt(Math.pow((a.getCoordinates().getLng() - b.getCoordinates().getLng()), 2) +
                (a.getCoordinates().getLat() - b.getCoordinates().getLat()) * Math.cos(Math.PI * a.getCoordinates().getLng() / 180) *
                        (a.getCoordinates().getLat() - b.getCoordinates().getLat()) * Math.cos(Math.PI * a.getCoordinates().getLng() / 180));
    }


}
