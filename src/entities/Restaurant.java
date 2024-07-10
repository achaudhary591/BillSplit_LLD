package entities;

public interface Restaurant {

    void addItemToBill(Item item);
    String getName();
    public Bill getCurrentBill();
}
