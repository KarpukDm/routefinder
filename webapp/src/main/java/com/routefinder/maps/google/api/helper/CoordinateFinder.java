package com.routefinder.maps.google.api.helper;

import com.routefinder.translator.Translator;
import com.routefinder.model.Coordinates;
import com.routefinder.model.Point;
import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by offsp on 08.04.2016.
 */
public class CoordinateFinder {

    private Double lng;
    private Double lat;

    public Point getPoint(String address) throws IOException, JSONException {

        getCoordinate(address);

        return new Point(address, new Coordinates(lat, lng));
    }

    private void getCoordinate(String address) throws IOException, JSONException {
        String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json";// путь к Geocoding API по HTTP
        Map<String, String> params = new HashMap<>();
        params.put("sensor", "false");// исходит ли запрос на геокодирование от устройства с датчиком местоположения
        params.put("address", new Translator().translate(address));// адрес, который нужно геокодировать
        String url = baseUrl + '?' + Encoder.getParams(params);// генерируем путь с параметрами

        System.out.println(url);// Путь, что бы можно было посмотреть в браузере ответ службы

        String jsonString = callURL(url);
        JSONObject response = new JSONObject(jsonString);        ;
        JSONArray ResultArr = response.getJSONArray("results");
        JSONObject ResultObj = ResultArr.getJSONObject(0);
        JSONObject Geometry = ResultObj.getJSONObject("geometry");
        JSONObject Location = Geometry.getJSONObject("location");
        this.lat = Location.getDouble("lat");
        this.lng = Location.getDouble("lng");

        System.out.println(String.format("%f,%f", lat, lng));// итоговая широта и долгота
    }

    public String callURL(String myURL) {
        System.out.println("Requested URL:" + myURL);
        StringBuilder sb = new StringBuilder();
        URLConnection urlConn = null;
        InputStreamReader in = null;
        try {
            URL url = new URL(myURL);
            urlConn = url.openConnection();
            if (urlConn != null)
                urlConn.setReadTimeout(60 * 1000);
            if (urlConn != null && urlConn.getInputStream() != null) {
                in = new InputStreamReader(urlConn.getInputStream(),
                        Charset.defaultCharset());
                BufferedReader bufferedReader = new BufferedReader(in);
                int cp;
                while ((cp = bufferedReader.read()) != -1) {
                    sb.append((char) cp);
                }
                bufferedReader.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (Exception e) {
            throw new RuntimeException("Exception while calling URL:"+ myURL, e);
        }

        return sb.toString();
    }

}
