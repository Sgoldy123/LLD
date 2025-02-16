package Spotify.Repository;

import Spotify.POJO.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongRepository {
    private Map<Integer, Song> songs = new HashMap<>();

    public void addSong(Song song) {
        songs.put(song.getId(), song);
    }

    public Song getSongById(int id) {
        return songs.get(id);
    }

    public List<Song> getAllSongs() {
        return new ArrayList<>(songs.values());
    }
}
