package com.example.devnews.myNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
    public class ArticleController {
    @Autowired
        private ArticleService articleService;

        //Get a list of all the articles

        @RequestMapping("/articles")
        public List<Article> getAll() {
            return articleService.getAll();
        }

        //Get a specific article by id
        @RequestMapping("/articles/{id}")
        public Optional<Article> getById(@PathVariable Long id){
            return articleService.getById(id);

        }


    }
