package com.cristianreyesad.newsapi.service;

import com.cristianreyesad.newsapi.model.Article;
import com.cristianreyesad.newsapi.model.Articles;

import java.util.List;

public interface ArticlesService {

    Article  getArticleByAuthor(String author);

    Articles getArticles(String page) throws Exception;

    Article saveNewArticle(String author);

    List<Article> listArticles();

    void updateByAuthor(String author, Article article);

    void deleteByAuthor(String author);

    Articles getArticlesByCategory(String category, String page);
}
