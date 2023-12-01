package Models;

import java.io.Serializable;
import BaseClasses.CapacityCheckinBase;
import Interfaces.ICountryClubFacility;
import java.util.Scanner;

public class Restaurant extends CapacityCheckinBase implements ICountryClubFacility, Serializable {
    private static final long serialVersionUID = -5979258196644527672L;
    private static final Scanner scanner = new Scanner(System.in);
    private final String welcomeMessage = "Welcome to Country Club Restaurant facility!";
    private final String food = "1 - Burger : $15\n2 - Fish Tacos : $25\n3 - Braised Beef Ragu : $30";
    private final String quantityString = "How many would you like?";
    private final String optionsString = "What would you like to do today\n1 - Check in\n2 - Check out\n3 - See Hours\n4 - Back to Facility Choice";

    public Restaurant(int capacity) {
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
            System.out.print(day + ": " + hours[0] + " to " + hours[1]);
        }
    }

    public String MakeReservation(int reservationDate, Member member, int howManyInPartyint) {
        return "Success";
    }

    public String menuOptions(){
        return food;
    }
    
    public void makeOrder() {
        boolean validChoice = false;
        int foodChoice, quantity;
    
        while (!validChoice) {
            displayMenu();
            System.out.println("Enter your food choice: ");
            foodChoice = scanner.nextInt();
    
            System.out.println(quantityString);
            quantity = scanner.nextInt();
    
            FoodChoiceEnum userResponse = FoodChoiceEnum.fromInt(foodChoice);
            if (userResponse == null) {
                System.out.println("Invalid food choice");
                continue;
            }
    
            switch (userResponse) {
                case Burger:
                    System.out.println("Success, you ordered: " + quantity + " Burgers");
                    validChoice = true;
                    break;
                case FishTacos:
                    System.out.println("Success, you ordered: " + quantity + " Fish Tacos");
                    validChoice = true;
                    break;
                case BraisedBeefRagu:
                    System.out.println("Success, you ordered: " + quantity + " Braised Beef Ragus");
                    validChoice = true;
                    break;
                default:
                    System.out.println("Unknown food choice");
                    break;
            }
        }
    }
    
    
    private void displayMenu() {
        System.out.println(menuOptions());
    }

    public String quantity(){
        return quantityString;
    }

    public enum FoodChoiceEnum {
        Burger(1),
        FishTacos(2),
        BraisedBeefRagu(3);

        private final int value;

        FoodChoiceEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static FoodChoiceEnum fromInt(int i) {
            for (FoodChoiceEnum r : FoodChoiceEnum.values()) {
                if (r.getValue() == i) {
                    return r;
                }
            }
            return null;
        }
    }

    public String Options() {
        WelcomeMessage();
        return optionsString;
    }
    
    @Override
    protected void initializeHours() {
        hoursOfOperationMap.put("MONDAY", new String[] { "11:00", "23:00" });
        hoursOfOperationMap.put("TUESDAY", new String[] { "11:00", "23:00" });
        hoursOfOperationMap.put("WEDNESDAY", new String[] { "11:00", "23:00" });
        hoursOfOperationMap.put("THURSDAY", new String[] { "11:00", "23:00" });
        hoursOfOperationMap.put("FRIDAY", new String[] { "11:00", "23:00" });
        hoursOfOperationMap.put("SATURDAY", new String[] { "11:00", "23:00" });
        hoursOfOperationMap.put("Sunday", new String[] { "11:00", "17:00" });
    }
}
