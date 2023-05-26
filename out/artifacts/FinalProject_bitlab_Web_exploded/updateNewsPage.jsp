<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    News news = (News) request.getAttribute("news");
%>
<html>
<head>
    <title>Update</title>
    <%@include file="title.jsp"%>
</head>
<body>

<%@include file="navbar.jsp"%>

<div class="container">

    <h3 class="mt-3 mb-3">UPDATE POST</h3>

    <form action="/update_news" method="post">
        <div class="mb-3">
            <input type="hidden" name="n_id" value="<%=news.getId()%>">

            <label class="form-label">TITLE:</label>
            <input type="text" class="form-control" name="n_title" value="<%=news.getTitle()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">CONTENT:</label>
            <textarea class="form-control" rows="5" name="n_content"><%=news.getContent()%></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">IMAGE URL:</label>
            <input type="text" class="form-control" value="<%=news.getImage()%>" name="n_image">
        </div>
        <button class="btn btn-primary" style="width: 300px">UPDATE</button>
    </form>


</div>

</body>
</html>
