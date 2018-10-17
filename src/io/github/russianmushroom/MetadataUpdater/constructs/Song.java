package io.github.russianmushroom.MetadataUpdater.constructs;

import org.farng.mp3.MP3File;
import org.farng.mp3.TagException;
import org.farng.mp3.id3.ID3v1;

import java.io.File;
import java.io.IOException;

public class Song {

    private MP3File song;
    private File file;

    private boolean isLoaded = false;

    public Song(File file) {
        this.file = file;

        try {
            this.song = new MP3File(file);
            isLoaded = true;
        } catch (IOException | TagException e) {
            e.printStackTrace();
        }
    }

    public MP3File getSong() {
        return song;
    }

    public File getFile() {
        return file;
    }

    public boolean isLoaded() {
        return isLoaded;
    }

    @Override
    public String toString() {
        ID3v1 tag = song.getID3v1Tag();
        return String.format("Title: %s by %s, from the album: %s (%s). Genre: %s. \n Comments: %s",
                tag.getSongTitle(), tag.getArtist(),
                tag.getAlbum(), tag.getAlbumTitle(),
                tag.getGenre(), tag.getComment());
    }
}
