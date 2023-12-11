package com.twd.heihe.bean;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GameItemBeans {
    int game_image;//图片
    String game_name;//名字
    double price;//价格
    double original_price;//原价格,如果不是打折就隐藏
    boolean isSale;//是否打折
    boolean isHistorical_low;//是否史低，在isSale=true的基础上判断
    int category;//游戏类型
    String description;//描述
    String label;

    public GameItemBeans(int game_image, String game_name, double price, double original_price, boolean isSale, boolean isHistorical_low, int category, String description,String label) {
        this.game_image = game_image;
        this.game_name = game_name;
        this.price = price;
        this.original_price = original_price;
        this.isSale = isSale;
        this.isHistorical_low = isHistorical_low;
        this.category = category;
        this.description = description;
        this.label = label;
    }

    public int getGame_image() {
        return game_image;
    }

    public void setGame_image(int game_image) {
        this.game_image = game_image;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public String getPrice() {
        return "￥" + String.format("%.0f", price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOriginal_price() {
        return "￥"+ String.format("%.0f", original_price);
    }

    public void setOriginal_price(double original_price) {
        this.original_price = original_price;
    }

    public String getPercentage() {
        double discount = (double) (original_price - price) / original_price * 100;
        int percentage = (int) Math.round(-discount);
        return "-" + percentage + "%";
    }


    public boolean isSale() {
        return isSale;
    }

    public void setSale(boolean sale) {
        isSale = sale;
    }

    public boolean isHistorical_low() {
        return isHistorical_low;
    }

    public void setHistorical_low(boolean historical_low) {
        isHistorical_low = historical_low;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
