package cz.krasnyd.teplota;

import javafx.scene.control.ChoiceBox;

public class MyChoiceBox extends ChoiceBox<String>{
    private Jednotka selected = Jednotka.CELSIUS;

    Jednotka getSelected() {
        return selected;
    }

    void setSelected(String value) {
        switch (value) {
            case "°C":
                this.selected = Jednotka.CELSIUS;
                break;
            case "°F":
                this.selected = Jednotka.FAHRENHEIT;
                break;
            case "K":
                this.selected = Jednotka.KELVIN;
                break;
            default:
                System.out.println("Neznámá jednotka");
                break;
        }

    }
}
