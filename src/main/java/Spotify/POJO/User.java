package Spotify.POJO;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String password;
    private List<PlayList> playlists = new ArrayList<>();

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<PlayList> getPlaylists() {
        return playlists;
    }

    public void addPlaylist(PlayList playlist) {
        playlists.add(playlist);
    }
}