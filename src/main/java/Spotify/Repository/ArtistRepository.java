package Spotify.Repository;

import Spotify.POJO.Artist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ArtistRepository {
    private Map<Integer, Artist> artists = new HashMap<>();

    public void addArtist(Artist artist) {
        artists.put(artist.getId(), artist);
    }

    public Artist getArtistById(int id) {
        return artists.get(id);
    }

    public List<Artist> getAllArtists() {
        return new ArrayList<>(artists.values());
    }
}