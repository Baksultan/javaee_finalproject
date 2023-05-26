package servlets;

import db.DBManager;
import models.Comment;
import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add_comment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String redirect = "/sign_in";
        User user = (User) req.getSession().getAttribute("current_user");
        if (user!=null) {
            String commentText = req.getParameter("comment_text");
            Long newsId = (long) Integer.parseInt(req.getParameter("news_id"));

            News news = DBManager.getNewById(Math.toIntExact(newsId));
            if (news!=null) {
                Comment comment = new Comment();
                comment.setComment(commentText);
                comment.setUser(user);
                comment.setNews(news);
                if (DBManager.addComment(comment)) {
                    redirect = "/selected_news_page?id="+newsId;
                }
            }
        }
        resp.sendRedirect(redirect);

    }
}