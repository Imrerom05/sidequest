package sidequest.view;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sidequest.controller.NewHeroController;

public class ChoseHeroPageView extends VBox {
  private final Button backButton = new Button("Leave Adventure");
  private final Button exitButton = new Button("Exit Game");
  private final NewHeroView newHero1;
  private final NewHeroView newHero2;
  private final NewHeroView newHero3;


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

    newHero1 = new NewHeroController().getView();
    newHero2 = new NewHeroController().getView();
    newHero3 = new NewHeroController().getView();

    HBox heros = new HBox();
    heros.getChildren().addAll(newHero1, newHero2, newHero3);
    heros.setSpacing(35);
    heros.setAlignment(Pos.CENTER);

    getChildren().addAll(title, heros, buttonBox);
  }
  
  public Button getBackButton() {
    return backButton;
  }

  public Button getExitButton() {
    return exitButton;
  }
}
