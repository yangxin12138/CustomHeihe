package com.twd.heihe.bean;

public class UserMyAlbumBeans {
    int album_image;
    String album_name;
    int song_count;

    public UserMyAlbumBeans(int album_image, String album_name, int song_count) {
        this.album_image = album_image;
        this.album_name = album_name;
        this.song_count = song_count;
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

    public int getSong_count() {
        return song_count;
    }

    public void setSong_count(int song_count) {
        this.song_count = song_count;
    }


    String songs;
    private String countSongs(int song_count){
        return String.format("%d首",song_count);
    }

    public String getSongs() {
        songs = countSongs(song_count);
        return songs;
    }
}
