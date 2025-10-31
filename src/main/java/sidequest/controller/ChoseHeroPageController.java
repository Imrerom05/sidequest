package sidequest.controller;

import sidequest.MyWindow;
import sidequest.NavigationManager;
import sidequest.view.ChoseHeroPageView;


public class ChoseHeroPageController {
  private final ChoseHeroPageView view;
      
  
  /** Constructs a new StartPageController. Initializes the view and UI event handlers. */
  public ChoseHeroPageController() {
    this.view = new ChoseHeroPageView();
    initialize();
  }

  /**
   * Returns the view associated with this controller.
   *
   * @return the StartPageView instance
   */
  public ChoseHeroPageView getView() {
    return view;
  }

  /** Initializes UI event listeners and bindings for buttons and input fields. */
  private void initialize() {
    view.getBackButton().setOnAction(event -> NavigationManager.navigate(new WorldPageController().getView()));
    view.getExitButton().setOnAction(event -> MyWindow.closeApplication());
  }
  
}
