package com.example.devnews.myNews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;
    private static Long idCounter = 1L;

    //Get a list of all the articles
    public List<Article> getAll() {
        return repository.findAll();
    }

    //Get a specific article by id
    public Optional<Article> getById(Long id) {
        return repository.findById(id);
    }

    public Article create(Article newArticle) {
        newArticle.setId(idCounter);
        idCounter++;
        return repository.save(newArticle);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
