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

@WebServlet(value = "/update_news")
public class NewsUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User currntUser = (User) req.getSession().getAttribute("current_user");
        if (currntUser!=null && currntUser.getRole_id()==1) {
            int id = Integer.parseInt(req.getParameter("n_id"));
            String title = req.getParameter("n_title");
            String content = req.getParameter("n_content");
            String image = req.getParameter("n_image");

            System.out.println("update!!!");

            News news = new News();
            news.setId((long) id);
            news.setTitle(title);
            news.setContent(content);
            news.setImage(image);

            DBManager.updateNews(news);

            resp.sendRedirect("/selected_news_page?id=" + id);
        }else if (currntUser!=null && currntUser.getRole_id()==2){
            resp.sendRedirect("/home");
        } else {
            resp.sendRedirect("/sign_in");
        }
    }
}
