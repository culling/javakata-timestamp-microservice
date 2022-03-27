package com.geneculling.javakata.impl;

import com.atlassian.jira.util.json.JSONObject;
import com.geneculling.javakata.api.Timestamper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.TimeZone;

class DateJson{
    public long unix;
    public String utc;
}

public class TimestamperImpl implements Timestamper {
    public Gson GSON = new Gson();

    @Override
    public JsonObject getJsonFromDate(Date date) {
        DateJson dateJson = new DateJson();
        dateJson.unix = date.getTime();
        dateJson.utc = getUtcString(date);
        String json = GSON.toJson(dateJson);
        return GSON.fromJson(json, JsonElement.class).getAsJsonObject();
    }

    public static String getUtcString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        return format.format(date);
    }


}
