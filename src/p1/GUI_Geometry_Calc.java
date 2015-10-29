/**
 * Created by pdingus on 10/29/2015.
 */

package p1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_Geometry_Calc extends Application {
    public void start(Stage primaryStage) {
        //These must be visible to the inner class
        TextField tfLength = new TextField();
        TextField tfHeight = new TextField();
        Label lbArea = new Label();
        Label lbPerimeter = new Label();


        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10, 10, 10, 10));

        // Set horizontal and vertical gaps between elements
        pane.setHgap(5);
        pane.setVgap(5);

        // Length label and field
        pane.add(new Label("Length:"), 0, 0);
        pane.add(tfLength, 1, 0);

        // Height name label and field
        pane.add(new Label("Height:"), 0, 1);
        pane.add(tfHeight, 1, 1);

        // Add Area label and field
        pane.add(new Label("Area:"), 0, 2);
        pane.add(lbArea, 1, 2);

        // Add Perimeter label and field
        pane.add(new Label("Perimeter:"), 0, 3);
        pane.add(lbPerimeter, 1, 3);

        // Add a button one the right of the next row in the grid
        Button btAdd = new Button("Calculate");
        pane.add(btAdd, 1, 4);
        GridPane.setHalignment(btAdd, HPos.LEFT);

        btAdd.setOnAction(new EventHandler<ActionEvent> () {

            @Override
            public void handle(ActionEvent e){
                //convert text field inputs to variables of type double
                double height = new Double(tfHeight.getText()).doubleValue();
                double length = new Double(tfLength.getText()).doubleValue();

                //do math for area and perimeter, store to variables
                double area = height * length;
                double perimeter = height + height + length + length;

                //set label fields with results
                lbArea.setText("" + height * length);
                lbPerimeter.setText("" + perimeter);
            }
        });

        // Put the pane in the scene (autofit)
        Scene scene = new Scene(pane);

        // Set the stage up, put the scene on the stage and show it
        primaryStage.setTitle("GUI_Geometry_Calc");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
