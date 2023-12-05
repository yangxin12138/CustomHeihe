package com.twd.heihe.bean;

import android.graphics.drawable.Drawable;

public class UserMenuBeans {
    Drawable menu_image;
    String menu_name;

    public UserMenuBeans(Drawable menu_image, String menu_name) {
        this.menu_image = menu_image;
        this.menu_name = menu_name;
    }

    public Drawable getMenu_image() {
        return menu_image;
    }

    public void setMenu_image(Drawable menu_image) {
        this.menu_image = menu_image;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }
}
