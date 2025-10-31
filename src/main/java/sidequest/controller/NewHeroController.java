package sidequest.controller;

import sidequest.MyWindow;
import sidequest.NavigationManager;
import sidequest.view.ChoseHeroPageView;
import sidequest.view.NewHeroView;
import sidequest.model.game.hero.*;
import sidequest.model.game.Game;

public class NewHeroController {
    private final NewHeroView view;
      
  
  /** Constructs a new StartPageController. Initializes the view and UI event handlers. */
  public NewHeroController() {
    this.view = new NewHeroView(Game.newHero());
    initialize();
  }

  /**
   * Returns the view associated with this controller.
   *
   * @return the StartPageView instance
   */
  public NewHeroView getView() {
    return view;
  }

  /** Initializes UI event listeners and bindings for buttons and input fields. */
  private void initialize() {
    view.getSelectButton().setOnAction(event -> selectButton());
  }

  private void selectButton() {
    NavigationManager.navigate(new LocationPageController().getView());
  }
  
}
