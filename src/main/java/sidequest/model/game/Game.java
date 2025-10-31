package sidequest.model.game;

public class Game {
  private static String user;

  public static void startGame(String username) {
    user = username;
  }

  public static String getUser() {
    return user;
  }
}
