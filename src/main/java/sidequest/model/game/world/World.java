package sidequest.model.game.world;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import sidequest.model.game.hero.Hero;
import java.util.Random;


public class World {
  @JsonProperty
  private String user;
  @JsonProperty
  private ArrayList<String> classes;
  @JsonProperty
  private ArrayList<String> feats;
  @JsonProperty
  private ArrayList<String> races;
  @JsonProperty
  private ArrayList<String> backgrounds;

  private Random random = new Random();



  public World() {
  }

  public World(String user, String className, String raceName) {
    this.user = user;
    this.classes = new ArrayList<>();
    this.races = new ArrayList<>();
    this.classes.add(className);
    this.races.add(raceName);

    /*     this.feats = new ArrayList<>();
    this.backgrounds = new ArrayList<>();
    this.feats.add(featName);
    this.backgrounds.add(backgroundName); */
  }
  
  public Hero newHero() {
    return new Hero(classes.get(random.nextInt(classes.size())), races.get(random.nextInt(races.size())));
  }

  public void addClass(String className) {
    classes.add(className);
  }

/*   public void addFeat(String featName) {
    feats.add(featName);
  } */

  public void addRace(String raceName) {
    races.add(raceName);
  }

  /* 
  public void addBackground(String backgroundName) {
    backgrounds.add(backgroundName);
  }
  */
  
    /**
   * Saves the current state of the board to a JSON file.
   *
   * <p>This methode is based on a simuler method suggested by ChatGPT.<\p>
   *
   * @param gameName the name to save the board file as
   */
  public void saveWorld() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty-print the JSON
    try {
      objectMapper.writeValue(
          new File("src/main/resources/files/worlds/" + user + ".world.json"), this);
    } catch (IOException e) {
      throw new UncheckedIOException("Something went wrong saving " + user + "s world", e);
    }
  }

  /**
   * Loads a saved board state from a JSON file.
   *
   * <p>This methode is based on a simuler method suggested by ChatGPT.<\p>
   *
   * @param gameName the name of the board file to load
   * @return the loaded BoardSnakesAndLadders instance, or null if loading failed
   */
  public static World loadWorld(String user) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(
          new File("src/main/resources/files/worlds/" + user + ".world.json"),
          World.class);
    } catch (IOException e) {
      return null;
    }
  }

}
