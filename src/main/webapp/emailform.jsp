<%--
  Created by IntelliJ IDEA.
  User: jappe
  Date: 09/12/2022
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="head.jsp">
    <jsp:param name="title" value="Email"/>
  </jsp:include>



</head>
<body>
<div id="container">
  <header>
  <jsp:include page="header.jsp">
    <jsp:param name="actual" value="Email Versturen"/>
  </jsp:include>
  </header>
  <main>

    <c:if test="${not empty errors}">
      <div class="alert alert-danger">
        <ul>
          <c:forEach items="${errors}" var="error">
            <li>${error}</li>
          </c:forEach>
        </ul>
      </div>
    </c:if>
    <h2>Voeg je huisdier toe</h2>

    <form method="POST" action="Controller?command=Email">

      <p class="form-group ${recieveClass}">
        <label class="control-label" for="reciever">Ontvanger:</label>
        <input id="reciever" name="reciever" type="text"
               value="${recievePreviousValue}" >
      </p>

      <p class="form-group ${subjectClass}">
        <label class="control-label" for="subject">Onderwerp:</label>
        <input id="subject" name="subject" type="text"
               value="${subjectPreviousValue}">
      </p>

      <p class="form-group ${messageClass}">
        <label class="control-label" for="message">Bericht</label>
        <input
                id="message" name="message" type="textbox"
                value="${messagePreviousValue}">
      </p>
      <p>
        <input id="submit" type="submit" value="Verstuur">
      </p>
    </form>
  </main>
  <jsp:include page="footer.jsp"/>

</body>
</html>
