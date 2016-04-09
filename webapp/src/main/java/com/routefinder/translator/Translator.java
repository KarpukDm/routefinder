package com.routefinder.translator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by offsp on 09.04.2016.
 */
public class Translator {

    private static final Map<String, String> associations;

    static {
        associations = new HashMap<>();
        associations.put("а", "a");
        associations.put("б", "b");
        associations.put("в", "v");
        associations.put("г", "g");
        associations.put("д", "d");
        associations.put("е", "e");
        associations.put("ё", "yo");
        associations.put("ж", "j");
        associations.put("з", "z");
        associations.put("и", "i");
        associations.put("й", "j");
        associations.put("к", "k");
        associations.put("л", "l");
        associations.put("м", "m");
        associations.put("н", "n");
        associations.put("о", "o");
        associations.put("п", "p");
        associations.put("р", "r");
        associations.put("с", "s");
        associations.put("т", "t");
        associations.put("у", "u");
        associations.put("ф", "f");
        associations.put("х", "h");
        associations.put("ц", "c");
        associations.put("ч", "ch");
        associations.put("ш", "sh");
        associations.put("щ", "shch");
        associations.put("ъ", "j");
        associations.put("ы", "i");
        associations.put("ь", "");
        associations.put("э", "e");
        associations.put("ю", "yu");
        associations.put("я", "ya");
        associations.put("-", "-");
        associations.put(" ", " ");
    }

    public String translate(String city) {

        try {
            String cityTranslate = "";
            for (char l : city.toCharArray()) {
                cityTranslate += associations.get(String.valueOf(l).toLowerCase());
            }
            return cityTranslate;
        }catch (Exception e){
            return city;
        }
    }
}
