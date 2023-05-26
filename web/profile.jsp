<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) request.getAttribute("user");
%>

<html>
<head>
  <title>Sign In</title>
  <%@include file="title.jsp"%>
</head>

<body>

<%@include file="navbar.jsp"%>


<div class="container" style="width: 1000px">

  <h1>Hello <%=user.getFullName()%>!!!</h1>




</div>


</body>
</html>
