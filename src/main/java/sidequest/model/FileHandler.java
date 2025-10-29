package sidequest.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class FileHandler {

  // The directory where all save files are stored.
  private static final String FILE_DIRECTORY = "src/main/resources/files/";

  /**
   * Builds the full file path from a filename relative to the base directory.
   *
   * @param fileName The name of the file (e.g., "SavedGames.csv")
   * @return The full path to the file
   */
  private static String getFilePath(String fileName) {
    return FILE_DIRECTORY + fileName;
  }


  public static void newUser(String username, String password) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(getFilePath("user.csv"), true))) {
      writer.println(username + "," + password);
    } catch (IOException e) {
      throw new UncheckedIOException("Failed to save players. Couldn't write to file", e);
    }
  }

  /**
   * Loads the list of players from the saved CSV file.
   *
   * @param gameName The name of the saved game
   * @return A list of Player objects reconstructed from file
   */
  public static int login(String username, String password) {
    try (Scanner scanner = new Scanner(new File(getFilePath("user.csv")))) {
      while (scanner.hasNextLine()) {
        String[] data = scanner.nextLine().split(",");

        if (data.length != 2) {
          throw new IllegalArgumentException("Invalid player data format");
        }

        if (data[0].equals(username) && data[1].equals(password)) {
          return 1; // Login successful
        } else if (data[0].equals(username)) {
          return 2; // Username found but password incorrect
        }
      }
      return 3; // Username not found
    } catch (FileNotFoundException e) {
      throw new UncheckedIOException("Failed to load file when loading players", e);
    }
  }
}

