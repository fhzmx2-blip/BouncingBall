package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.stream.Stream;


public class View extends Application {
    Controller viewerController = new Controller();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane buttonAndPane = new BorderPane();

        VBox buttonBar = new VBox();
        buttonBar.setPrefWidth(100);
        buttonBar.setStyle("-fx-border-color: lightgray; -fx-border-width: 0 3 0 0;");

        Pane pane = new Pane();

        buttonAndPane.setLeft(buttonBar);
        buttonAndPane.setCenter(pane);

        stage.setScene(new Scene(buttonAndPane, 740, 480));
        stage.show();


        VBox controllButton = new VBox(50);

        Button addButton = new Button("+");
        Button removeButton = new Button("-");
        Button playButton = new Button("▶/■");
        Button deleteList = new Button("delete List");

        Button[] buttons = {addButton, removeButton, playButton, deleteList};
        for (Button button : buttons){
            button.setPrefSize(100,25);
            button.setFont(Font.font("나눔바른고딕", FontWeight.BOLD, 14));
        }

        ComboBox<Color> groupSelect = new ComboBox<>();
        ComboBoxDesign(groupSelect);

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.getStyleClass().add(colorPicker.STYLE_CLASS_SPLIT_BUTTON);
        colorPicker.setOnAction(e -> viewerController.colorSelect(groupSelect, colorPicker.getValue()));
        colorPicker.setOnHidden(e -> stage.requestFocus());

        addButton.setOnAction(e -> viewerController.addBall(pane, groupSelect));
        removeButton.setOnAction(e -> viewerController.removeBall(pane, groupSelect));
        playButton.setOnAction(e -> viewerController.onOffSwitch(groupSelect));
        deleteList.setOnAction(e -> viewerController.deleteList(pane, groupSelect));

        Stream.of(addButton, removeButton, deleteList, playButton).forEach(btn -> btn.disableProperty().bind(groupSelect.valueProperty().isNull()));

        controllButton.getChildren().addAll(groupSelect, colorPicker ,addButton, removeButton, playButton, deleteList);
        buttonBar.getChildren().add(controllButton);
    }






    private static void ComboBoxDesign(ComboBox<Color> groupSelect) {
        groupSelect.setPromptText("색상 목록");
        groupSelect.setCellFactory(lv -> new ListCell<Color>() {
            private final Rectangle rect = new Rectangle(15, 15);

            @Override
            protected void updateItem(Color c, boolean empty) {
                super.updateItem(c, empty);

                if (empty || c == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    rect.setFill(c);
                    rect.setStroke(Color.BLACK);
                    rect.setStrokeWidth(1);

                    int r = (int) Math.round(c.getRed() * 255);
                    int g = (int) Math.round(c.getGreen() * 255);
                    int b = (int) Math.round(c.getBlue() * 255);

                    setText(String.format("%d.%d.%d", r, g, b));

                    setGraphic(rect);
                    setGraphicTextGap(10);

                    setFont(Font.font("나눔바른고딕", FontWeight.BOLD, 10));
                }
            }
        });
        groupSelect.setButtonCell(groupSelect.getCellFactory().call(null));
    }
}
