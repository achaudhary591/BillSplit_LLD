package entities;

import java.util.List;

public interface Bill {

    double getTotalAmount();
    void addItem(Item item);
    public List<Item> getItems();
}
