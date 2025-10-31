package sidequest.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import sidequest.model.game.hero.Hero;

public class NewHeroView extends VBox {

    private final Label nameLabel;
    private final Label heroInfoLabel;
    private final ImageView heroImage;
    private final Label statsLabel;
    private final Label descriptionLabel;
    private final Button selectButton;

    public NewHeroView(Hero hero) {
        // Basic layout setup
        setSpacing(10);
        setPadding(new Insets(10));
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #2b2b2b; -fx-border-color: #888; -fx-border-radius: 10; -fx-background-radius: 10;");
        
        // Hero name
        nameLabel = new Label(hero.getName());
        nameLabel.setFont(Font.font("Arial", 18));
        nameLabel.setStyle("-fx-text-fill: white;");

        heroInfoLabel = new Label(hero.getHeroInfo());
        heroInfoLabel.setStyle("-fx-text-fill: #cccccc;");

        // Hero image
        heroImage = new ImageView();
        try {
            heroImage.setImage(new Image(getClass().getResourceAsStream("/images/heroes/" + hero.getImage() + ".png")));
        } catch (Exception e) {
            System.out.println("/images/heroes/" + hero.getImage() + ".png");
        }
        heroImage.setFitWidth(120);
        heroImage.setFitHeight(120);
        heroImage.setPreserveRatio(true);

        // Stats
        statsLabel = new Label(hero.getStatsDescriprion());
        statsLabel.setStyle("-fx-text-fill: #cccccc;");

        descriptionLabel = new Label(hero.getDescription());
        descriptionLabel.setStyle("-fx-text-fill: #cccccc;");

        // Select button
        selectButton = new Button("Select");
        selectButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");

        // Assemble layout
        getChildren().addAll(nameLabel,heroInfoLabel, heroImage, statsLabel, descriptionLabel, selectButton);
    }

    // Getters for controller access
    public Button getSelectButton() {
        return selectButton;
    }
}