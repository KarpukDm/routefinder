package com.routefinder.translator;

import com.routefinder.translator.yandex.api.LinksCollectorYandex;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import java.io.IOException;

import static com.routefinder.readers.URLConnectionReader.httpGet;

/**
 * Created by offsp on 09.04.2016.
 */
public class Translator {

    public String translate(String city) throws JSONException, IOException, IllegalAccessException {

        LinksCollectorYandex linksCollectorYandex = new LinksCollectorYandex();
        String link = linksCollectorYandex.getLink(city);

        String jsonString = httpGet(link);
        JSONObject response = new JSONObject(jsonString);
        JSONArray resultArr = response.getJSONArray("text");

        return resultArr.toString();
    }
}
