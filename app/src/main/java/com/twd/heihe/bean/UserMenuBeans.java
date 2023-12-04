package com.twd.heihe.bean;

public class UserMenuBeans {
    int menu_image;
    String menu_name;

    public UserMenuBeans(int menu_image, String menu_name) {
        this.menu_image = menu_image;
        this.menu_name = menu_name;
    }

    public int getMenu_image() {
        return menu_image;
    }

    public void setMenu_image(int menu_image) {
        this.menu_image = menu_image;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }
}
