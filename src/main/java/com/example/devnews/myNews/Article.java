package com.example.devnews.myNews;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    //TEXT can hold longer string
    @Column(columnDefinition = "TEXT")
    private String body;
    private String authorName;

    public Article() {
    }

    public Article(Long id, String title, String body, String authorName){
        this.id= id;
        this.title=title;
        this.body=body;
        this.authorName=authorName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
