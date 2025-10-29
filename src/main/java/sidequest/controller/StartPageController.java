package sidequest.controller;

import sidequest.model.FileHandler;
import sidequest.MyWindow;
import sidequest.model.User;
import javafx.beans.value.ChangeListener;
import sidequest.view.PopUp;
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
    view.getNewUserButton().setOnAction(event -> newUser());
    view.getExitButton().setOnAction(event -> MyWindow.closeApplication());

    ChangeListener<Object> enabler =
        (obs, oldV, newV) -> {
          boolean disable = !allInputsValid();
          view.getLoginButton().setDisable(disable);
          view.getNewUserButton().setDisable(disable);
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

    if (FileHandler.tryLogin(username, password) != null) {
      PopUp.showInfo("Login Successful", "Welcome back, " + username + "!");
    } else {
      PopUp.showInfo("Login Failed", "Invalid username or password.");
    }
  }

  private void newUser() {
    String username = view.getUsernameField().getText();
    String password = view.getPaswordField().getText();

    if(FileHandler.tryLogin(username, password) != null) {
      PopUp.showInfo("User Exists", "Username already taken. Please choose another.");
      return;
    } else {
      User newUser = new User(username, password);
      FileHandler.saveUser(newUser);
    }
  }
}
