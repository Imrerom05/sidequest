import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class Main extends Application {
    DeckOfCards deck = new DeckOfCards();
    Button DrawHand;
    Button Shuffle;
    Button Checkhand;
    ArrayList<String> curentHand;
    HandChecker handChecker = new HandChecker();

    @Override
    public void start(Stage stage) {
        // Set the title of the stage
        stage.setTitle("Playing Card App");

        HBox hand = new HBox();
        VBox rightMenue = new VBox();
        HBox bottomMenue = new HBox();
        

        // Create an images for cards
        Image clubsImage = new Image(getClass().getResourceAsStream("/clubs.png"));     
        Image dimondsImage = new Image(getClass().getResourceAsStream("/dimonds.png"));     
        Image heartsImage = new Image(getClass().getResourceAsStream("/hearts.png"));
        Image spadesImage = new Image(getClass().getResourceAsStream("/spades.png"));
        

        // Create a vertical box to hold the buttons
        DrawHand = new Button("Draw Hand");

        DrawHand.setOnAction(e -> {
            hand.getChildren().clear();
            curentHand = deck.dealHand(5);
            System.out.println("Drawing a hand " + curentHand);
            for (String card : curentHand) {
                String suit = card.substring(0, 1);
                String value = card.substring(1);
                if (value.equals("11")) {
                    value = "J";
                } else if (value.equals("12")) {
                    value = "Q";
                } else if (value.equals("13")) {
                    value = "K";
                } else if (value.equals("14")) {
                    value = "A";
                }

                if (suit.equals("H")) {
                    ImageView heartsView = new ImageView(heartsImage);
                    heartsView.setFitHeight(30);
                    heartsView.setFitWidth(30);
                    hand.getChildren().add(heartsView);
                } else if (suit.equals("D")) {
                    ImageView dimondsView = new ImageView(dimondsImage);
                    dimondsView.setFitHeight(30);
                    dimondsView.setFitWidth(30);
                    hand.getChildren().add(dimondsView);
                } else if (suit.equals("C")) {
                    ImageView clubsView = new ImageView(clubsImage);
                    clubsView.setFitHeight(30);
                    clubsView.setFitWidth(30);
                    hand.getChildren().add(clubsView);
                } else if (suit.equals("S")) {
                    ImageView spadesView = new ImageView(spadesImage);
                    spadesView.setFitHeight(30);
                    spadesView.setFitWidth(30);
                    hand.getChildren().add(spadesView);
                }
                hand.getChildren().add(new Label(value));
            }
        });


        Shuffle = new Button("Shuffle Deck");
        Shuffle.setOnAction(e -> {
            System.out.println("Shuffling the deck");
            deck.shuffle();
        });

        Checkhand = new Button("Cheek Hand");
        Shuffle.setOnAction(e -> {
            System.out.println("Checking the hand");
            bottomMenue.getChildren().add(new Label("Sum: " + handChecker.sum(curentHand)));
            bottomMenue.getChildren().add(new Label("Flush: " + handChecker.isFlush(curentHand)));
            bottomMenue.getChildren()
                    .add(new Label("Queen of Spades: " + handChecker.checkForQueenOfSpades(curentHand)));
            bottomMenue.getChildren().add(new Label("Amount of Hearts: " + handChecker.amountOfHearts(curentHand)));
        });

        rightMenue.getChildren().addAll(DrawHand, Shuffle, Checkhand);


        // Create a border pane to hold the buttons
        BorderPane borderPane = new BorderPane();
        borderPane.setRight(rightMenue);
        borderPane.setCenter(hand);


        // Create a scene
        Scene scene = new Scene(borderPane, 400, 300);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}

