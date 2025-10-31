package sidequest.controller;

import sidequest.NavigationManager;
import sidequest.model.game.Game;
import sidequest.view.NewHeroView;
import sidequest.view.LocationPageView;
import sidequest.model.game.world.Location;

public class LocationPageController {
      private final LocationPageView view;
      
  
  /** Constructs a new StartPageController. Initializes the view and UI event handlers. */
  public LocationPageController() {
    this.view = new LocationPageView(new Location("village"));
    initialize();
  }

  /**
   * Returns the view associated with this controller.
   *
   * @return the StartPageView instance
   */
  public LocationPageView getView() {
    return view;
  }

  /** Initializes UI event listeners and bindings for buttons and input fields. */
  private void initialize() {
    view.getLeavAdventureButton().setOnAction(event -> leaveAdventure());
  }

  private void leaveAdventure() {
    NavigationManager.navigate(new WorldPageController().getView());
  }



  
}
