package sidequest.view;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ChoseHeroPageView extends VBox {
  private final Button backButton = new Button("Back");
  private final Button exitButton = new Button("Exit Game");


  public ChoseHeroPageView() {
    setSpacing(20);
    getStyleClass().addAll("chose-hero-page", "background");
    setAlignment(Pos.CENTER);

    Label title = new Label("Choose Your Hero");
    title.getStyleClass().addAll("standard", "text-60");

    backButton.getStyleClass().addAll("button", "standard", "large-size");
    exitButton.getStyleClass().addAll("button", "standard", "large-size");

    HBox buttonBox = new HBox(20, backButton, exitButton);
    buttonBox.setAlignment(Pos.CENTER);

    getChildren().addAll(title, buttonBox);
  }
  
  public Button getBackButton() {
    return backButton;
  }

  public Button getExitButton() {
    return exitButton;
  }
}
