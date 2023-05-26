package db;

import models.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DBManager {
    public static final String url = "jdbc:postgresql://localhost:5432/javaee_final_project_db";
    public static final String user = "postgres";
    public static final String password = "root";
    public static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Successfully connected with DB!");
        } catch (Exception e) {
            System.out.println("Error with connection with DB!");
            e.printStackTrace();
        }
    }



    public static User getUser(String email) {
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setPassword(resultSet.getString("password"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            statement.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public static void updateNews(News news) {
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE news SET post_date = Now(), title = ?, content = ?, image = ? WHERE id = ?"
            );

            statement.setString(1, news.getTitle());
            statement.setString(2, news.getContent());
            statement.setString(3, news.getImage());
            statement.setInt(4, Math.toIntExact(news.getId()));

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void deleteNews(Long id) {
        try{

            PreparedStatement statement = connection.prepareStatement("DELETE FROM news WHERE id = ?");

            statement.setLong(1, id);

            int rows = statement.executeUpdate();

            System.out.println("deleted!!!");

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void addUser(User user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (full_name, email, password, role_id) " +

                    "VALUES (?, ?, ?, ?)"
            );

            statement.setString(1, user.getFullName());

            statement.setString(2, user.getEmail());

            statement.setString(3, user.getPassword());

            statement.setInt(4, 2);

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNews(News news){

        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO news (post_date, category_id, title, content, image) " +

                    "VALUES (Now(), ?, ?, ?, ?)"
            );

            statement.setInt(1, news.getCategoryId());

            statement.setString(2, news.getTitle());

            statement.setString(3, news.getContent());

            statement.setString(4, news.getImage());

            System.out.println("success!!!");

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean addComment(Comment comment){
        int rows = 0;
        try{

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO comments (comment, post_date, user_id, news_id) " +

                    "VALUES (?, Now(), ?, ?)"
            );

            statement.setString(1, comment.getComment());

            statement.setLong(2, comment.getUser().getId());

            statement.setLong(3, comment.getNews().getId());

            rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rows>0;
    }

    public static ArrayList<Comment> getAllCommentsFromId(Long commentId){

        ArrayList<Comment> commentsList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT c.id, c.comment, c.post_date, c.user_id, c.news_id, u.full_name, u.email "+
                    "FROM comments c " +
                    "INNER JOIN users u ON c.user_id = u.id " +
                    "WHERE c.news_id = ? " +
                    "ORDER BY c.post_date DESC");
            statement.setLong(1, commentId);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Comment comment = new Comment();

                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPostDate(resultSet.getDate("post_date"));

                User user = new User();
                user.setId(resultSet.getLong("user_id"));
                user.setFullName(resultSet.getString("full_name"));
                user.setEmail(resultSet.getString("email"));
                comment.setUser(user);

                News news = new News();
                news.setId(resultSet.getLong("news_id"));
                comment.setNews(news);

                commentsList.add(comment);
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return commentsList;
    }



    public static ArrayList<News> getAllNews(){

        ArrayList<News> newsList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM news");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");

                Date postDate = resultSet.getDate("post_date");

                int categoryId = resultSet.getInt("category_id");

                String title = resultSet.getString("title");

                String content = resultSet.getString("content");
                String image = resultSet.getString(("image"));

                newsList.add(new News(id, postDate, title, content, categoryId, image));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return newsList;
    }

    public static ArrayList<NewsCategory> getAllNewsCategories(){

        ArrayList<NewsCategory> newsCategoriesList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM news_categories");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");

                String name = resultSet.getString("name");

                newsCategoriesList.add(new NewsCategory(id, name));
            }

            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return newsCategoriesList;
    }


    public static News getNewById (int id) {
        News news = null;

        try {
            PreparedStatement statement = connection.prepareStatement(""
            + "select * from news where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                news = new News();
                news.setId(resultSet.getLong("id"));
                news.setPostDate(resultSet.getDate("post_date"));
                news.setCategoryId(resultSet.getInt("category_id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                news.setImage(resultSet.getString("image"));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return news;
    }



}
