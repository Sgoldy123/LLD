package Spotify.Service;

import Spotify.POJO.Song;
import Spotify.Repository.SongRepository;

import java.util.List;

public class SongService {
    private SongRepository songRepository;

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void addSong(Song song) {
        songRepository.addSong(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }
}