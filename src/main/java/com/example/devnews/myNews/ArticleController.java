package com.example.devnews.myNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
    public class ArticleController {
    @Autowired
        private ArticleService articleService;

        //Get a list of all the articles

        @GetMapping("")
        public List<Article> getAll() {
            return articleService.getAll();
        }

        //Get a specific article by id
        @GetMapping("/{id}")
        public Optional<Article> getById(@PathVariable Long id){
            return articleService.getById(id);

        }

    //Create a article
    @PostMapping("")
    public Article create(@RequestBody Article newArticle){
            return articleService.create(newArticle);

    }

    @DeleteMapping("/{id}")
            public void delete(@PathVariable Long id){
                articleService.delete(id);
            }


    }
