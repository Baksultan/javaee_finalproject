package servlets;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/add_news_page")
public class AddNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("current_user");
        if (user!=null && user.getRole_id()==1) {
            req.getRequestDispatcher("/addNews.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/home");
        }
    }


}
