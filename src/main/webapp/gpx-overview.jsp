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
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="Images"/>
</jsp:include>
<div id="container">
    <main>
<c:choose>
    <c:when test="${not empty gpxs}">
<table>
            <tr>
                <th>GPX</th>
                <th>Actions</th>
            </tr>
    <c:if test="$not empty gpxs"></c:if>
            <c:forEach items="${gpxs}" var="gpx">
                <tr>
                    <p><a href="https://api.opencagedata.com/geocode/v1/json?q=${gpx.lat}+${gpx.lon}&key=03c48dae07364cabb7f121d8c1519492&no_annotations=1&language=en">${gpx.lat} ${gpx.lon}</a></p>


                </tr>
            </c:forEach>
        </table>
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

    </main>
</div>

</body>
</html>