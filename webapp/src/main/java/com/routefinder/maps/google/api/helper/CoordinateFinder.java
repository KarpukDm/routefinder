package com.routefinder.maps.google.api.helper;

import com.routefinder.model.Coordinates;
import com.routefinder.model.Point;
import com.routefinder.translator.Translator;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.routefinder.readers.URLConnectionReader.httpGet;

/**
 * Created by offsp on 08.04.2016.
 */
public class CoordinateFinder {

    private Double lng;
    private Double lat;

    public Point getPoint(String address) throws IOException, JSONException, IllegalAccessException {

        getCoordinate(address);

        return new Point(address, new Coordinates(lat, lng));
    }

    private void getCoordinate(String address) throws IOException, JSONException, IllegalAccessException {
        String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json";// путь к Geocoding API по HTTP
        Map<String, String> params = new HashMap<>();
        params.put("sensor", "false");// исходит ли запрос на геокодирование от устройства с датчиком местоположения
        params.put("address", address);// адрес, который нужно геокодировать
        String url = baseUrl + '?' + LinksCollectorGoogle.getParams(params);// генерируем путь с параметрами

        System.out.println(url);// Путь, что бы можно было посмотреть в браузере ответ службы

        String jsonString = httpGet(url);
        JSONObject response = new JSONObject(jsonString);        ;
        JSONArray ResultArr = response.getJSONArray("results");
        JSONObject ResultObj = ResultArr.getJSONObject(0);
        JSONObject Geometry = ResultObj.getJSONObject("geometry");
        JSONObject Location = Geometry.getJSONObject("location");
        this.lat = Location.getDouble("lat");
        this.lng = Location.getDouble("lng");

        System.out.println(String.format("%f,%f", lat, lng));// итоговая широта и долгота
    }

}
