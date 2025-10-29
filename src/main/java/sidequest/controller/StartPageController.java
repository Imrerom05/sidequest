package sidequest.controller;
import javafx.beans.value.ChangeListener;
import sidequest.MyWindow;
import sidequest.view.StartPageView;

/**
 * Controller for the start page. Handles input validation, new game creation, loading saved games,
 * and navigation to the appropriate game or setup views.
 */
public class StartPageController {
  private final StartPageView view;

  /** Constructs a new StartPageController. Initializes the view and UI event handlers. */
  public StartPageController() {
    this.view = new StartPageView();
    initialize();
  }

  /**
   * Returns the view associated with this controller.
   *
   * @return the StartPageView instance
   */
  public StartPageView getView() {
    return view;
  }

  /** Initializes UI event listeners and bindings for buttons and input fields. */
  private void initialize() {
    view.getConfirmButton().setOnAction(event -> handleConfirm());
    view.getExitButton().setOnAction(event -> MyWindow.closeApplication());
    view.getLoadGameButton().setOnAction(event -> handleLoad());

    ChangeListener<Object> enabler =
        (obs, oldV, newV) -> view.getConfirmButton().setDisable(!allInputsValid());
    view.getGameNameField().textProperty().addListener(enabler);
    view.getPlayerCountBox().valueProperty().addListener(enabler);
    view.getGameSelectorBox().valueProperty().addListener(enabler);

    view.getSavedGamesBox()
        .valueProperty()
        .addListener((obs, oldV, newV) -> view.getLoadGameButton().setDisable(newV.isEmpty()));
  }

  /**
   * Validates that all required inputs for starting a new game are provided.
   *
   * @return true if all required inputs are valid; false otherwise
   */
  private boolean allInputsValid() {
    return !view.getGameNameField().getText().isBlank()
        && view.getPlayerCountBox().getValue() != null
        && view.getGameSelectorBox().getValue() != null;
  }

  /** Handles confirmation for starting a new game. Validates input before proceeding. */
  private void handleConfirm() {
    String gameName = view.getGameNameField().getText();
    Integer selectedPlayerCount = view.getPlayerCountBox().getValue();

    if (gameName.contains(",")) {
      return;
    }

    if (selectedPlayerCount != null && !gameName.isEmpty()) {
      startGame(selectedPlayerCount, view.getGameSelectorBox().getValue(), gameName);
    } else {
    }
  }

  /**
   * Starts a new game based on user input.
   *
   * @param playerCount number of players for the game
   * @param gameType the selected game type ("Lader Game Classic", "Lader Game Quiz", or "Risk")
   * @param gameName the name of the game to be created
   */
  private void startGame(Integer playerCount, String gameType, String gameName) {
     // NavigationManager.navigate(new CreatePlayerPageController(game).getView());
  }

  /**
   * Handles loading a previously saved game from disk based on user selection. Navigates to the
   * appropriate game page view.
   */
  private void handleLoad() {
    String selectedGame = view.getSavedGamesBox().getValue();
    if (selectedGame != null) {
      String[] gameData = selectedGame.split("\\(");
      String gameName = gameData[0].trim();
      String gameType = gameData[1].replace(")", "").trim();

    }
  }
}
