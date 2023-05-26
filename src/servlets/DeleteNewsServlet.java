package servlets;

import db.*;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/delete_news")
public class DeleteNewsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/home";
        User currntUser = (User) req.getSession().getAttribute("current_user");
        if (currntUser!=null && currntUser.getRole_id()==1) {
            Long id = Long.valueOf(req.getParameter("n_id"));
            DBManager.deleteNews(id);
        } else {
            redirect = "/sign_in";
        }

        resp.sendRedirect(redirect);
    }

}
