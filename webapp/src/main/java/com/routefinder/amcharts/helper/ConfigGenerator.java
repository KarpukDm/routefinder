package com.routefinder.amcharts.helper;

import com.routefinder.model.Point;
import com.routefinder.model.Route;

import java.util.List;

/**
 * Created by offsp on 09.04.2016.
 */
public class ConfigGenerator {

    public String getLats(List<Point> points){

        String lats = "";
        for (Point p : points) {
            lats += p.getCoordinates().getLat().toString() + ", ";
        }

        return lats.substring(0, lats.length() - 2);
    }

    public String getLngs(List<Point> points){

        String lngs = "";
        for (Point p : points) {
            lngs += p.getCoordinates().getLng().toString() + ", ";
        }

        return lngs.substring(0, lngs.length() - 2);
    }

    public String getPointNames(List<Point> points){

        String pointNames = "";
        for (Point p : points) {
            pointNames += "{\n" +
                    "svgPath: targetSVG,\n" +
                     "title: \"" + p.getName() + "\",\n" +
                    "latitude: " + p.getCoordinates().getLat() + ",\n" +
                    "longitude: " + p.getCoordinates().getLng() + "\n" +
                    "}, ";
        }

        return pointNames.substring(0, pointNames.length() - 2  );
    }

    public String getZoomLat(List<Point> points){
        double lat = 0;
        for(Point p : points){
            lat += p.getCoordinates().getLat();
        }

        return String.valueOf((lat / points.size()));
    }

    public String getZoomLng(List<Point> points){
        double lng = 0;
        for(Point p : points){
            lng += p.getCoordinates().getLng();
        }

        return String.valueOf((lng / points.size()));
    }

    public String getZoomLevel(Route route){

        return String.valueOf(14000 / route.getDistance() * 0.5);
    }
}
