package com.example.article.Comments;

import com.example.article.Article.ArticleData;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
    @Id
    //Tell spring that this value is automatically created by database as an identity.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    private String authorName;

    @ManyToOne
    private ArticleData article;

    public Comment(){
    }

    public Comment(long id, String title, String body, String authorName){
        this.id = id;
        this.title = title;
        this. body = body;
        this.authorName = authorName;
    }

    public long getId(){
        return id;
    }

    public void setId() {
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle() {
        this.title = title;
    }

    public String getBody(){
        return body;
    }

    public void setBody() {
        this.body = body;
    }

    public String getAuthorName(){
        return authorName;
    }

    public void setAuthorName() {
        this.authorName = authorName;
    }

    public ArticleData getArticle() {
        return article;
    }

    public void setArticle(ArticleData article) {
        this.article = article;
    }
}
