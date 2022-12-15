package ui.controller;

import domain.model.Location;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class addLocation extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();
        Location location = new Location();
        setLongitude(location, request, errors);
        setLatitude(location, request, errors);

        if (errors.size() == 0) {
            service.addLocation(location);
            HttpSession session = request.getSession();
            return "Controller?command=GPXoverview";
        }
        else {
            request.setAttribute("errors", errors);
            return "Controller?command=GPXoverview";
        }

    }

    private void setLongitude(Location location, HttpServletRequest request, ArrayList<String> errors){
        Double lon = Double.parseDouble(request.getParameter("lon"));
        try{
            location.setLongitude(lon);
            request.setAttribute("lon", lon);
        } catch (Exception e){
            errors.add(e.getMessage());
        }
    }

    private void setLatitude(Location location, HttpServletRequest request, ArrayList<String> errors){
        Double lat = Double.parseDouble(request.getParameter("lat"));
        try{
            location.setLatitude(lat);
            request.setAttribute("lat", lat);
        } catch (Exception e){
            errors.add(e.getMessage());
        }
    }
}
