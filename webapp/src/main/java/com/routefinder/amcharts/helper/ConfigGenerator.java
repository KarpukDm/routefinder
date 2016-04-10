package com.routefinder.amcharts.helper;

import com.routefinder.model.Point;

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
}
