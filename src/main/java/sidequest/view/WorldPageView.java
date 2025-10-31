package sidequest.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class WorldPageView extends VBox {
  private final Button newAdventureButton = new Button("New Adventure");
  private final Button continueAdventureButton = new Button("Continue");
  private final Button backButton = new Button("Back to Main Menu");
  private final Button exitButton = new Button("Exit Game");
  private final Button deleteUserButton = new Button("Delete User");

  public WorldPageView() {
    setSpacing(20);
    getStyleClass().addAll("world-page", "background");
    setAlignment(Pos.CENTER);

    Label title = new Label("Sidequest");
    title.getStyleClass().addAll("standard", "text-60");

    newAdventureButton.getStyleClass().addAll("button", "standard", "large-size");
    continueAdventureButton.getStyleClass().addAll("button", "standard", "large-size");
    continueAdventureButton.setDisable(true);
    backButton.getStyleClass().addAll("button", "standard", "large-size");
    exitButton.getStyleClass().addAll("button", "standard", "large-size");
    deleteUserButton.getStyleClass().addAll("button", "standard", "large-size");

    getChildren().addAll(title, newAdventureButton, continueAdventureButton, backButton, exitButton, deleteUserButton);
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
