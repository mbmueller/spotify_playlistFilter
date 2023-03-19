package src.SpotifyObjects;

import java.util.Objects;

public class Playlist {
    private String name, id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return id.equals(playlist.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
