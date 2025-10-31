package sidequest.model.game;

import sidequest.model.game.hero.Hero;
import sidequest.model.game.world.World;

public class Game {
  private static String user;
  private static World world;

  public static void startGame(String username) {
    user = username;
    world = World.loadWorld(username);

    if (world == null) {
      world = new World(username, "Fighter", "Human");
      world.saveWorld();
    }
  }

  public static Hero newHero() {
    return world.newHero();
  }

  public static void exitGame() {
    world.saveWorld();
    user = null;
    world = null;
  }

  public static String getUser() {
    return user;
  }
}
