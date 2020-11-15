package com.example.devnews.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/articles")
    public class ArticleController {
        private final ArticleService articleService;

    public ArticleController(@Autowired ArticleService articleService) {
        this.articleService = articleService;
    }

    //Get a list of all the articles
        @GetMapping("")
        public List<Article> getAll(@RequestParam(required = false) Long topicId) {
            if (topicId == null) {
                return articleService.getAll();
            } else {
                return articleService.getAllByTopicId(topicId );
            }
        }

        //Get a specific article by id
        @GetMapping("/{id}")
        public Article getById(@PathVariable Long id){
            return articleService.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        }

        //Create a article
        @PostMapping("")
        public Article create(@RequestBody Article newArticle){
            return articleService.create(newArticle);
        }

        //Update a article
        @PutMapping("")
        public Article update(@RequestBody Article updatedArticle){
            return articleService.update(updatedArticle);
        }
        
        //Delete a article
        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            articleService.delete(id);
        }
    }
