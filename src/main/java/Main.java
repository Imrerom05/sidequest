import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class Main extends Application implements EventHandler<ActionEvent> {
    DeckOfCards deck = new DeckOfCards();
    Button DrawHand;
    Button Shuffle;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Playing Card App");

        VBox rightMenue = new VBox();
        DrawHand = new Button("Draw Hand");
        DrawHand.setOnAction(this);
        Shuffle = new Button("Shuffle Deck");
        Shuffle.setOnAction(this);
        rightMenue.getChildren().addAll(DrawHand, Shuffle);

        BorderPane borderPane = new BorderPane();
        borderPane.setRight(rightMenue);


        Scene scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void handle(ActionEvent event) {
        if (event.getSource() == DrawHand) {
            System.out.println("Drawing a hand of 5 cards: " + deck.dealHand(5));
        }
        
        if (event.getSource() == Shuffle) {
            System.out.println("Shuffling the deck");
            deck.shuffle();
        } 

    }
}

