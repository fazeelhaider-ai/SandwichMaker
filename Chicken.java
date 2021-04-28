package sample;

import java.text.DecimalFormat;

public class Chicken extends Sandwich {


    @Override
    public double price() {
        double pay = 8.99;
        for (int i = 0; i < extras.size(); i++) {
            pay = pay + PER_EXTRA;
        }
        return pay;
    }

    @Override
    public String toString() {
        return   "Chicken Sandwich Fried Chicken, Spicy Sauce, Pickles, Extras: " + super.toString()  + "Price :$" + price() ;
    }


}
