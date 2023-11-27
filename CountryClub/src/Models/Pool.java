package Models;

import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;

public class Pool extends CapacityCheckinBase implements ICountryClubFacility {
    private final String welcomeMessage = "Welcome to Country Club Pool facility!";
    private final String hoursOfOperation = "Mon: 9:00AM - 11:00PM\nTues:9:00AM - 11:00PM\\nWend:9:00AM - 11:00PM\nThurs:9:00AM - 11:00PM\nFri:9:00AM - 11:00PM\nSat:11:00AM - 11:00PM\nSun:Closed";

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

}
