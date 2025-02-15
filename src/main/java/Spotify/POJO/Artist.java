package Spotify.POJO;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private int id;
    private String name;
    private List<Song> songs ;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void addSong(Song song) {
        songs.add(song);
    }
}
