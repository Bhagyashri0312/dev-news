package com.example.devnews.comments;
import com.example.devnews.Topic.Topic;
import com.example.devnews.myNews.Article;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //TEXT can hold longer string
    @Column(columnDefinition = "TEXT")
    private String body;
    private String authorName;

    @ManyToOne
    private Article article;

    public Comment() {
    }

    public Comment(Long id, String title, String body, String authorName, Article article){
        this.id= id;
        this.body=body;
        this.authorName=authorName;
        this.article= article;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

}
