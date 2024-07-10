package services;

import entities.Bill;
import entities.Friend;

import java.util.List;

public interface BillSplitter {

    void splitEvenlyToFriends(Bill bill, List<Friend> friends);
    void splitByCustomRatio(Bill bill, List<Friend> friends, List<Integer> ratios);
}
