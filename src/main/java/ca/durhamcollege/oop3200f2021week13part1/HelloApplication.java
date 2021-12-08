package ca.durhamcollege.oop3200f2021week13part1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        // 1. Instantiate Control
        Label helloLabel = new Label("Hello, World!");
        // helloLabel.setPadding(new Insets(5, 20, 5, 5));
        Label goodbyeLabel = new Label("Good Bye!");

        Label helloLabel1 = new Label("Hello, World!");
        Label goodbyeLabel1 = new Label("Good Bye!");

        Button clickMeButton = new Button("Click Me!");

        // 2. Instantiate container
        //HBox hbox = new HBox(); // Horizontal stack
        // hbox.setPadding(new Insets(20));
        // hbox.setSpacing(10);
        // hbox.setAlignment(Pos.CENTER);
        // hbox.setLayoutX(320);
        // hbox.setLayoutY(240);

        //hbox.getChildren().add(helloLabel); // similar to add child function
        //hbox.getChildren().add(goodbyeLabel);

        GridPane row0 = buildRow0(helloLabel, goodbyeLabel);

        GridPane row1 = buildRow1(helloLabel1, goodbyeLabel1);

        GridPane row2 = buildRow2(clickMeButton);

        VBox vbox = new VBox(row0, row1, row2); // Vertical stack

        vbox.setStyle("-fx-border-color: red; -fx-border-width: 1px; -fx-font-family: Consolas");

        // 3. Step up scene
        Scene scene = new Scene(vbox, 640, 480);

        // 4. Set up stage
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane buildRow0(Label helloLabel, Label goodbyeLabel) {
        GridPane row = new GridPane();

        row.setStyle("-fx-border-color: green;" +
                     "-fx-border-width: 1px; " +
                     "-fx-font-family: 'Garamond';" +
                     "-fx-font-size: 20px");

        helloLabel.setStyle("-fx-font-family: 'Arial Black'; -fx-font-weight: bold; -fx-text-fill: green;");

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(16); // two columns - each column is 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(32);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(32);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(16);

        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        HBox hbox = new HBox(helloLabel);

        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle("-fx-border-color: black; -fx-border-width: 1px;");

        row.add(hbox, 1, 0);
        row.add(goodbyeLabel, 2, 0);

        /*var firstNode = row.getChildren().get(0);
        firstNode.setVisible(false);*/
        return row;
    }

    private GridPane buildRow1(Label helloLabel, Label goodbyeLabel) {
        GridPane row = new GridPane();

        row.setStyle("-fx-border-color: blue; -fx-border-width: 1px;");

        helloLabel.setOnMouseEntered(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                helloLabel.setStyle("-fx-font-weight: bold");
            }
        });

        helloLabel.setOnMouseExited(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                helloLabel.setStyle("-fx-font-weight: normal");
            }
        });

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(8); // two columns - each column is 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(48);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(24);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(16);

        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        row.add(helloLabel, 1, 0);
        row.add(goodbyeLabel, 2, 0);

        return row;
    }

    private GridPane buildRow2(Button button) {
        GridPane row = new GridPane();

        ColumnConstraints column0 = new ColumnConstraints();
        column0.setPercentWidth(16); // two columns - each column is 8%
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(32);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(32);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(16);

        row.getColumnConstraints().addAll(column0, column1, column2, column3);

        button.setOnAction(new EventHandler()
        {
            @Override
            public void handle(Event event)
            {
                System.out.println("clickMeButton Clicked!!!!");
            }
        });

        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                button.setStyle("-fx-opacity: 0.5");
            }
        });

        button.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                button.setStyle("-fx-opacity: 1.0");
            }
        });

        row.add(button, 2, 0);

        return row;
    }

    public static void main(String[] args)
    {
        launch();
    }
}