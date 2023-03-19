package src;

import src.SpotifyObjects.Track;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class APIHandler {
    String key, clientID;
    public APIHandler(String key, String id) {
        this.key = key;
        clientID = id;
    }

    public List<Track> getTracks(String playlistID) throws MalformedURLException {
        List<Track> tracks = new ArrayList<>();
        URL url = new URL("https://api.spotify.com/v1/playlists/" + playlistID + "/tracks");

        //TODO

        return tracks;
    }
}
