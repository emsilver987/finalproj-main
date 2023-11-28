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

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String Checkin(Member member) {
        if (currentCapacity < maxCapacity) {
            checkedInMembers.add(member);
            currentCapacity++;
            return "Success";
        } else {
            return "Capacity is full. Cannot check in more members.";
        }
    }

    protected String ListCheckedInMembers() {
        StringBuilder result = new StringBuilder();
        for (Member member : checkedInMembers) {
            result.append(member.getName()).append("\n");
        }
        return result.toString();
    }
}