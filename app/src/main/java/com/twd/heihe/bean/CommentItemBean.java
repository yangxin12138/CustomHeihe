package com.twd.heihe.bean;

public class CommentItemBean {
    int comment_userAvatar; //评论的用户头像
    String comment_userName; //评论的用户昵称
    String comment_content; //评论内容
    String comment_myContent; //我的内容
    String comment_time; //评论的时间

    public CommentItemBean(int comment_userAvatar, String comment_userName, String comment_content, String comment_myContent, String comment_time) {
        this.comment_userAvatar = comment_userAvatar;
        this.comment_userName = comment_userName;
        this.comment_content = comment_content;
        this.comment_myContent = comment_myContent;
        this.comment_time = comment_time;
    }

    public int getComment_userAvatar() {
        return comment_userAvatar;
    }

    public void setComment_userAvatar(int comment_userAvatar) {
        this.comment_userAvatar = comment_userAvatar;
    }

    public String getComment_userName() {
        return comment_userName;
    }

    public void setComment_userName(String comment_userName) {
        this.comment_userName = comment_userName;
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content;
    }

    public String getComment_myContent() {
        return comment_myContent;
    }

    public void setComment_myContent(String comment_myContent) {
        this.comment_myContent = comment_myContent;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }
}
