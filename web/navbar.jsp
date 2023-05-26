<%@ page import="models.*" %>
<%
  User currentUser = (User) request.getSession().getAttribute("current_user");
%>

<nav class="navbar navbar-expand-lg bg-body-tertiary bg-success navbar-dark">
  <div class="container-fluid" style="width: 1000px">
    <a class="navbar-brand" style="font-weight: bold" href="/">BITLAB NEWS</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

          <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="/">Home</a>
          </li>

        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Categories
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/">All news</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/sport">Sport</a></li>
            <li><a class="dropdown-item" href="/policy">Policy</a></li>
            <li><a class="dropdown-item" href="/sAndT">Science & Technology</a></li>
          </ul>
        </li>

        <%
          if (currentUser!=null) {
        %>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            <%=currentUser.getFullName()%>
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="/profile">Profile</a></li>
            <li><a class="dropdown-item" href="/">Settings</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/logout">Logout</a></li>
          </ul>
        </li>

        <%
          if (currentUser!=null && currentUser.getRole_id() == 1) {
        %>

        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/add_news_page">ADD NEWS</a>
        </li

        <%
          }
        %>

        <%
          }else {
        %>
        <li class="nav-item">
          <a class="nav-link" href="/sign_in">SIGN IN</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/sign_up">SIGN UP</a>
        </li>
        <%
          }
        %>




      </ul>
    </div>
  </div>
</nav>