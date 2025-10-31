package sidequest.model.game.hero;

import sidequest.model.game.hero.*;
import java.util.Random;
import java.util.HashMap;

public class Hero {
  private String name;

  private int maxHealth;
  private int currentHealth;
  private int money;

  private HashMap<String, Integer> stats = new HashMap<>();
  private Random random = new Random();

  public Hero() {
    setBaseStats();
    setBaseHelth();
    baseMoney();
  }

  public Hero(Class heroClass, Race race, Feat feat, Background background) {
    setBaseStats();
    setBaseHelth();
    baseMoney();
    setClass(heroClass);
    setRace(race);
    setFeat(feat);
    setBackground(background);
  }

  private void setBaseStats() {
    int modefier = 0;
    int statsMaker[] = new int[6];

    for (int i = 0; i < 5; i++) {
      stats.put("strength", 0);
      stats.put("agility", 0);
      stats.put("mind", 0);
      stats.put("charisma", 0);
      stats.put("luck", 0);
      stats.put("endurance", 0);
    }

    for (int i = 0; i < 6; i++) {
      statsMaker[i] = (int) (Math.random() * 8) - 3 + modefier;
      if (statsMaker[i] > 1) {
        modefier--;
      } else if (statsMaker[i] < -1) {
        modefier++;
      }
    }
    for (int i = statsMaker.length - 1; i > 0; i--) {
      int index = random.nextInt(i + 1);
      int temp = statsMaker[index];
      statsMaker[index] = statsMaker[i];
      statsMaker[i] = temp;
    }

    stats.put("strength", statsMaker[0]);
    stats.put("agility", statsMaker[1]);
    stats.put("mind", statsMaker[2]);
    stats.put("charisma", statsMaker[3]);
    stats.put("luck", statsMaker[4]);
    stats.put("endurance", statsMaker[5]);
  }

  private void setBaseHelth() {
    this.maxHealth = 8 + stats.get("endurance") + random.nextInt(4) - 2;
  }

  private void baseMoney() {
    this.money = 10 + stats.get("luck") + random.nextInt(6) - 3;
  }

  private void setClass(Class heroClass) {

  }

  private void setRace(Race race) {

  }

  private void setFeat(Feat feat) {

  }

  private void setBackground(Background background) {

  }

  public String getName() {
    return name;
  }

  public String getHeroInfo() {
    return "";
  }

  public String getImage() {
    return "";
  }

  public String getStatsDescriprion() {
    return "";
  }

  public String getDescription() {
    return "";
  }


}

