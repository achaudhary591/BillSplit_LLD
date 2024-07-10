package entities;

public class RestaurantImplementation implements Restaurant{

    private final String name;
    private final Bill currentBill;

    public RestaurantImplementation(String name) {
        this.name = name;
        this.currentBill = new BillImplementation();
    }

    public String getName() {
        return this.name;
    }

    public void addItemToBill(Item item) {
        currentBill.addItem(item);
    }

    public Bill getCurrentBill() {
        return currentBill;
    }
}
