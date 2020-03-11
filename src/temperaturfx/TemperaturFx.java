/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperaturfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author rant
 */
public class TemperaturFx extends Application {

    Label label1, label2, label3;
    TextField textField;
    RadioButton radio1, radio2;

    @Override
    public void start(Stage primaryStage) {
        label1 = new Label("Enter Celsius temperature: ");
        textField = new TextField();
        radio1 = new RadioButton("Fahrenheit ");
        radio2 = new RadioButton("Kelvin ");
        radio1.setOnAction(new ConvertTempr());
        radio2.setOnAction(new ConvertTempr());
        HBox hb = new HBox(radio1, radio2);
        ToggleGroup to = new ToggleGroup();
        to.getToggles().addAll(radio1, radio2);
        label2 = new Label("New Temperature in is: ");
        label3 = new Label();
        HBox hb2 = new HBox(label2, label3);
        hb.setAlignment(Pos.CENTER);
        hb2.setAlignment(Pos.CENTER);

        VBox vb = new VBox(10, label1, textField, hb, hb2);
        vb.setAlignment(Pos.CENTER);
        Scene s = new Scene(vb, 350, 180);
        primaryStage.setTitle("Temperature Converter");
        primaryStage.setScene(s);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private class ConvertTempr implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == radio1) {
                double Celsiusf = Double.parseDouble(textField.getText());
                label3.setText(Celsiusf * 9 / 5 + 32 + "");

            } else if (event.getSource() == radio2) {
                double Celsiusk = Double.parseDouble(textField.getText());
                label3.setText(Celsiusk + 273.15 + "");
            }
        }

    }
}
