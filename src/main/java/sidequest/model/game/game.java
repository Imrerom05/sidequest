package sidequest.model.game;

public class Game {
  private static String user;

  public static void setUser(String username) {
    user = username;
  }

  public static String getUser() {
    return user;
  }
}
