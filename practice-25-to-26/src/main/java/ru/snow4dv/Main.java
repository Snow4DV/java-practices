package ru.snow4dv;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        try {
            Document body = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
            Elements stationDivs = body.select("#metrodata > div > .js-depend > .js-metro-stations");
            Elements lineDivs = body.select("#metrodata > div > .js-toggle-depend > span");

            JsonObject object = new JsonObject();
            object.add("stations", new JsonObject());
            object.add("lines", new JsonArray());

            for (int i = 0; i < lineDivs.size(); i++) {
                String line = lineDivs.get(i).html();
                String lineNumber = lineDivs.get(i).attr("data-line");
                Elements stationsOfCurrentLine = stationDivs.get(i).select("p > a > .name");

                object.getAsJsonObject("stations").add(lineNumber, new JsonArray());
                for (Element station :
                        stationsOfCurrentLine) {
                    object.getAsJsonObject("stations").getAsJsonArray(lineNumber).add(station.html());

                }


                JsonObject lineObject = new JsonObject();
                lineObject.addProperty("number", lineNumber);
                lineObject.addProperty("name", line);

                object.getAsJsonArray("lines").add(lineObject);
            }

            System.out.println(object.toString());
        } catch(IOException ex) {
            System.err.println("Error when getting moscowmap page.");
        }
    }
}