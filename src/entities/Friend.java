package entities;


public class Friend {

    private final String name;
    private double amountToPay;

    public Friend(String name) {
        this.name = name;
        this.amountToPay = 0.0;
    }

    public void setAmountToPay(double amount) {
        this.amountToPay = amount;
    }

    public double getAmountToPay() {
        return amountToPay;
    }

    public String getName() {
        return name;
    }
}
