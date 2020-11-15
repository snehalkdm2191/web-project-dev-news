package com.example.article.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
//@RequestMapping("/articles")
public class ArticleController {
    private ArticleServices articleServices;

    public ArticleController(@Autowired ArticleServices articleServices) {
        this.articleServices = articleServices;
    }

    @GetMapping("/articles")
    public List<ArticleData> getAll(){
        return articleServices.getAll();
    }

    @RequestMapping("articles/{id}")
    public ArticleData getById(@PathVariable Long id){
        return articleServices.getByID(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/articles")
    public ArticleData create(@RequestBody ArticleData article){
        return articleServices.create(article);
    }

    @PutMapping("/articles")
    public ArticleData update(@RequestBody ArticleData article){
        return articleServices.update(article);
    }

    @DeleteMapping("articles/{id}")
    public void delete(@PathVariable Long id){
        articleServices.delete(id);
    }
}
