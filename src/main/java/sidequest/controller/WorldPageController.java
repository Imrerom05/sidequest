package sidequest.controller;

import java.io.File;

import javafx.beans.value.ChangeListener;
import sidequest.MyWindow;
import sidequest.view.WorldPageView;
import sidequest.controller.StartPageController;
import sidequest.NavigationManager;
import sidequest.model.game.Game;
import sidequest.view.PopUp;
import sidequest.model.FileHandler;

public class WorldPageController {
    private final WorldPageView view;

  /** Constructs a new StartPageController. Initializes the view and UI event handlers. */
  public WorldPageController() {
    this.view = new WorldPageView();
    initialize();
  }

  /**
   * Returns the view associated with this controller.
   *
   * @return the StartPageView instance
   */
  public WorldPageView getView() {
    return view;
  }

  /** Initializes UI event listeners and bindings for buttons and input fields. */
  private void initialize() {
    view.getBackButton().setOnAction(event -> NavigationManager.navigate(new StartPageController().getView()));
    view.getExitButton().setOnAction(event -> MyWindow.closeApplication());
    view.getNewAdventureButton().setOnAction(event -> newAdventure());
    view.getContinueAdventureButton().setOnAction(event -> continueAdventure());
    view.getDeleteUserButton().setOnAction(event -> deleteUser());
  }

  private void newAdventure() {
  }

  private void continueAdventure() {
  }

  private void deleteUser() {
    if (PopUp.showConfirmation("Delete User", "Are you sure you want to delete your user account?\nThis action cannot be undone,\nand all progres will be lost.")) {
        FileHandler.deleteUser(Game.getUser());
        NavigationManager.navigate(new StartPageController().getView());
    }
  }



  
}
