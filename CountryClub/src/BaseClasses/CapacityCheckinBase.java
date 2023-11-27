package BaseClasses;

import Models.Member;
import Interfaces.ICheckin;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CapacityCheckinBase implements ICheckin, Serializable {
    private static final long serialVersionUID = 1L;
    int currentCapacity = 0;
    int maxCapacity = 10;

    private List<Member> checkedInMembers = new ArrayList<Member>();

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public void Checkin(Member member) {
        if(currentCapacity < maxCapacity) {
            checkedInMembers.add(member);
            currentCapacity++;
        }
        // You might want to handle the case where the capacity is full
    }

    protected String ListCheckedInMembers() {
        StringBuilder result = new StringBuilder();
        for (Member member : checkedInMembers) {
            result.append(member.getName()).append("\n");
        }
        return result.toString();
    }

    // getter for checkedInMembers if needed
}
