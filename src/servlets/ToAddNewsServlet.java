package servlets;

import db.DBManager;
import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add_news")
public class ToAddNewsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("current_user");
        if (user!=null && user.getRole_id()==1) {
            String newsTitle = req.getParameter("news_title");
            String newsContent = req.getParameter("news_content");
            String newsImg = req.getParameter("news_img");
            int newsCategoryId = Integer.parseInt(req.getParameter("news_category"));
            News news = new News();
            news.setTitle(newsTitle);
            news.setContent(newsContent);
            news.setImage(newsImg);
            news.setCategoryId(newsCategoryId);
            DBManager.addNews(news);
            resp.sendRedirect("/add_news_page");
        } else {
            resp.sendRedirect("/sign_in");
        }
    }
}
