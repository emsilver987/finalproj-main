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

public class CapacityCheckinBase implements ICheckin, Serializable {
    private int currentCapacity = 0;
    private int maxCapacity = 10;
    private List<Member> checkedInMembers = new ArrayList<>();
    private static final long serialVersionUID = 0;
    private final Map<String, String[]> hoursOfOperation;

    public CapacityCheckinBase(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.hoursOfOperation = new HashMap<>();
        initializeHours();
    }

    @Override
    public String Checkin(Member member) {
        if (!canCheckInNow()) {
            return "Cannot check in. Club is currently closed.\n";
        }

        if (currentCapacity < maxCapacity) {
            // checkedInMembers.add(member);
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

    private void initializeHours() {
        hoursOfOperation.put("MONDAY", new String[]{"09:00", "23:00"});
        hoursOfOperation.put("TUESDAY", new String[]{"09:00", "23:00"});
        hoursOfOperation.put("WEDNESDAY", new String[]{"09:00", "23:00"});
        hoursOfOperation.put("THURSDAY", new String[]{"09:00", "23:00"});
        hoursOfOperation.put("FRIDAY", new String[]{"09:00", "23:00"});
        hoursOfOperation.put("SATURDAY", new String[]{"11:00", "23:00"});
        // Closed on Sundays
    }
    private boolean canCheckInNow() {
        LocalDateTime now = LocalDateTime.now();
        String dayOfWeek = now.getDayOfWeek().toString();
        if (!hoursOfOperation.containsKey(dayOfWeek)) {
            return false; // Club is closed today
        }

        String[] operationHours = hoursOfOperation.get(dayOfWeek);
        LocalDateTime openTime = LocalDateTime.parse(now.toLocalDate().toString() + "T" + operationHours[0] + ":00");
        LocalDateTime closeTime = LocalDateTime.parse(now.toLocalDate().toString() + "T" + operationHours[1] + ":00");

        return now.isAfter(openTime) && now.isBefore(closeTime);
    }

}