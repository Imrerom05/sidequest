package sidequest.view;

import sidequest.model.game.world.Location;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class LocationPageView extends VBox {
  private final Button leavAdventureButton = new Button("Leave Adventure");

  public LocationPageView(Location location) {
    setSpacing(25);
    getStyleClass().addAll(location.getType(), "background");
    setAlignment(Pos.CENTER);

    leavAdventureButton.getStyleClass().addAll("button", "standard", "large-size");
    getChildren().addAll(leavAdventureButton);


  }

  public Button getLeavAdventureButton() {
    return leavAdventureButton;
  }


  
  
}
