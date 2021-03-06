package com.geneculling.javakata.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.geneculling.javakata.api.Timestamper;
import com.geneculling.javakata.impl.TimestamperImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;


public class TimestamperServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(TimestamperServlet.class);
    private static final Gson GSON = new Gson();

    TimestamperServlet(){

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("Embed Servlet received request");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Date date = new Date();
        if(!request.getPathInfo().equals("/timestamper/api")) {
            String cleanString = cleanDateFromPath("/timestamper/api", request.getPathInfo());
            date = Timestamper.getDateFromMillisecondsString(cleanString);
        }

        if(null == date){
            response.getWriter().write("{ \"error\": \"Invalid Date\" }");
            response.flushBuffer();
            return;
        }
        Timestamper timestamper =  new TimestamperImpl();
        JsonObject jsonObject = timestamper.getJsonFromDate(date);
        String json = GSON.toJson(jsonObject);
        response.getWriter().write(json);
        response.flushBuffer();
    }

    private String cleanDateFromPath(String path, String rawString){
        String rawDate = rawString.substring(path.length());
        return rawDate.substring(1);
    }

}
