package com.example.devnews.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    //Get a list of all the articles
    @GetMapping("")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    //Get a specific article by id
    @GetMapping("/{id}")
    public Optional<Comment> getById(@PathVariable Long id){
        return commentService.getById(id);
    }

    //Create a article
    @PostMapping("")
    public Comment create(@RequestBody Comment newComment){
        return commentService.create(newComment);
    }

    //Update a article
    @PutMapping("")
    public Comment update(@RequestBody Comment updatedComment){
        return commentService.update(updatedComment);
    }
    //Delete a article
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }
}
