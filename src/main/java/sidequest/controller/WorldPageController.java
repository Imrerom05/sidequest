package sidequest.controller;

import javafx.beans.value.ChangeListener;
import sidequest.MyWindow;
import sidequest.view.WorldPageView;

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
  }

  
}
