package Models;

import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;

public class Restaurant extends CapacityCheckinBase implements ICountryClubFacility {
    private final String welcomeMessage = "Welcome to Country Club Restaurant facility!";
    private final String hoursOfOperation = "Mon: 11:00AM - 11:00PM\nTues 11:00AM - 11:00PM\\nWend:11:00AM - 11:00PM\nThurs:11:00AM - 11:00PM\nFri:11:00AM - 11:00PM\nSat:11:00AM - 11:00PM\nSun:Closed";

    public Restaurant(int capacity)
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

    public void MakeReservation(int reservationDate, Member member, int howManyInPartyint) {
    }

}
