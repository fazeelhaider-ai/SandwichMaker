package sample;

import java.util.ArrayList;

public class Order implements Customizable {
    public static int lineNumber;
    private ArrayList<OrderLine> orderlines;

    public Order() {
        orderlines = new ArrayList<OrderLine>();
    }
    public int getLineNumber() {
        return lineNumber + 1;
    }

    public void setLineNumber(int number) {
        lineNumber = lineNumber + number;
    }
    public boolean orderlineCheck (){
        if(orderlines != null){
            return true;
        }
        return false;
    }


    public Object getallOrders(){
        return orderlines ;
    }
    public double getAllPrices(){
        double result = 0.0;
        OrderLine od = new OrderLine();
        for (int i = 0; i < orderlines.size() ; i++) {
             result = result + od.getPrice();
        }
        return result;
    }


    @Override
    public boolean add(Object obj) {
        if(orderlines.contains(obj)){
            setLineNumber(1);
        }
        else{
        }
        lineNumber = lineNumber + 1;
        orderlines.add((OrderLine) obj);


        return false;
    }

    @Override
    public boolean remove(Object obj) {
        orderlines.remove((OrderLine) obj);
        lineNumber = lineNumber - 1;
        return false;
    }


}
