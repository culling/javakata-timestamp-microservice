package com.geneculling.javakata.impl;

import com.atlassian.jira.util.json.JSONObject;
import com.geneculling.javakata.api.Timestamper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.time.Instant;
import java.time.ZoneOffset;
import java.util.Date;

class DateJson{
    public long unix;
    public String utc;
}

public class TimestamperImpl implements Timestamper {
    public Gson GSON = new Gson();

    @Override
    public JsonElement getJsonFromDate(Date date) {
        DateJson dateJson = new DateJson();
        dateJson.unix = date.getTime();
        dateJson.utc = Instant.ofEpochMilli( date.getTime()).atZone(ZoneOffset.UTC).toString();
        String json = GSON.toJson(dateJson);
        return GSON.fromJson(json, JsonElement.class);
    }


}
