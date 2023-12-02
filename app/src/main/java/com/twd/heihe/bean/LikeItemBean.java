package com.twd.heihe.bean;

public class LikeItemBean {

    int like_avatar; //头像
    String like_name;//名字
    String like_action;//行为
    String like_object;//对象
    String like_time;//时间

    public LikeItemBean(int like_avatar, String like_name, String like_action, String like_object,String like_time) {
        this.like_avatar = like_avatar;
        this.like_name = like_name;
        this.like_action = like_action;
        this.like_object = like_object;
        this.like_time = like_time;
    }

    public int getLike_avatar() {
        return like_avatar;
    }

    public void setLike_avatar(int like_avatar) {
        this.like_avatar = like_avatar;
    }

    public String getLike_name() {
        return like_name;
    }

    public void setLike_name(String like_name) {
        this.like_name = like_name;
    }

    public String getLike_action() {
        return like_action;
    }

    public void setLike_action(String like_action) {
        this.like_action = like_action;
    }

    public String getLike_object() {
        return like_object;
    }

    public void setLike_object(String like_object) {
        this.like_object = like_object;
    }

    public String getLike_time() {
        return like_time;
    }

    public void setLike_time(String like_time) {
        this.like_time = like_time;
    }
}
