package sidequest.model;

public class User {
  private String username;
  private String password;

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public boolean tryLogin(String username, String password) {
    return this.password.equals(password) && this.username.toLowerCase().equals(username.toLowerCase());
  }

  public String getUsername() {
    return username;
  }

  public String getSaveFormat() {
    return username + "," + password;
  }
}
