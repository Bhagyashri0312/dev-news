package com.example.devnews.myNews;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private static List<Article> articleList = new ArrayList<>();

    static{
        articleList.add(new Article( 1L, "10 reasons to learn Spring", "In this article I'll be listing 10 reasons why you should learn spring and use it in your next project...", "John Smith" ));
        articleList.add(new Article( 2L, "Winters in Stockholm", "In this article I'll be telling about the wintes in Stockholm..", "Chris Bay" ));
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

}
