package BaseClasses;

import Models.Member;
import Interfaces.ICheckin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CapacityCheckinBase implements ICheckin, Serializable {
    private int currentCapacity = 0;
    private int maxCapacity = 10;
    private List<Member> checkedInMembers = new ArrayList<>();
    private static final long serialVersionUID = 0;

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String Checkin(Member member) {
        if (currentCapacity < maxCapacity) {
            checkedInMembers.add(member);
            currentCapacity++;
            return "Successfly Checked-in";
        } else {
            return "Capacity is full. Cannot check in more members.";
        }
    }

    public String Checkout(Member member) {
            checkedInMembers.remove(member);
            currentCapacity--;
            return "Successfully Checked-out";
    }

    protected String ListCheckedInMembers() {
        StringBuilder result = new StringBuilder();
        for (Member member : checkedInMembers) {
            result.append(member.getName()).append("\n");
        }
        return result.toString();
    }
}