package com.example.devnews.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    //Get a list of all the articles
    @GetMapping("")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId) {
        if (articleId == null) {
            return topicService.getAll();
        } else {
            return topicService.getAllByArticleId(articleId );
        }
    }

    //Get a specific article by id
    @GetMapping("/{id}")
    public Optional<Topic> getById(@PathVariable Long id){
        return topicService.getById(id);
    }

    //Create a article
    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic){
        return topicService.create(newTopic);
    }

    //Update a article
    @PutMapping("")
    public Topic update(@RequestBody Topic updatedTopic){
        return topicService.update(updatedTopic);
    }

    //Delete a article
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        topicService.delete(id);
    }
}

