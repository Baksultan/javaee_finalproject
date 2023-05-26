package servlets;

import db.*;
import models.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/selected_news_page")
public class SelectedNewsPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        News news = DBManager.getNewById(Math.toIntExact(id));
        req.setAttribute("selectedNew", news);
        req.getRequestDispatcher("/selectedNewsPage.jsp").forward(req, resp);
    }
}
