package sample;

import javafx.scene.control.ChoiceBox;

public class MyChoiceBox extends ChoiceBox<String> {
    private Jednotky selected = Jednotky.CELSIUS;

    public Jednotky getSelected() {
        return selected;
    }

    public void setSelected(String value) {
        switch (value) {
            case "°C":
                this.selected = Jednotky.CELSIUS;
                break;
            case "°F":
                this.selected = Jednotky.FAHRENHEIT;
                break;
            case "K":
                this.selected = Jednotky.KELVIN;
                break;
            default:
                System.out.println("Neznámá jednotka");
                break;
        }

    }

    public enum Jednotky {
        CELSIUS,
        FAHRENHEIT,
        KELVIN
    }
}
