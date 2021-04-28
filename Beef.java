package sample;

import javafx.collections.ObservableList;

public class Beef extends Sandwich {
    @Override
    public double price() {
        double pay = 10.99;
        for (int i = 0; i < extras.size(); i++) {
            pay = pay + PER_EXTRA;
        }
        return pay;
    }

    @Override
    public String toString() {
        return   "Beef Sandwich Roast Beef, Provolone Cheese, Mustard, Extras: " + super.toString()  + "Price :$"+ price();
    }

}
