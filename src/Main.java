import entities.*;
import services.BillSplitter;
import services.BillSplitterImplementation;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Restaurant restaurant = new RestaurantImplementation("Tasty Bites");
        restaurant.addItemToBill(new Item("Pizza", 200));
        restaurant.addItemToBill(new Item("Pasta", 150));
        restaurant.addItemToBill(new Item("Soda", 50));

        Bill bill = restaurant.getCurrentBill();

        List<Friend> friends = new ArrayList<>();
        friends.add(new Friend("Alice"));
        friends.add(new Friend("Bob"));
        friends.add(new Friend("Charlie"));

        BillSplitter splitter = new BillSplitterImplementation();

        // Split bill evenly
        splitter.splitEvenlyToFriends(bill, friends);

        System.out.println("Total bill: $" + bill.getTotalAmount());
        for (Friend friend : friends) {
            System.out.println(friend.getName() + " pays: $" + String.format("%.2f", friend.getAmountToPay()));
        }

        // Split bill by custom ratio (e.g., Alice pays 2 parts, Bob and Charlie pay 1 part each)
        List<Integer> ratios = List.of(2, 1, 1);
        splitter.splitByCustomRatio(bill, friends, ratios);

        System.out.println("\nSplitting by custom ratio:");
        for (Friend friend : friends) {
            System.out.println(friend.getName() + " pays: $" + String.format("%.2f", friend.getAmountToPay()));
        }
    }
}