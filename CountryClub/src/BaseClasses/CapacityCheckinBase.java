package BaseClasses;

import java.util.ArrayList;
import java.util.List;

import Interfaces.ICheckin;
import Models.Member;

public class CapacityCheckinBase implements ICheckin {
    int currentCapacity = 0;
    int maxCapacity = 10;

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    List<Member> checkedInMembers = new ArrayList<Member>();

    @Override
    public void Checkin(Member member) {
        checkedInMembers.add(member);
        currentCapacity++;
    }

    protected String ListCheckedInMembers() {
        String result = "";
        for (Member member : checkedInMembers) {
            result+=member.getName() + "\n";
        }
        return result;
    }

}
