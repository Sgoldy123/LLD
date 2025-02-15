package Spotify.POJO;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private int id;
    private String name;
    private String artist;
    private List<Song> songs = new ArrayList<>();

    public Album(int id, String name, String artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }
}
