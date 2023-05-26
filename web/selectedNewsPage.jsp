<%@ page import="java.util.ArrayList" %>
<%@ page import="db.DBManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%News news = (News) request.getAttribute("selectedNew");%>
<%
    ArrayList<Comment> comments = DBManager.getAllCommentsFromId(news.getId());
%>

<html>
<head>
    <title></title>
  <%@include file="title.jsp"%>
</head>
<body>

  <%@include file="navbar.jsp"%>

    <div class="container" style="width: 1000px">


        <h2 class="mt-3 text-center" style="font-weight: bold"><%=news.getTitle()%></h2>

        <img src="<%=news.getImage()%>" style="width: 1000px">

        <p class="p-1" style="width: 1000px; font-size: 18px"><%=news.getContent()%></p>

        <div class="col-12 mb-5" style="color: gray; font-size: 16px; margin-left: 900px">
            <%=news.getPostDate()%>
        </div>

        <form action="/add_comment" method="post">
            <div class="mb-3">
                <input type="hidden" name="news_id" value="<%=news.getId()%>">
                <textarea class="form-control mb-3" placeholder="write your comment..." rows="3" name="comment_text" style="width: 1000px"></textarea>
                <button class="btn btn-success">ADD COMMENT</button>
            </div>
        </form>

        <%
            for (Comment c: comments) {
        %>
        <hr class="hr">
        <div class="row">
            <div class="col-12" style="font-weight: bold">
                <%=c.getUser().getFullName()%>
            </div>
            <div class="col-12">
                <%=c.getComment()%>
            </div>
            <div class="col-12 pb-2" style="color: gray; font-size: 13px; margin-left: 900px">
                <%=c.getPostDate()%>
            </div>
        </div>
        <%
            }
        %>

        <%
            if (currentUser!=null && currentUser.getRole_id()==1) {
        %>

        <div class="container overflow-hidden text-center mt-3">
            <div class="row gx-5">
                <div class="col">
                    <div class="p-3">
                        <a class="btn btn-success" style="width: 300px" href="/update_news_page?id=<%=news.getId()%>">Update</a>
                    </div>
                </div>
                <div class="col">
                    <div class="p-3">
                <!-- Button trigger modal -->
                        <button type="button" class="btn btn-danger" style="width: 300px" data-bs-toggle="modal" data-bs-target="#exampleModal">
                            Delete
                        </button>
                <!-- Modal -->
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                Are you sure?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <form action="/delete_news" method="post">
                                    <input type="hidden" name="n_id" value="<%=news.getId()%>">
                                    <button type="submit" class="btn btn-danger">YES, delete</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                    </div>
                </div>
            </div>
        </div>
        <%
            }
        %>

    </div>




</body>
</html>
