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

public class Main extends Application implements EventHandler<ActionEvent> {
    DeckOfCards deck = new DeckOfCards();
    Button DrawHand;
    Button Shuffle;

    @Override
    public void start(Stage stage) {
        // Set the title of the stage
        stage.setTitle("Playing Card App");

        // Create a vertical box to hold the buttons
        VBox rightMenue = new VBox();
        DrawHand = new Button("Draw Hand");
        DrawHand.setOnAction(this);

        DrawHand.setOnAction(e -> {
            System.out.println("Drawing a hand of 5 cards: " + deck.dealHand(5));
        });

        Shuffle = new Button("Shuffle Deck");
        Shuffle.setOnAction(this);
        rightMenue.getChildren().addAll(DrawHand, Shuffle);

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

        HBox hand = new HBox();

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

