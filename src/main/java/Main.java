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
    ArrayList<String> curentHand;

    @Override
    public void start(Stage stage) {
        // Set the title of the stage
        stage.setTitle("Playing Card App");

        HBox hand = new HBox();
        

        // Create an image view for clubs
        Image clubsImage = new Image(getClass().getResourceAsStream("/clubs.png"));     
        ImageView clubsView = new ImageView(clubsImage);
        clubsView.setFitHeight(30);
        clubsView.setFitWidth(30);

        // Create an image view for dimonds
        Image dimondsImage = new Image(getClass().getResourceAsStream("/dimonds.png"));     
        ImageView dimondsView = new ImageView(dimondsImage);
        dimondsView.setFitHeight(30);
        dimondsView.setFitWidth(30);

        // Create an image view for hearts
        Image heartsImage = new Image(getClass().getResourceAsStream("/hearts.png"));     
        ImageView heartsView = new ImageView(heartsImage);
        heartsView.setFitHeight(30);
        heartsView.setFitWidth(30);

        // Create an image view for spades
        Image spadesImage = new Image(getClass().getResourceAsStream("/spades.png"));
        ImageView spadesView = new ImageView(spadesImage);
        spadesView.setFitHeight(30);
        spadesView.setFitWidth(30);

        // Create a vertical box to hold the buttons
        VBox rightMenue = new VBox();
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
                    hand.getChildren().add(heartsView);
                } else if (suit.equals("D")) {
                    hand.getChildren().add(dimondsView);
                } else if (suit.equals("C")) {
                    hand.getChildren().add(new ImageView(clubsImage));
                } else if (suit.equals("S")) {
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

        rightMenue.getChildren().addAll(DrawHand, Shuffle);


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

