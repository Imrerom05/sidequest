package sidequest.view;

import java.util.HashMap;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
  private final Button newUser = new Button("Create New User");
  private final Button exitButton = new Button("Exit Game");

  /**
   * Constructs the start page view.
   *
   * @param savedGamesMap A map containing saved game names and their corresponding types.
   */
  public StartPageView() {
    
    /* 
    setSpacing(10);
    getStyleClass().addAll("start-page", "background");
    setAlignment(Pos.TOP_CENTER);
    */
    
    // Title
    Label title = new Label("Welcome to Sidequest");
    //title.getStyleClass().addAll("fantasy", "text-gold", "text-55");
    
    // Information Label
    Label information = new Label("Enter your username and password to begin your adventure!");
    //subtitle.getStyleClass().addAll("fantasy", "text-gold", "text-40");
    
    // Username input
    username.setPromptText("Username");
    VBox.setMargin(username, new Insets(0, 100, 0, 100));
    //username.getStyleClass().addAll("fantasy-text", "fantasy");

    // Pasword input
    password.setPromptText("Password");
    VBox.setMargin(username, new Insets(0, 100, 0, 100));
    //username.getStyleClass().addAll("fantasy-text", "fantasy");
    
    // Login button
    //login.getStyleClass().addAll("button", "text-18", "fantasy");
    login.setDisable(true); // Initially disabled

    // New User button
    //login.getStyleClass().addAll("button", "text-18", "fantasy");
    newUser.setDisable(true); // Initially disabled
    
    // Exit button
    //exitButton.getStyleClass().addAll("button", "large-size", "fantasy");
       
    // Layout for saved game options
    HBox H = new HBox(10);
    H.setAlignment(Pos.CENTER);
    H.getChildren().addAll(login, newUser);
    HBox.setMargin(H, new Insets(5, 5, 5, 5));
    
    // Add all components to the main VBox
    getChildren().addAll(title, information, username, password, H, exitButton);
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


  public Button getNewUserButton() {
    return newUser;
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
