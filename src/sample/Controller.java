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
            recalculate();
        });

        inputType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            inputType.setSelected(newValue);
            recalculate();
        });
        outputType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            outputType.setSelected(newValue);
            recalculate();
        });
    }

    private void recalculate(){
        System.out.println("---");
        double inputValue = inputField.getValue();
        System.out.println("input Value: "+inputValue);
        Jednotka inputJednotka = inputType.getSelected();
        Jednotka outputJednotka = outputType.getSelected();
        System.out.println(inputJednotka + " to " + outputJednotka);

        double outputValue = 0;
        if(inputJednotka == Jednotka.CELSIUS && outputJednotka == Jednotka.KELVIN){
            outputValue = inputValue + 273.15;
        } else if(inputJednotka == Jednotka.CELSIUS && outputJednotka == Jednotka.FAHRENHEIT){
            outputValue = 1.8 * (inputValue) + 32;
        } else {
            System.out.println("unsup");
        }

        outputField.setText(Double.toString(outputValue));
    }
}
