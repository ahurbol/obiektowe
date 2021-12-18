package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.Vector2d;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private final VBox vbox;

    public GuiElementBox(AbstractWorldMapElement elem) throws FileNotFoundException {
        Image image = null;
        try {
            image = new Image(new FileInputStream(elem.getPath()));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
        ImageView view = new ImageView(image);
        view.setFitHeight(30);
        view.setFitWidth(30);
        Vector2d pos = elem.getPosition();
        Label label = new Label(pos.x + ", " + pos.y);
        vbox = new VBox(0);
        vbox.getChildren().addAll(view, label);
        vbox.setPrefWidth(100);
        vbox.setAlignment(Pos.CENTER);

    }

    public VBox getBox() {
        return vbox;
    }
}
