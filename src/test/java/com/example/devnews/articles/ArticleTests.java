package com.example.devnews.articles;

import com.example.devnews.myNews.Article;
import com.example.devnews.myNews.ArticleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleTests {
    @Autowired
    ArticleService articleService;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void testCreate() {
        // Arrange
        Article requestArticle = new Article(null, "Test title", "Test body", "Test name");

        // Act
        Article responseArticle = testRestTemplate.postForObject("/articles", requestArticle, Article.class);

        // Assert
        Assertions.assertEquals(requestArticle.getAuthorName(), responseArticle.getAuthorName());
        Assertions.assertEquals(requestArticle.getBody(), responseArticle.getBody());

        // check that product is added
        Article getByIdArticleResponse = testRestTemplate.getForObject("/articles/" + responseArticle.getId().toString(),Article.class);
        Assertions.assertEquals(requestArticle.getAuthorName(), getByIdArticleResponse.getAuthorName());
        Assertions.assertEquals(requestArticle.getBody(), getByIdArticleResponse.getBody());

        // Clean up
        testRestTemplate.delete("/articles"+responseArticle.getId().toString());
    }

    @Test
    public void testGetAllReturnEmptyArray() {
        // Act
        String responseArticles = testRestTemplate.getForObject("/articles", String.class);

        // Assert
        Assertions.assertEquals("[]", responseArticles);
    }

    @Test
    public void testUpdate() {
        // Arrange
        Article originalArticle = articleService.create(new Article(null, "Test title", "Test body", "Test name"));
        Article updatedArticle = new Article(originalArticle.getId(), "Test updated title", "Test updated body", "Test updated name");

        // Act
        Article responseArticle = putForArticle(updatedArticle);

        // Assert
        Assertions.assertEquals(updatedArticle.getAuthorName(), responseArticle.getAuthorName());
        Assertions.assertEquals(updatedArticle.getBody(), responseArticle.getBody());

        Article getByIdArticleResponse = testRestTemplate.getForObject("/articles/" + updatedArticle.getId().toString(), Article.class);
        Assertions.assertEquals(updatedArticle.getAuthorName(), getByIdArticleResponse.getAuthorName());
        Assertions.assertEquals(updatedArticle.getBody(), getByIdArticleResponse.getBody());
    }


    private Article putForArticle(Article requestBody) {
        HttpEntity<Article> requestEntity = new HttpEntity<>(requestBody);
        HttpEntity<Article> response = testRestTemplate.exchange("/articles", HttpMethod.PUT, requestEntity, Article.class);
        return response.getBody();
    }
}

