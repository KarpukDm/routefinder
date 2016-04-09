package com.routefinder.maps.google.api.helper;

import java.util.Map;

/**
 * Created by offsp on 08.04.2016.
 */
public class Encoder {

    public static String getParams(Map<String, String> params) {

        String url = "";

        for(Map.Entry<String, String> x : params.entrySet()){
            url += x.getKey() + "=" + x.getValue() + "&";
        }
        return url;
    }
}
