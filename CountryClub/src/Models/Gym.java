package Models;

import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;
import java.io.Serializable;

public class Gym extends CapacityCheckinBase implements ICountryClubFacility, Serializable {
    private final String welcomeMessage = "Welcome to Country Club gym facility!";
    private final String optionsString = "What would you like to do today\n1 - Check in\n2 - Check out\n3 - See Hours\n4 - Back to Facility Choice\n";

    public Gym(int capacity) {
        super(capacity);
    }

    @Override
    public String WelcomeMessage() {
        return welcomeMessage;
    }

    @Override
    public String ListCheckedInMembers() {
        return super.ListCheckedInMembers();
    }

    @Override
    public void WorkHours() {
        for (String day : hoursOfOperationMap.keySet()) {
            String[] hours = hoursOfOperationMap.get(day);
            System.out.println(day + ": " + hours[0] + " to " + hours[1] + " ");
        }
    }

    public String Options() {
        WelcomeMessage();
        return optionsString;
    }

    @Override
    protected void initializeHours() {
        hoursOfOperationMap.put("MONDAY", new String[] { "05:00", "23:00" });
        hoursOfOperationMap.put("TUESDAY", new String[] { "05:00", "23:00" });
        hoursOfOperationMap.put("WEDNESDAY", new String[] { "05:00", "23:00" });
        hoursOfOperationMap.put("THURSDAY", new String[] { "05:00", "23:00" });
        hoursOfOperationMap.put("FRIDAY", new String[] { "05:00", "23:00" });
        hoursOfOperationMap.put("SATURDAY", new String[] { "5:00", "23:00" });
        hoursOfOperationMap.put("Sunday", new String[] { "5:00", "14:00" });
    }

}
