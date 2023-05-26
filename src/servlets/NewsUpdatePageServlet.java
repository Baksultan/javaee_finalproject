package servlets;

import db.DBManager;
import models.News;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/update_news_page")
public class NewsUpdatePageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currntUser = (User) req.getSession().getAttribute("current_user");
        if (currntUser!=null && currntUser.getRole_id()==1) {
            int id = Integer.parseInt(req.getParameter("id"));
            News news = DBManager.getNewById(id);
            req.setAttribute("news", news);
            req.getRequestDispatcher("/updateNewsPage.jsp").forward(req, resp);
        }else if (currntUser!=null && currntUser.getRole_id()==2){
            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("/sign_in");
        }
    }
}
