package Spotify.POJO;

import java.util.ArrayList;
import java.util.List;

public class PlayList {
    private int id;
    private String name;
    private List<Song> songs = new ArrayList<>();

    public PlayList(int id, String name) {
        this.id = id;
        this.name = name;
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
