package entities;

import java.util.ArrayList;
import java.util.List;

public class BillImplementation implements Bill{

    private final List<Item> items;

    public BillImplementation() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }
}
