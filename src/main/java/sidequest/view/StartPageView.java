package sidequest.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/** View for the start page of the game. Lets the user start a new game or load a saved one. */
public class StartPageView extends VBox {

  // UI components
  private final TextField username = new TextField();
  private final TextField password = new TextField();
  private final Button login = new Button("Login");
  private final Button exitButton = new Button("Exit Game");

  /**
   * Constructs the start page view.
   *
   * @param savedGamesMap A map containing saved game names and their corresponding types.
   */
  public StartPageView() {
    VBox space = new VBox(50);
    
    setSpacing(20);
    getStyleClass().addAll("start-page", "background");
    setAlignment(Pos.TOP_CENTER);
    
    // Title
    Label title = new Label("Welcome to Sidequest");
    title.getStyleClass().addAll("standard", "text-60");
    
    // Information Label
    Label information = new Label("Enter your username and password");
    information.getStyleClass().addAll("standard", "text-30");
    
    // Username input
    username.setPromptText("Username");
    VBox.setMargin(username, new Insets(0, 175, 0, 175));
    username.getStyleClass().addAll("text-field", "standard");

    // Pasword input
    password.setPromptText("Password");
    VBox.setMargin(password, new Insets(0, 175, 0, 175));
    password.getStyleClass().addAll( "text-field","standard");
    
    // Login button
    login.getStyleClass().addAll("button", "standard");
    login.setDisable(true); // Initially disabled
    
    // Exit button
    exitButton.getStyleClass().addAll("button", "standard");
    
    // Add all components to the main VBox
    getChildren().addAll(space, title, information, username, password, login, exitButton);
    }
    
    // Getters for controller access


  public TextField getUsernameField() {
    return username;
  }
  

  public TextField getPaswordField() {
    return password;
  }


  public Button getLoginButton() {
    return login;
  }

  /**
   * Retrieves the button used to exit the game.
   *
   * @return the button to exit the game
   */
  public Button getExitButton() {
    return exitButton;
  }
}
