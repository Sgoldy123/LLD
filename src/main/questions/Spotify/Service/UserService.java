package Spotify.Service;

import Spotify.POJO.PlayList;
import Spotify.POJO.User;
import Spotify.Repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(User user) {
        userRepository.addUser(user);
        return true;
    }

    public boolean login(String username, String password) {
        for (User user : userRepository.getAllUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void addPlaylist(User user, PlayList playlist) {
        user.addPlaylist(playlist);
    }
}




