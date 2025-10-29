package sidequest.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class WorldPageView extends VBox {
  private final Button newAdventureButton = new Button("New Adventure");
  private final Button continueAdventureButton = new Button("Continue");
  private final Button backButton = new Button("Back to Main Menu");
  private final Button exitButton = new Button("Exit Game");
  private final Button deleteUserButton = new Button("Delete User");

  public WorldPageView() {
    getStyleClass().addAll("world-page", "background");
    setAlignment(Pos.CENTER);

    newAdventureButton.getStyleClass().addAll("button", "standard");
    continueAdventureButton.getStyleClass().addAll("button", "standard");
    backButton.getStyleClass().addAll("button", "standard");
    exitButton.getStyleClass().addAll("button", "standard");
    deleteUserButton.getStyleClass().addAll("button", "standard");

    setSpacing(20);
    getChildren().addAll(newAdventureButton, continueAdventureButton, deleteUserButton, backButton, exitButton);
  }

  public Button getNewAdventureButton() {
    return newAdventureButton;
  }

  public Button getContinueAdventureButton() {
    return continueAdventureButton;
  }

  public Button getBackButton() {
    return backButton;
  }

  public Button getExitButton() {
    return exitButton;
  }

  public Button getDeleteUserButton() {
    return deleteUserButton;
  }

  
}
