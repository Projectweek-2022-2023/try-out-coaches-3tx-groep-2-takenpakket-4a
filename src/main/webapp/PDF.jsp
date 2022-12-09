<%--
  Created by IntelliJ IDEA.
  User: jappe
  Date: 09/12/2022
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="head.jsp">
    <jsp:param name="title" value="PDF"/>
  </jsp:include>

</head>
<body>
<div id="container">
  <jsp:include page="header.jsp">
    <jsp:param name="actual" value="PDF"/>
  </jsp:include>
<main>

  <p>Show pdf</p>
  <a href="${pageContext.request.contextPath}/pdf">link to pdf</a>
</main>
<jsp:include page="footer.jsp"/>
</div>
</body>
</html>
