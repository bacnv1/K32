package com.t3h.mp3player;

public class Song {
    private String data;
    private String title;
    private String artist;
    private String album;
    private int duration;
    private int size;

    public Song(String data, String title, String artist, String album, int duration, int size) {
        this.data = data;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
        this.size = size;
    }

    public String getData() {
        return data;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }

    public int getSize() {
        return size;
    }
}
