package com.example.newsapp.Models;

import java.util.ArrayList;

public class ArticleArrayModelClass {
    private String status;
    private String totalResult;
    private ArrayList<ArticleModelClass> articles;

    public ArticleArrayModelClass(String status, String totalResult, ArrayList<ArticleModelClass> articles) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<ArticleModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleModelClass> articles) {
        this.articles = articles;
    }
}
