package Spotify.Repository;

import Spotify.POJO.Album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AlbumRepository {
    private Map<Integer, Album> albums = new HashMap<>();

    public void addAlbum(Album album) {
        albums.put(album.getId(), album);
    }

    public Album getAlbumById(int id) {
        return albums.get(id);
    }

    public List<Album> getAllAlbums() {
        return new ArrayList<>(albums.values());
    }
}
