package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;


import java.io.FileNotFoundException;


public class App extends Application implements IPositionChangeObserver {
    AbstractWorldMap map;   // może private final?
    SimulationEngine engine;    // jw.
    GridPane grid = new GridPane(); // jw.
    public static int moveDelay;    // static? public?
    int size = 50;


    public void init() throws Exception {
        super.init();
        try {
            this.map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2,2), new Vector2d(3, 4)};
            this.engine = new SimulationEngine(map, positions, 900);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        for (Vector2d elem : map.getAnimals().keySet()) {
            if (map.getElement(elem) instanceof Animal) {
                map.getElement(elem).addObserver(this);
            }
        }

        Button button = new Button("Start");
        TextField textField = new TextField("f f f f");

        button.setOnAction(event -> {
            MoveDirection[] moves = OptionsParser.parse(textField.getText().split(" "));
            engine.getMoves(moves); // a nie setMoves?
            Thread thread = new Thread(engine);
            thread.start();
        });

        System.out.println("tuy");
        HBox movesInput = new HBox(button, textField);
        movesInput.setSpacing(30);
        VBox mainBox = new VBox(grid, movesInput);
        mainBox.setAlignment(Pos.CENTER);

        Vector2d upperRight = map.findUpperRight();
        Vector2d lowerLeft = map.findLowerLeft();
        grid();
        Scene scene = new Scene(mainBox, upperRight.x * size + 200 - lowerLeft.x * size,
                upperRight.y * size + 200 - lowerLeft.y * size);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Okno aplikacji");
        primaryStage.show();

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Platform.runLater(() -> {
            try {
                grid();
            } catch(FileNotFoundException ex) {
                ex.printStackTrace();
                System.out.println(ex.getMessage());
            }
        });
    }

    private void grid() throws FileNotFoundException {  // nazwa
        grid.setGridLinesVisible(false);
        grid.getChildren().clear();
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();

        Label label = new Label("y/x");
        grid.add(label, 0, 0, 1, 1);
        grid.getColumnConstraints().add(new ColumnConstraints(50));
        grid.getRowConstraints().add(new RowConstraints(50));
        Vector2d upperRight = map.findUpperRight();
        Vector2d lowerLeft = map.findLowerLeft();
        GridPane.setHalignment(label, HPos.CENTER);
        grid.setGridLinesVisible(true);

        for(int i = lowerLeft.x; i <= upperRight.x; i++){
            Label label2 = new Label(" "+i+" ");
            grid.add(label2, i - lowerLeft.x + 1, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(50));
            GridPane.setHalignment(label2, HPos.CENTER);
        }

        for(int i = lowerLeft.y; i <= upperRight.y; i++){
            Label label3 = new Label(" "+i+" ");
            grid.add(label3, 0, upperRight.y - i + 1, 1, 1);
            grid.getRowConstraints().add(new RowConstraints(50));
            GridPane.setHalignment(label3, HPos.CENTER);
        }

        for(int i = lowerLeft.x; i <= upperRight.x; i++){
            for(int j = lowerLeft.y; j <= upperRight.y; j++){
                Vector2d pos = new Vector2d(i, j);
                if(map.objectAt(pos) != null){
                    GuiElementBox VBox = new GuiElementBox(map.getElement(pos));
                    grid.add(VBox.getBox(), pos.x - lowerLeft.x + 1, upperRight.y - pos.y + 1, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }
    }
}
