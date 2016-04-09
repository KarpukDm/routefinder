package com.routefinder.maps.google.api.helper;

import com.routefinder.model.Point;

import static java.lang.Math.*;

/**
 * Created by offsp on 09.04.2016.
 */
public class DistanceCalculator {

    private double deg2rad(final double degree) {
        return degree * (Math.PI / 180);
    }

    public Double getDistance(Point a, Point b){

        double dlng = deg2rad(a.getCoordinates().getLng() - b.getCoordinates().getLng());
        double dlat = deg2rad(a.getCoordinates().getLat() - b.getCoordinates().getLat());
        double x = sin(dlat / 2) * sin(dlat / 2) + cos(deg2rad(b.getCoordinates().getLat()))
                * cos(deg2rad(a.getCoordinates().getLat())) * sin(dlng / 2) * sin(dlng / 2);
        double c = 2 * atan2(sqrt(x), sqrt(1 - x));

        double EARTH_RADIUS = 637.1;
        return c * EARTH_RADIUS;
    }


}
