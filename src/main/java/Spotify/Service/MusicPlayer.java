package Spotify.Service;

import Spotify.POJO.Song;

public class MusicPlayer {
    private Song currentSong;

    public void playMusic(Song song) {
        currentSong = song;
        System.out.println("Playing: " + song.getTitle());
    }

    public void pause() {
        if (currentSong != null) {
            System.out.println("Paused: " + currentSong.getTitle());
        } else {
            System.out.println("No song is currently playing.");
        }
    }
}