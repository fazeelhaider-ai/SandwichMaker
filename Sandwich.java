package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras ;

    //this ^ ArrayList Extra is the added extra ingredients which will be checked against MAX_EXTRA and if false then error displays that ingredients are too much.

    public abstract double price();



    public Object displayExtra() {
        return extras;
    }

    //set a breakpoint with a condition, when the size of extras becomes zero
    @Override
    public boolean add(Object obj) {
        if (extras.size() < MAX_EXTRAS) {
            extras.add((Extra) obj);
            for (int i = 0; i < extras.size(); i++) {
                System.out.println(extras.get(i));
            }
            System.out.println("size is :" + extras.size());
            return true;
        }

        return false;

    }
    public double getPriceSandwich(){
        return price();
    }


    @Override
    public boolean remove(Object obj) {
        if (extras.contains(obj)) {
            extras.remove((Extra) obj);
            System.out.println(obj + " is removed");
            System.out.println("new size is :" + extras.size());
            return true;
        }

        return false;
    }


    //this should return all the extra ingredients
    public String toString() {
        String result = "";
        for (int i = 0; i < extras.size(); i++) {
             result = result  + extras.get(i) + ", ";
        }

        return result;

    }

}
