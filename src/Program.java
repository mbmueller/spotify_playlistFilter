package src;

import src.SpotifyObjects.Playlist;
import src.SpotifyObjects.Track;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    String key, clientID;
    APIHandler handler;
    Scanner in;
    public static void main(String[] args) {
        Program program = new Program();
    }

    Program() {
        in = new Scanner(System.in);
        boolean running = true;
        try {
            key = Files.readString(Path.of("key.txt"));
            clientID = Files.readString(Path.of("clientID.txt"));
        } catch (IOException e) {
            System.err.println("No API credentials were found. No connection to spotify services can be established");
            key = null;
            clientID = null;
        }
        handler = new APIHandler(key, clientID);

        while (running) {
            int input = -1;
            do {
                System.out.println("Wähle eine Option:");
                System.out.println("(0) Shutdown   (1) Filter new Playlist");
                try {
                    input = in.nextInt();
                } catch (InputMismatchException ignored) {

                }
            } while (input < 0 || input > 1);

            switch (input) {
                case 0 -> running = false;
                case 1 -> {
                    System.out.println("Enter playlist ID:");
                    String id = in.next();
                    filterDuplicates(id);
                }
            }
        }
    }

    public void filterDuplicates(String playlistID) {
        try {
            List<Track> tracks = handler.getTracks(playlistID);
        } catch (MalformedURLException e) {
            return;
        }
    }
}
