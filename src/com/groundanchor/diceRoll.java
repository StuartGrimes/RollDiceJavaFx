package com.groundanchor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class diceRoll extends Application{

    public diceRoll(){}

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button rollIt = new Button("Roll It");
        Stage window  = primaryStage;
        GridPane layout = new GridPane();
        Text sceneTitle = new Text("Roll a dice");
        Label valueRolled = new Label();
        //set padding for the objects on the grid pane
        layout.setHgap(5);
        layout.setVgap(10);
        layout.setPadding(new Insets(0, 10, 0, 10));
        layout.setAlignment(Pos.CENTER);

        //add out scene title to our root element
        layout.add(sceneTitle, 0, 1, 1, 1);
        GridPane.setHalignment(sceneTitle, HPos.CENTER);
        //add out dice roll button to our root element
        layout.add(rollIt, 0,4,1,1);
        //we need to un anchor the max button size to allow it to span columns
        rollIt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        rollIt.setOnAction(event -> {
            layout.getChildren().removeAll(valueRolled);
            int rolled = 1 + (int) (Math.random() * 6);
            valueRolled.setText("You rolled a " + rolled);
            layout.add(valueRolled, 0,3,1,1);
        });

        Scene scene = new Scene(layout, 200, 120);
        window.setScene(scene);
        window.show();
    }
}
