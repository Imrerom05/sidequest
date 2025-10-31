package sidequest.model.game.world;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Location {
  private String name;
  private String description;
  private String type;

  private ArrayList<Location> connectedLocations;
  private ArrayList<Event> events;
  private ArrayList<NPC> npcs;

  public Location(String type) {
    this.type = type;
    this.connectedLocations = new ArrayList<>();
    this.events = new ArrayList<>();
    this.npcs = new ArrayList<>();
  }

  public String getType() {
    return type;
  }




}
