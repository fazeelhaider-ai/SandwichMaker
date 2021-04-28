package sample;

import javafx.collections.ObservableList;

public class Fish extends Sandwich {
    @Override
    public double price() {
        double pay = 12.99;
        for (int i = 0; i < extras.size(); i++) {
            pay = pay + PER_EXTRA;
        }
        return pay;
    }

    @Override
    public String toString() {
        return "Fish Sandwich Grilled Snapper, Cilantro, Lime Extras: " + super.toString() + "Price :$" + price();
    }


}
