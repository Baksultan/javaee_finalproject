<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign Up</title>
  <%@include file="title.jsp"%>
</head>

<body>

  <%@include file="navbar.jsp"%>

  <div class="container" style="width: 1000px">


    <div style="padding: 20px; display: flex; flex-direction: column; align-items: center;">
      <h1 style="margin-bottom: 20px">Sign Up</h1>

      <form action="/sign_up" method="post">

        <div class="mb-4 mt-3">
          <label for="exampleFormControlInput1" class="form-label"><strong>FULL NAME</strong></label>
          <input type="text" class="form-control" id="exampleFormControlInput1" name="full_name" placeholder="Full name">
        </div>

        <div class="mb-4 mt-3">
          <label for="exampleFormControlInput1" class="form-label"><strong>EMAIL ADDRESS</strong></label>
          <input type="email" class="form-control" id="exampleFormControlInput2" placeholder="name@example.com" name="email">
        </div>

        <label for="inputPassword5" class="form-label"><strong>PASSWORD</strong></label>
        <input type="password" id="inputPassword5" class="form-control" aria-labelledby="passwordHelpBlock" name="password" placeholder="Password">
        <div id="passwordHelpBlock" class="form-text" style="margin-bottom: 30px">
          Your password must be 8-20 characters long, contain letters and numbers, and must not contain spaces, special characters, or emoji.
        </div>


        <label for="inputPassword5" class="form-label"><strong>REPEAT PASSWORD</strong></label>
        <input style="margin-bottom: 30px" type="password" id="inputPassword6" class="form-control" aria-labelledby="passwordHelpBlock" name="repeat_password" placeholder="Repeat password">


        <button class="btn btn-success" style="width: 150px;">Sign up</button>
      </form>
    </div>




  </div>


</body>
</html>