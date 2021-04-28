package sample;

public class OrderLine {
    private int lineNumber;  // a serial number created when a sandwich is added to the order
    private Sandwich sandwich;
    private double price;


    public OrderLine(){

    }

    public OrderLine(Sandwich sandwich){
        Order od = new Order();
        this.lineNumber = od.getLineNumber();
        this.sandwich = sandwich;
        price = sandwich.price();
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = this.lineNumber +  lineNumber;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public double getPrice() {
        //loop through all the orders and start adding up all their prices and then do decimal formatter and send that formatted value
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString(){
        return  lineNumber + " " +  sandwich + "\n";

    }
}
