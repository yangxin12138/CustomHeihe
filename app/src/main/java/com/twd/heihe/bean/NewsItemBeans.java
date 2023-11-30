package com.twd.heihe.bean;

public class NewsItemBeans {
    String news_title;
    String news_content;
    int news_imageId;

    public NewsItemBeans(String news_title, String news_content, int news_imageId) {
        this.news_title = news_title;
        this.news_content = news_content;
        this.news_imageId = news_imageId;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public int getNews_imageId() {
        return news_imageId;
    }

    public void setNews_imageId(int news_imageId) {
        this.news_imageId = news_imageId;
    }
}
