package com.example.venkat.voll2;

/**
 * Created by venkat on 20/1/18.
 */

public class Song {
    String name,artist;

    public Song(String name,String artist){
        this.name=name;
        this.artist=artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
