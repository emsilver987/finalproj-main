package Models;

import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;
import java.io.Serializable;


public class Gym extends CapacityCheckinBase implements ICountryClubFacility, Serializable{
    private final String welcomeMessage = "Welcome to Country Club gym facility!";
    private final String hoursOfOperation = "Mon: 9:00AM - 11:00PM\nTues:9:00AM - 11:00PM\nWend:9:00AM - 11:00PM\nThurs:9:00AM - 11:00PM\nFri:9:00AM - 11:00PM\nSat:11:00AM - 11:00PM\nSun:Closed";
    private final String optionsString = "What would you like to do today\n1 - Check in\n2 - Check out\n3 - See Hours";

    public Gym(int capacity)
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

}
