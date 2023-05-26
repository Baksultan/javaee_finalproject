package servlets;

import db.DBManager;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/sign_up")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signUp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String fullName = req.getParameter("full_name");
        String password = req.getParameter("password");
        String repeatPassword = req.getParameter("repeat_password");

        if (DBManager.getUser(email) == null && password.equals(repeatPassword)) {
            User user = new User();
            user.setFullName(fullName);
            user.setEmail(email);
            user.setPassword(password);
            DBManager.addUser(user);
            resp.sendRedirect("/sign_in");
        } else {
            resp.sendRedirect("/sign_up?");
        }
    }
}
