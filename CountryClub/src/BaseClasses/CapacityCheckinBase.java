package BaseClasses;

import Models.Member;
import Interfaces.ICheckin;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public abstract class CapacityCheckinBase implements ICheckin, Serializable {
    private int currentCapacity = 0;
    private int maxCapacity = 10;
    private List<Member> checkedInMembers = new ArrayList<>();
    private static final long serialVersionUID = 0;
    protected final Map<String, String[]> hoursOfOperationMap;

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.hoursOfOperationMap = new HashMap<>();
        initializeHours();
    }

    @Override
    public String Checkin(Member member) {
        if (!canCheckInNow()) {
            return "Cannot check in. Club is currently closed.\n";
        }

        if (currentCapacity < maxCapacity) {
            checkedInMembers.add(member);
            currentCapacity++;
            return "Successfully Checked-in\n";
        } else {
            return "Capacity is full. Cannot check in more members.\n";
        }
    }

    public String Checkout(Member member) {
        if (checkedInMembers.contains(member)) {
            checkedInMembers.remove(member);
            currentCapacity--;
            return "Successfully Checked-out\n";
        } else {
            return "You are not checked-in and therefore may not check out\n";
        }
    }

    protected String ListCheckedInMembers() {
        StringBuilder result = new StringBuilder();
        for (Member member : checkedInMembers) {
            result.append(member.getName()).append("\n");
        }
        return result.toString();
    }

    protected abstract void initializeHours();

    private boolean canCheckInNow() {
        LocalDateTime now = LocalDateTime.now();
        String dayOfWeek = now.getDayOfWeek().toString();
        if (!hoursOfOperationMap.containsKey(dayOfWeek)) {
            return false; // Club is closed today
        }

        String[] operationHours = hoursOfOperationMap.get(dayOfWeek);
        LocalDateTime openTime = LocalDateTime.parse(now.toLocalDate().toString() + "T" + operationHours[0] + ":00");
        LocalDateTime closeTime = LocalDateTime.parse(now.toLocalDate().toString() + "T" + operationHours[1] + ":00");

        return now.isAfter(openTime) && now.isBefore(closeTime);
    }

}