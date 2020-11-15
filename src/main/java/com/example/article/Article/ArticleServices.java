package com.example.article.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServices {

    @Autowired
    private ArticleRepo repo;

    private static final List<ArticleData> articleList =new ArrayList<>();

    /*static {
        articleList.add(new ArticleData(1L,"First article","One of the best article","John Smith"));
        articleList.add(new ArticleData(2L,"Second article","This article is very well written","Tom Smith"));
    }*/

    public List<ArticleData> getAll(){
        return repo.findAll();
    }

    public Optional<ArticleData> getByID(long id){
        /*return articleList.stream()
                .filter(a -> a.getId() == id).findFirst();*/
        return repo.findById(id);
    }

    public ArticleData create(ArticleData newArticle){
        return repo.save(newArticle);
    }

    public ArticleData update(ArticleData updateArticle){
        return repo.save(updateArticle);
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
