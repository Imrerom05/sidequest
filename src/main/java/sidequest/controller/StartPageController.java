package sidequest.controller;

import sidequest.model.FileHandler;
import sidequest.model.game.Game;
import sidequest.MyWindow;
import javafx.beans.value.ChangeListener;
import sidequest.view.PopUp;
import sidequest.NavigationManager;
import sidequest.view.StartPageView;

/**
 * Controller for the start page. Handles input validation, new game creation, loading saved games,
 * and navigation to the appropriate game or setup views.
 */
public class StartPageController {
  private final StartPageView view;

  /** Constructs a new StartPageController. Initializes the view and UI event handlers. */
  public StartPageController() {
    this.view = new StartPageView();
    initialize();
  }

  /**
   * Returns the view associated with this controller.
   *
   * @return the StartPageView instance
   */
  public StartPageView getView() {
    return view;
  }

  /** Initializes UI event listeners and bindings for buttons and input fields. */
  private void initialize() {
    view.getLoginButton().setOnAction(event -> login());
    view.getExitButton().setOnAction(event -> MyWindow.closeApplication());

    ChangeListener<Object> enabler =
        (obs, oldV, newV) -> {
          boolean disable = !allInputsValid();
          view.getLoginButton().setDisable(disable);
        };


    view.getUsernameField().textProperty().addListener(enabler);
    view.getPaswordField().textProperty().addListener(enabler);
  }

  /**
   * Validates that all required inputs for starting a new game are provided.
   *
   * @return true if all required inputs are valid; false otherwise
   */
  private boolean allInputsValid() {
    return !view.getUsernameField().getText().isBlank()
        && !view.getPaswordField().getText().isBlank();
  }


  private void login() {
    String username = view.getUsernameField().getText();
    String password = view.getPaswordField().getText();

    switch (FileHandler.login(username, password)) {
      case 1:
        Game.setUser(username);
        NavigationManager.navigate(new WorldPageController().getView());
        break;

      case 2:
        PopUp.showInfo("Login Failed", "Invalid username or password.");
        break;

      case 3:
        if (username.contains(",") || password.contains(",")) {
          PopUp.showWarning("Invalid Input", "Username and password cannot contain commas.");
          return;
        } else if (PopUp.showConfirmation("New User", "User not found. Would you like to create a new account?")) {
          FileHandler.newUser(username, password);
          Game.setUser(username);
          NavigationManager.navigate(new WorldPageController().getView());
        }


        break;  
    
      default:
        PopUp.showError("Login Error", "An unexpected error occurred during login.");
        break;
    }
  }
}
