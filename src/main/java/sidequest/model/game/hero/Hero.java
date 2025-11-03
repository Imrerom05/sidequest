package sidequest.model.game.hero;

import sidequest.model.FileHandler;
import sidequest.model.game.hero.*;
import java.util.Random;
import java.util.HashMap;

public class Hero {
  private String gender;
  private String name;
  private String heroClass;
  private String race;

  private int maxHealth;
  private int currentHealth;
  private int money;

  private HashMap<String, Integer> stats = new HashMap<>();
  private Random random = new Random();

  public Hero(String heroClass, String race) {
    setGender();
    name = FileHandler.newName(gender);
    setBaseStats();
    setBaseHelth();
    baseMoney();
    setClass(heroClass);
    setRace(race);
/*  setFeat(feat);
    setBackground(background); */
    fullHeal();
  }

  private void setBaseStats() {
    stats.put("strength", random.nextInt(6) - 2);
    stats.put("agility", random.nextInt(6) - 2);
    stats.put("mind", random.nextInt(6) - 2);
    stats.put("charisma", random.nextInt(6) - 2);
  }
  
  private void setGender() {
    if (random.nextBoolean()) {
      this.gender = "Male";
    } else {
      this.gender = "Female";
    }
  }

  private void setBaseHelth() {
    this.maxHealth = 8 + stats.get("strength");
  }

  private void baseMoney() {
    this.money = 4 +  random.nextInt(7) - 3;
  }

  private void fullHeal() {
    this.currentHealth = maxHealth;
  }

  private void setClass(String heroClass) {
    this.heroClass = heroClass;
  }

  private void setRace(String race) {
    this.race = race;
  }

  private void setFeat(String feat) {

  }

  private void setBackground(String background) {

  }

  public String getName() {
    return name;
  }

  public int getMaxHealth() {
    return maxHealth;
  }

  public int getGold() {
    return money;
  }

  public String getHeroInfo() {
    return race + " " + heroClass;
  }

  public String getImage() {
    return gender.toLowerCase() + "_" + race.toLowerCase()+"_"+heroClass.toLowerCase();
  }

  public String getHPandGold () {
    return "HP: " + maxHealth + "   Gold: " + money;
  }

  public String getStatsDescriprion() {
    return "STR: " + stats.get("strength") + "  AGI: " + stats.get("agility")
     +"\nINT: " + stats.get("mind") + "  CHA: " + stats.get("charisma");
  }

  public String getDescription() {
    return "";
  }


}

