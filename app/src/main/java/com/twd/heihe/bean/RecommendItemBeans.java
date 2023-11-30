package com.twd.heihe.bean;

public class RecommendItemBeans {
    String recommend_title;
    String recommend_content;
    int recommend_image1;
    int recommend_image2;
    int recommend_image3;

    public int getRecommend_image1() {
        return recommend_image1;
    }

    public void setRecommend_image1(int recommend_image1) {
        this.recommend_image1 = recommend_image1;
    }

    public int getRecommend_image2() {
        return recommend_image2;
    }

    public void setRecommend_image2(int recommend_image2) {
        this.recommend_image2 = recommend_image2;
    }

    public int getRecommend_image3() {
        return recommend_image3;
    }

    public void setRecommend_image3(int recommend_image3) {
        this.recommend_image3 = recommend_image3;
    }

    public RecommendItemBeans(String recommend_title, String recommend_content, int recommend_image1, int recommend_image2, int recommend_image3) {
        this.recommend_title = recommend_title;
        this.recommend_content = recommend_content;
        this.recommend_image1 = recommend_image1;
        this.recommend_image2 = recommend_image2;
        this.recommend_image3 = recommend_image3;
    }

    public String getRecommend_title() {
        return recommend_title;
    }

    public void setRecommend_title(String recommend_title) {
        this.recommend_title = recommend_title;
    }

    public String getRecommend_content() {
        return recommend_content;
    }

    public void setRecommend_content(String recommend_content) {
        this.recommend_content = recommend_content;
    }


}
