package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public NumberTextField inputField;
    public MyChoiceBox inputType;
    public NumberTextField outputField;
    public MyChoiceBox outputType;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("textfield changed from " + oldValue + " to " + newValue);
            System.out.println(inputField.getText());
            recalculate();
        });

        inputType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            inputType.setSelected(newValue);
            System.out.println("blbld"+newValue);
        });
        outputType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            outputType.setSelected(newValue);
            System.out.println("changed choice box");
        });
    }

    public void recalculate(){
        System.out.println("do"+inputType.getSelected());
    }
}
