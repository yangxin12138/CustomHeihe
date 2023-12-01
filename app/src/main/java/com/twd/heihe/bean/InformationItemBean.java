package com.twd.heihe.bean;

public class InformationItemBean {
    String information_content;
    String information_author;
    String information_time;


    public InformationItemBean(String information_content, String information_author, String information_time) {
        this.information_content = information_content;
        this.information_author = information_author;
        this.information_time = information_time;
    }

    public String getInformation_content() {
        return information_content;
    }

    public void setInformation_content(String information_content) {
        this.information_content = information_content;
    }

    public String getInformation_author() {
        return information_author;
    }

    public void setInformation_author(String information_author) {
        this.information_author = information_author;
    }

    public String getInformation_time() {
        return information_time;
    }

    public void setInformation_time(String information_time) {
        this.information_time = information_time;
    }
}
