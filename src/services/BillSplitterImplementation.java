package services;

import entities.Bill;
import entities.Friend;

import java.util.List;

public class BillSplitterImplementation implements BillSplitter{

    @Override
    public void splitEvenlyToFriends(Bill bill, List<Friend> friends) {

        if (friends == null || friends.isEmpty()) {
            throw new IllegalArgumentException("Friends list cannot be null or empty.");
        }

        double totalAmount = bill.getTotalAmount();
        int numberOfFriends = friends.size();
        double amountPerPerson = totalAmount / numberOfFriends;

        for (Friend friend : friends) {
            friend.setAmountToPay(amountPerPerson);
        }
    }

    @Override
    public void splitByCustomRatio(Bill bill, List<Friend> friends, List<Integer> ratios) {

        if (friends == null || friends.isEmpty()) {
            throw new IllegalArgumentException("Friends list cannot be null or empty.");
        }

        if (ratios == null || friends.size() != ratios.size()) {
            throw new IllegalArgumentException("Number of friends must match number of ratios");
        }

        for (Integer ratio : ratios) {
            if (ratio <= 0) {
                throw new IllegalArgumentException("Ratios must be positive integers");
            }
        }

        double totalAmount = bill.getTotalAmount();
        int totalRatio = ratios.stream().mapToInt(Integer::intValue).sum();

        for (int i = 0; i < friends.size(); i++) {
            double friendShare = (ratios.get(i) / (double) totalRatio) * totalAmount;
            friends.get(i).setAmountToPay(friendShare);
        }
    }
}
