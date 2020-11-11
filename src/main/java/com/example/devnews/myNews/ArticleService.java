package com.example.devnews.myNews;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    private static Long idCounter = 1L;
    private static List<Article> articleList = new ArrayList<>();

    static{
        add(new Article( null, "10 reasons to learn Spring", "In this article I'll be listing 10 reasons why you should learn spring and use it in your next project...", "John Smith" ));
        add(new Article( null, "Winters in Stockholm", "In this article I'll be telling about the winters in Stockholm..", "Chris Bay" ));
    }

    //Get a list of all the articles


    public static List<Article> getAll() {
        return articleList;
    }

    //Get a specific article by id

    public Optional<Article> getById(Long id) {
        return articleList.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }


    public Article create(Article newArticle) {
        add(newArticle);
        return newArticle;
    }

    static private boolean add(Article newArticle){
        //generate and set the id
        newArticle.setId(idCounter);
        idCounter++;
        return articleList.add(newArticle);
    }

    public void delete(Long id){
        articleList= articleList.stream()
                .filter(t -> !t.getId().equals(id))
                .collect(Collectors.toList());
    }
}
