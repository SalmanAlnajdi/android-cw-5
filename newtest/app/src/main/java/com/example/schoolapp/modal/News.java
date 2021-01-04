package com.example.schoolapp.modal;

public class News {
    private String title;
    private String news;

    public News(String title, String news) {
        this.title = title;
        this.news = news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
