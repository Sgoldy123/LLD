package Spotify;

import Spotify.Repository.SongRepository;
import Spotify.Repository.UserRepository;
import Spotify.Service.*;
import Spotify.POJO.*;

public class Main {
    public static void main(String[] args) {
        SongRepository songRepository = new SongRepository();
        UserRepository userRepository = new UserRepository();

        SongService songService = new SongService(songRepository);
        UserService userService = new UserService(userRepository);

        // Create songs
        Song song1 = new Song(1, "Song A", "Artist A", "Album A", 210);
        Song song2 = new Song(2, "Song B", "Artist B", "Album B", 180);

        songService.addSong(song1);
        songService.addSong(song2);

        // Register a user
        User user = new User(1, "john_doe", "password123");
        userService.registerUser(user);

        // Create a playlist
        PlayList playlist = new PlayList(1, "My Playlist");
        playlist.addSong(song1);
        playlist.addSong(song2);
        user.addPlaylist(playlist);

        // Play music
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.playMusic(song1);
        musicPlayer.pause();
    }
}
