package com.example.devnews.comments;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Comment {
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TEXT can hold longer string
    @Column(columnDefinition = "TEXT")
    private String body;
    private String authorName;

    public Comment() {
    }

    public Comment(Long id, String title, String body, String authorName){
        this.id= id;
        this.body=body;
        this.authorName=authorName;
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
