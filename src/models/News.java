package models;

import java.time.LocalDateTime;
import java.util.Date;

public class News {
    private Long id;
    private Date postDate;
    private String title;
    private String content;
    private int categoryId;
    private String image;

    public News(Long id, Date postDate, String title, String content, int categoryId, String image) {
        this.id = id;
        this.postDate = postDate;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.image = image;
    }

    public News() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
