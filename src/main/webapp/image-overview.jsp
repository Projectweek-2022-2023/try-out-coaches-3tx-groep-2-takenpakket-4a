
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="head.jsp">
  <jsp:param name="title" value="Images"/>
</jsp:include>
<body>
<div id="container">
  <jsp:include page="header.jsp">
    <jsp:param name="actual" value="Images"/>
  </jsp:include>
  <main>
    <h2>Images</h2>
    ${message}
    <h3>File Upload:</h3>
    Select a file to upload: <br />
    <form action="Controller?command=ImageUpload" method="post"
          enctype="multipart/form-data">
      <input type="file" name="image" size="50" style="padding: 3rem" />
      <input type="submit" value="Upload Image" />
    </form>
    <c:if test="${not empty images}">
      <c:forEach var="image" items="${images}">
        <img src="uploads/${image}" style="width: 20rem">
      </c:forEach>
    </c:if>
  </main>
</div>
</body>
</html>
