package com.example.devnews.Topic;

import com.example.devnews.myNews.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findAllByArticles_Id(Long articleId);
}
