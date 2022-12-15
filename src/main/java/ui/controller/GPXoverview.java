package ui.controller;

import domain.model.Location;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Dictionary;

public class GPXoverview extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("gpxs", service.getAllLocations());


        return "gpx-overview.jsp";
    }
}

