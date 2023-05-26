<%@ page import="java.util.ArrayList" %>
<%@ page import="db.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<NewsCategory> newsCategoryArrayList = DBManager.getAllNewsCategories();
%>
<html>
<head>
    <title>Add News</title>
  <%@include file="title.jsp"%>
</head>
<body>
  <%@include file="navbar.jsp"%>

<div class="container">

    <h3 class="mb-4 mt-3">ADD NEWS</h3>

    <form action="/add_news" method="post">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" placeholder="input news name" name="news_title">
            <label>Title</label>
        </div>

        <div class="form-floating mb-3">
            <textarea class="form-control" placeholder="input news content text" style="height: 300px" name="news_content"></textarea>
            <label>News content</label>
        </div>

        <div class="form-floating mb-3">
            <input type="text" class="form-control" placeholder="name@example.com" name="news_img">
            <label>Image URL</label>
        </div>

        <select class="form-select mb-3" aria-label="Default select example" name="news_category">
            <%
                for (NewsCategory i: newsCategoryArrayList) {
            %>
            <option value=<%=i.getId()%>><%=i.getName()%></option>
            <%
                }
            %>
        </select>

        <button class="btn btn-success">ADD NEWS</button>
    </form>



</div>

</body>
</html>
