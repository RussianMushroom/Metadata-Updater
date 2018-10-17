package io.github.russianmushroom.MetadataUpdater;

import io.github.russianmushroom.MetadataUpdater.constructs.Song;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MetaManager {

    private Path inputDirectory;
    private Path outputDirectory;

    private List<Song> songs = new ArrayList<>();

    private boolean correctFormat;

    public MetaManager(String inputDirectory, String outputDirectory) throws IOException {
        this.inputDirectory = Paths.get(inputDirectory);
        this.outputDirectory = Paths.get(outputDirectory);

        this.correctFormat = checkFormat();
    }

    public void manage() throws IOException {
        if (correctFormat) {
            // collect all songs in the directory
            Files.newDirectoryStream(inputDirectory, path -> path.toString().endsWith(".mp3"))
                    .forEach(songPath -> songs.add(new Song(songPath.toFile())));

        }
    }

    private boolean checkFormat() throws IOException {
        if (inputDirectory.equals(outputDirectory)) {
            System.out.println("Both directories cannot be the same!");
            return false;
        }
        if (Files.list(inputDirectory).count() == 0) {
            System.out.println("The input directory is empty!");
            return false;
        }

        return true;
    }

}
