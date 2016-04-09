package com.routefinder.amcharts.helper;

import com.routefinder.model.Point;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import java.util.List;

/**
 * Created by offsp on 09.04.2016.
 */
public class ConfigGeneratorJson {

    public JSONObject generateJson(List<Point> points) throws JSONException {
        JSONObject root = new JSONObject();
        root.put("type", "map");

        JSONObject dataProvider = new JSONObject();

        dataProvider.put("map", "worldLow");
        dataProvider.put("zoomLevel", "3.5");
        dataProvider.put("zoomLongitude", "-55");
        dataProvider.put("zoomLatitude", "42");


        JSONObject lines = new JSONObject();

        JSONObject line1 = new JSONObject();
        line1.put("id", "line1");
        line1.put("arc", "-0.85");
        line1.put("alpha", "0.3");

        JSONArray latitudes = new JSONArray();
        JSONArray longitudes = new JSONArray();
        for (Point p : points) {
            latitudes.put(p.getCoordinates().getLat());
            longitudes.put(p.getCoordinates().getLng());
        }
        line1.put("latitudes", latitudes);
        line1.put("longitudes", longitudes);

        JSONObject line2 = new JSONObject();
        line2.put("id", "line2");
        line2.put("alpha", "0");
        line2.put("color", "#000000");
        line2.put("latitudes", latitudes);
        line2.put("longitudes", longitudes);

        lines.put("lines", line1);
        lines.put("lines", line2);

        JSONObject images = new JSONObject();
        for(Point p : points){
            JSONObject city = new JSONObject();
            city.put("svgPath", "targetSVG");
            city.put("title", p.getName());
            city.put("latitude", p.getCoordinates().getLat());
            city.put("longitude", p.getCoordinates().getLng());
            images.put("images", city);
        }
        JSONObject lineSVG = new JSONObject();
        lineSVG.put("svgPath","planeSVG");
        lineSVG.put("positionOnLine","0");
        lineSVG.put("color","#000000");
        lineSVG.put("alpha","0.1");
        lineSVG.put("animateAlongLine","true");
        lineSVG.put("lineId","line2");
        lineSVG.put("flipDirection","true");
        lineSVG.put("loop","true");
        lineSVG.put("scale","0.03");
        lineSVG.put("positionScale","1.3");
        lineSVG.put("","");

        images.put("images", lineSVG);

        JSONObject lineSVG2 = new JSONObject();
        lineSVG2.put("svgPath", "planeSVG");
        lineSVG2.put("positionOnLine", "0");
        lineSVG2.put("color", "#585869");
        lineSVG2.put("animateAlongLine", "true");
        lineSVG2.put("lineId", "line1");
        lineSVG2.put("flipDirection", "true");
        lineSVG2.put("loop", "true");
        lineSVG2.put("scale", "0.03");
        lineSVG2.put("positionScale", "1.8");

        images.put("images", lineSVG2);

        JSONObject areasSettings = new JSONObject();
        JSONObject unlistedAreasColor = new JSONObject();
        unlistedAreasColor.put("unlistedAreasColor", "#8dd9ef");
        areasSettings.put("areasSettings", unlistedAreasColor);


        JSONObject imagesSettings = new JSONObject();
        JSONObject is = new JSONObject();
        is.put("color", "#585869");
        is.put("rollOverColor", "#585869");
        is.put("selectedColor", "#585869");
        is.put("pauseDuration", "0.2");
        is.put("animationDuration", "2.5");
        is.put("adjustAnimationSpeed", "true");

        imagesSettings.put("imagesSettings", is);

        JSONObject linesSettings = new JSONObject();
        JSONObject ls = new JSONObject();
        ls.put("color", "#585869");
        ls.put("alpha", "0.4");

        linesSettings.put("linesSettings", ls);

        JSONObject export = new JSONObject();
        JSONObject exp = new JSONObject();
        exp.put("enabled", "true");

        export.put("export", exp);


        dataProvider.put("lines", lines);
        dataProvider.put("images", images);

        root.put("dataProvider", dataProvider);
        root.put("areasSettings", areasSettings);
        root.put("imagesSettings", imagesSettings);
        root.put("linesSettings", linesSettings);
        root.put("export", export);

        return root;
    }
}
