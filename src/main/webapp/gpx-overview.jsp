<%--
  Created by IntelliJ IDEA.
  User: jappe
  Date: 15/12/2022
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp">
        <jsp:param name="title" value="GPX"/>
    </jsp:include>
    <script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <style>
        #map {
            height: 100%;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="Images"/>
</jsp:include>
<div id="container">
    <main>
<c:choose>
    <c:when test="${not empty gpxs}">

        <script>
            function initMap() {
                const brussel = { lat: 50.8553897, lng: 4.3582507 };
                const map = new google.maps.Map(document.getElementById("map"), {
                    zoom: 8,
                    center: brussel,
                });

                const locations = [

                <c:forEach items="${gpxs}" var="gpx">
                    { lat: ${gpx.lat}, lng: ${gpx.lon} },
                </c:forEach>

                ];

                console.log(locations);

                locations.forEach((position, i) => {
                    const marker = new google.maps.Marker({
                        position,
                        map,
                    });
                });

            }

            window.initMap = initMap;
        </script>


    </c:when>
    <c:otherwise>
        <p>Er zijn geen gpx locaties </p>
    </c:otherwise>
</c:choose>
        <form method="POST" action="Controller?command=addLocation">
        <p class="form-group ${latClass}">
        <label class="control-label" for="lat">Lat:</label>
        <input id="lat" name="lat" type="text"
        value="${latPreviousValue}" >
        </p>

        <p class="form-group ${lonClass}">
        <label class="control-label" for="lon">Lon:</label>
        <input id="lon" name="lon" type="text"
        value="${lonPreviousValue}">
        </p>
            <input type="submit" value="Add Location"/>

        </form>

        <div id="map"></div>
        <script
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBy0THRrjpJ9qPhGrTC6UG2cdRVAvKz6lU&callback=initMap"
                defer
        ></script>
    </main>
</div>

</body>
</html>