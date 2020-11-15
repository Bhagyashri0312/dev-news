package com.example.devnews.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    //Get a list of all the articles
    public List<Article> getAll() {
        return repository.findAll();
    }

    //Get a specific article by id
    public Optional<Article> getById(Long id) {
        return repository.findById(id);
    }

    public Article create(Article newArticle) {
        return repository.save(newArticle);
    }

    public Article update(Article updatedArticle) {
        return repository.save(updatedArticle);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public List<Article> getAllByTopicId(Long topicId) {
        return repository.findAllByTopics_Id(topicId);
    }

}
