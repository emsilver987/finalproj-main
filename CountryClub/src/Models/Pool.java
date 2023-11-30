package Models;

import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;
import java.io.Serializable;


public class Pool extends CapacityCheckinBase implements ICountryClubFacility, Serializable {
    private final String welcomeMessage = "Welcome to Country Club Pool facility!";
    private final String hoursOfOperation = "Mon: 9:00AM - 11:00PM\nTues:9:00AM - 11:00PM\nWend:9:00AM - 11:00PM\nThurs:9:00AM - 11:00PM\nFri:9:00AM - 11:00PM\nSat:11:00AM - 11:00PM\nSun:Closed\n";
    private final String optionsString = "What would you like to do today\n1 - Check in\n2 - Check out\n3 - See Hours\n";

    public Pool(int capacity)
    {
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
    public String WorkHours() {
        return hoursOfOperation;
    }
    public String Options() {
        WelcomeMessage();
        return optionsString;
    }

    @Override
    protected void initializeHours() {
        hoursOfOperationMap.put("MONDAY", new String[] { "09:00", "23:00" });
        hoursOfOperationMap.put("TUESDAY", new String[] { "09:00", "23:00" });
        hoursOfOperationMap.put("WEDNESDAY", new String[] { "09:00", "23:00" });
        hoursOfOperationMap.put("THURSDAY", new String[] { "09:00", "23:00" });
        hoursOfOperationMap.put("FRIDAY", new String[] { "09:00", "23:00" });
        hoursOfOperationMap.put("SATURDAY", new String[] { "11:00", "23:00" });
    }

}
