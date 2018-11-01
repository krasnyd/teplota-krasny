package david.fyz;

import javafx.fxml.Initializable;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public NumberTextField inputField;
    public MyChoiceBox inputType;
    public NumberTextField outputField;
    public MyChoiceBox outputType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        inputField.setText("0");
        outputField.setText("0");

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

        double outputValue;
        if(inputJednotka == Jednotka.CELSIUS && outputJednotka == Jednotka.KELVIN){
            outputValue = inputValue + 273.15;
        } else if(inputJednotka == Jednotka.CELSIUS && outputJednotka == Jednotka.FAHRENHEIT){
            outputValue = 1.8 * (inputValue) + 32;
        } else if(inputJednotka == Jednotka.KELVIN && outputJednotka == Jednotka.CELSIUS){
            outputValue = inputValue - 273.15;
        } else if(inputJednotka == Jednotka.KELVIN && outputJednotka == Jednotka.FAHRENHEIT){
            outputValue = inputValue * 1.8 - 459.67;
        } else if(inputJednotka == Jednotka.FAHRENHEIT && outputJednotka == Jednotka.CELSIUS){
            outputValue = (inputValue - 32) / 1.8;
        } else if(inputJednotka == Jednotka.FAHRENHEIT && outputJednotka == Jednotka.KELVIN){
            outputValue = (inputValue + 459.67) * 5/9;
        } else {
            outputValue = inputValue;
        }

        outputField.setText(beautifulPrint(outputValue));
    }

    private String beautifulPrint(double num){
        DecimalFormat f = new DecimalFormat("##.00");
        return f.format(num);
    }
}
