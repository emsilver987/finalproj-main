package Models;

import java.io.Serializable;
import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;

public class Restaurant extends CapacityCheckinBase implements ICountryClubFacility, Serializable {
    private final String welcomeMessage = "Welcome to Country Club Restaurant facility!";
    private final String hoursOfOperation = "Mon: 11:00AM - 11:00PM\nTues 11:00AM - 11:00PM\nWend:11:00AM - 11:00PM\nThurs:11:00AM - 11:00PM\nFri:11:00AM - 11:00PM\nSat:11:00AM - 11:00PM\nSun:Closed";
    private final String food = "1 - Burger : $15\n2 - Fish Tacos : $25\n3-Braised Beef Ragu : 30";
    private final String quanitityString = "How many would you like?";

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

    public String MakeReservation(int reservationDate, Member member, int howManyInPartyint) {
        return "Success";
    }

    public String menuOptions(){
        return food;
    }
    public String order(int foodChoice, int quantity){
        return "Succes you ordered: " + foodChoice + " " + quantity;
    }
    public String quantity(){
        return quanitityString;
    }

}
