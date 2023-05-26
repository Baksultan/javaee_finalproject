package servlets;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/profile")
public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User currntUser = (User) req.getSession().getAttribute("current_user");
        if (currntUser!=null) {
            req.setAttribute("user", currntUser);
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/sign_in");
        }


    }
}
