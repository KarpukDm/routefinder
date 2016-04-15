package com.routefinder.translator.yandex.api;

/**
 * Created by offsp on 15.04.2016.
 */
@SuppressWarnings("FieldCanBeLocal")
public class LinksCollectorYandex {

    private String mainLink = "https://translate.yandex.net/api/v1.5/tr.json/translate?";
    private String key = "trnsl.1.1.20160415T085258Z.1c0e8b26cbc7e6e1.52e209229762d428bde51e41cbe6684f2ffcb1ee";
    private String text = "";
    private String lang = "en";
    private String format = "plain";
    private String options = "1";

    public String getLink(String text) {

        text = text.replace(" ", "%20");

        return this.mainLink +
                "key=" + this.key + "&" +
                "text=" + text + "&" +
                "lang=" + this.lang + "&" +
                "format=" + this.format + "&" +
                "options" + this.options;
    }

}
