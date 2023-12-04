package com.twd.heihe.bean;

public class UserCollectAlbumBeans {
    int album_image;
    String album_name;
    int songs;
    String author;
    String subtitle;

    public UserCollectAlbumBeans(int album_image, String album_name, int songs, String author) {
        this.album_image = album_image;
        this.album_name = album_name;
        this.songs = songs;
        this.author = author;
    }

    public int getAlbum_image() {
        return album_image;
    }

    public void setAlbum_image(int album_image) {
        this.album_image = album_image;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public int getSongs() {
        return songs;
    }

    public void setSongs(int songs) {
        this.songs = songs;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubtitle() {
        subtitle = String.format("%d首,by"+author,songs);
        return subtitle;
    }


}
