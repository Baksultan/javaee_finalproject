<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Sign In</title>
    <%@include file="title.jsp"%>
</head>

<body>

    <%@include file="navbar.jsp"%>


    <div class="container" style="width: 1000px">




        <div style="padding: 20px; display: flex; flex-direction: column; align-items: center;">
            <h1 style="margin-bottom: 20px">Sign In</h1>

            <form action="/sign_in" method="post">

                <div class="mb-4 mt-3">
                    <label for="exampleFormControlInput1" class="form-label"><strong>Email address</strong></label>
                    <input type="email" class="form-control" id="exampleFormControlInput1" required placeholder="name@example.com" name="email" <%if (request.getAttribute("email") != null) {%>value = <%=request.getAttribute("email")%><%}%>>
                </div>

                <label for="inputPassword5" class="form-label"><strong>Password</strong></label>
                <input type="password" id="inputPassword5" class="form-control" required aria-labelledby="passwordHelpBlock" name="password">
                <div id="passwordHelpBlock" class="form-text" style="margin-bottom: 30px; width: 810px; margin-left: 5px">

                </div>

                <button class="btn btn-success" style="width: 150px">Sign in</button>
            </form>


        </div>




    </div>


</body>
</html>
