package com.geneculling.javakata.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Date;

public interface Timestamper {
    JsonElement getJsonFromDate(Date date);

    static Date getDateFromMillisecondsString(String string) {
        try {
            Long milliseconds = Long.parseLong(string);
            Date date = new Date(milliseconds);
            return date;
        } catch(NumberFormatException exception){
            return null;
        }
    }

}
