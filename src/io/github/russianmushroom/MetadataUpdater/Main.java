package io.github.russianmushroom.MetadataUpdater;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Requires an input and output path! Only provided: " + Arrays.toString(args));
        } else {
            try {
                new MetaManager(args[0], args[1]).manage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
