<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.swing.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>BITLAB NEWS</title>
    <%@include file="title.jsp"%>
</head>


<body>
    <%@include file="navbar.jsp"%>
    <div class="container text-center" style="width: 1000px">

        <div class="container text-center" style="margin-bottom: 50px">


            <div class="row row-cols-1 row-cols-md-2 g-4 mt-5">
                <%
                    ArrayList<News> news = (ArrayList<News>) request.getAttribute("news");
                    for (News i: news) {
                %>
                <div class="col">
                    <div class="card" style="">
                        <img src="<%=i.getImage()%>" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"><%if(i.getTitle().length() >= 86) {
                                String title = i.getTitle();
                                String resultTitle = "";
                                for (int k=0; k<86; k++) {
                                    resultTitle+=title.charAt(k);
                                }
                                out.print(resultTitle + "...");
                            } else {
                                out.print(i.getTitle());
                            }
                            %></h5>
                            <p class="card-text">
                                <%if(i.getContent().length() >= 300) {
                                    String content = i.getContent();
                                    String resultContent = "";
                                    for (int k=0; k<297; k++) {
                                        resultContent+=content.charAt(k);
                                    }
                                    out.print(resultContent + "...");
                                } else {
                                    out.print(i.getContent());
                                }
                                %>
                            </p>

                            <a class="btn btn-success" href="/selected_news_page?id=<%=i.getId()%>">READ MORE</a>


                        </div>
                    </div>
                </div>

                <%
                    }
                %>

            </div>




        </div>


    </div>



</body>
</html>
