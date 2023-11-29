import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Models.Gym;
import Models.Member;


public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Member> list = new ArrayList<>();
    private static CountryClub theCountryClub;
    private final static String howManyInParty = "How many will be in your party?";
    private final static String reservationDate = "Date of reservation? Please enter month, day, and time\nFormat: Novemeber 9th at 915pm = 11092115";
    private final static String faiclityChoicePrint ="What Facility Would you like to visit today?\nGym = 1\nPool = 2\nRestaurant = 3\nMake Reservation At Resturant = 4\nOrder Takeout = 5";
    private final static String welcomeMessage ="Welcome to Silverthorne Country Club\nIt's great to see you\nPlease enter your Member Number: ";
    private final static String adminLogin ="Welcome Mr.Rodriguez Please enter your Admin Password to continue";
    private final static String adminMessgae ="What facility would you like to view the checked-in members?\nGym = 1\nPool = 2\nRestaurant = 3";
    private static final long serialVersionUID = 0;

    public static void main(String[] args) throws Exception {
        if (theCountryClub == null) {
        theCountryClub = CountryClub.Deserialize();
            if (theCountryClub == null) {
                theCountryClub = new CountryClub();
                initializeMembers();
            }
        }
        Member member = obtainMemberDetails();
        theCountryClub.Serialize();
        if (member != null) {
            if (member.getNumber() == 1) {
                adminLoginFunc();
                int adminPassword = scanner.nextInt();
                if (adminPassword == 12345) {
                    adminMessgaeFunc();
                    int adminChoice = scanner.nextInt();
                    Response adminUserResponse = Response.fromInt(adminChoice);
                    if (adminUserResponse != null) {
                        switch (adminUserResponse) {
                            case Gym:
                                System.err.println(theCountryClub.gym.WelcomeMessage());
                                System.err.println(theCountryClub.gym.WorkHours());
                                System.out.print("The current checked in members include:\n" + theCountryClub.gym.ListCheckedInMembers());
                                break;
                            case Pool:
                                System.err.println(theCountryClub.pool.WelcomeMessage());
                                System.err.println(theCountryClub.pool.WorkHours());
                                System.out.print("The current checked in members include:\n" + theCountryClub.pool.ListCheckedInMembers());
                                break;
                            case RestaurantCheckin:
                                System.err.println(theCountryClub.restaurant.WelcomeMessage());
                                System.err.println(theCountryClub.restaurant.WorkHours());
                                System.out.print("The current checked in members include:\n" + theCountryClub.restaurant.ListCheckedInMembers());
                                break;
                            default:
                                break;
                        }
                    } else {
                        System.out.println("Invalid response, Please enter one of the Specfied Numbers.");
                    }
                    Gym thegym = new Gym(10);
                    thegym.ListCheckedInMembers();
                    theCountryClub.Serialize();
                } else {
                    System.out.println("Incorrect admin password. Please log-in again");
                }
            } else {
                FacilityChoice(member);
            }
        } else {
            System.out.println("Member not found. Please enter a number 1-100");
            main(null);
        }
    }

    private static void initializeMembers() {
            list.addAll(Arrays.asList(
            new Member(1, "Charles Rodriguez"),
            new Member(2, "Thomas Davis"),
            new Member(3, "John Hernandez"),
            new Member(4, "Barbara Anderson"),
            new Member(5, "Barbara Smith"),
            new Member(6, "Joseph Smith"),
            new Member(7, "William Johnson"),
            new Member(8, "John Martin"),
            new Member(9, "Linda Moore"),
            new Member(10, "Barbara Taylor"),
            new Member(11, "Barbara Lopez"),
            new Member(12, "Jennifer Davis"),
            new Member(13, "Robert Taylor"),
            new Member(14, "Jennifer Taylor"),
            new Member(15, "Linda Moore"),
            new Member(16, "Robert Anderson"),
            new Member(17, "Joseph Martinez"),
            new Member(18, "Karen Thomas"),
            new Member(19, "John Martinez"),
            new Member(20, "Jennifer Smith"),
            new Member(21, "Linda Jones"),
            new Member(22, "Jessica Martin"),
            new Member(23, "Mary Moore"),
            new Member(24, "Susan Martin"),
            new Member(25, "Joseph Williams"),
            new Member(26, "Jennifer Jones"),
            new Member(27, "Robert Brown"),
            new Member(28, "Jessica Brown"),
            new Member(29, "Robert Brown"),
            new Member(30, "Jessica Smith"),
            new Member(31, "Susan Wilson"),
            new Member(32, "Linda Gonzalez"),
            new Member(33, "Barbara Rodriguez"),
            new Member(34, "Susan Johnson"),
            new Member(35, "John Martinez"),
            new Member(36, "James Moore"),
            new Member(37, "David Johnson"),
            new Member(38, "Michael Jackson"),
            new Member(39, "John Wilson"),
            new Member(40, "Joseph Smith"),
            new Member(41, "Susan Miller"),
            new Member(42, "Robert Martin"),
            new Member(43, "Sarah Williams"),
            new Member(44, "Susan Smith"),
            new Member(45, "Linda Moore"),
            new Member(46, "Mary Anderson"),
            new Member(47, "James Rodriguez"),
            new Member(48, "Elizabeth Martin"),
            new Member(49, "Charles Brown"),
            new Member(50, "William Brown"),
            new Member(51, "Joseph Rodriguez"),
            new Member(52, "Richard Davis"),
            new Member(53, "James Martinez"),
            new Member(54, "Jessica Wilson"),
            new Member(55, "John Anderson"),
            new Member(56, "Mary Anderson"),
            new Member(57, "Richard Taylor"),
            new Member(58, "William Jackson"),
            new Member(59, "William Martinez"),
            new Member(60, "Susan Moore"),
            new Member(61, "Joseph Rodriguez"),
            new Member(62, "Richard Davis"),
            new Member(63, "James Martinez"),
            new Member(64, "Jessica Wilson"),
            new Member(65, "John Anderson"),
            new Member(66, "Mary Anderson"),
            new Member(67, "Richard Taylor"),
            new Member(68, "William Jackson"),
            new Member(69, "William Martinez"),
            new Member(70, "Susan Moore"),
            new Member(71, "Susan Thomas"),
            new Member(72, "Sarah Wilson"),
            new Member(73, "Elizabeth Thomas"),
            new Member(74, "James Garcia"),
            new Member(75, "Karen Martin"),
            new Member(76, "Michael Davis"),
            new Member(77, "Jessica Miller"),
            new Member(78, "James Wilson"),
            new Member(79, "Joseph Thomas"),
            new Member(80, "Karen Jackson"),
            new Member(81, "William Johnson"),
            new Member(82, "Jennifer Moore"),
            new Member(83, "Thomas Rodriguez"),
            new Member(84, "Mary Wilson"),
            new Member(85, "Mary Gonzalez"),
            new Member(86, "Sarah Hernandez"),
            new Member(87, "Mary Garcia"),
            new Member(88, "Jennifer Jones"),
            new Member(89, "Jennifer Thomas"),
            new Member(90, "Robert Garcia"),
            new Member(91, "Elizabeth Brown"),
            new Member(92, "Linda Wilson"),
            new Member(93, "James Martinez"),
            new Member(94, "Jennifer Smith"),
            new Member(95, "James Hernandez"),
            new Member(96, "Susan Brown"),
            new Member(97, "Charles Brown"),
            new Member(98, "Robert Hernandez"),
            new Member(99, "Richard Thomas"),
            new Member(100, "Linda Williams")
        ));
        theCountryClub.Members = list;
    }

    public static Member obtainMemberDetails() {
        welcomeMessage();
        int memberNumber = scanner.nextInt();
        return theCountryClub.Members.stream().filter(m -> m.getNumber() == memberNumber).findFirst().orElse(null);
    }

    public static void FacilityChoice(Member member) throws FileNotFoundException, IOException {
        facilityChoicePrintFunction();
        int facilityChoice = scanner.nextInt();
        Response userResponse = Response.fromInt(facilityChoice);
        if (userResponse != null) {
            System.out.println("Hello " + member.getName() + " (Member " + member.getNumber() + "), Welcome to the " + userResponse);
            switch (userResponse) {
                case Gym:
                    System.out.print(theCountryClub.gym.Options());
                    int gymChoice = scanner.nextInt();
                    if (gymChoice == 1){
                        System.out.print(theCountryClub.gym.Checkin(member));
                        theCountryClub.Serialize();
                    }
                    if (gymChoice == 2){
                        System.out.print(theCountryClub.gym.Checkout(member));
                        theCountryClub.Serialize();
                    }
                    if (gymChoice == 3){
                        System.out.print(theCountryClub.gym.WorkHours());
                    }
                    break;
                case Pool:
                    System.out.print(theCountryClub.pool.Options());
                    int poolChoice = scanner.nextInt();
                    if (poolChoice == 1){
                        System.out.print(theCountryClub.pool.Checkin(member));
                        theCountryClub.Serialize();
                    }
                    if (poolChoice == 2){
                        System.out.print(theCountryClub.pool.Checkout(member));
                        theCountryClub.Serialize();
                    }
                    if (poolChoice == 3){
                        System.out.print(theCountryClub.pool.WorkHours());
                    }
                    break;
                case RestaurantCheckin:
                    System.out.print(theCountryClub.pool.Options());
                    int restaurantChoice = scanner.nextInt();
                    if (restaurantChoice == 1){
                        System.out.print(theCountryClub.pool.Checkin(member));
                        theCountryClub.Serialize();
                    }
                    if (restaurantChoice == 2){
                        System.out.print(theCountryClub.restaurant.Checkout(member));
                        theCountryClub.Serialize();
                    }
                    if (restaurantChoice == 3){
                        System.out.print(theCountryClub.restaurant.WorkHours());
                    }
                    break;
                case RestaurantReservation:
                    howMany();
                    int howManyInPartyint = scanner.nextInt();
                    reservationDate();
                    int reservationDate = scanner.nextInt();
                    System.out.print(theCountryClub.restaurant.MakeReservation(reservationDate, member, howManyInPartyint));
                    theCountryClub.Serialize();
                    break;
                case OrderTakeout:
                    System.out.println(theCountryClub.restaurant.menuOptions());
                    int foodChoice = scanner.nextInt();
                    System.out.println(theCountryClub.restaurant.quantity());
                    int quantity = scanner.nextInt();
                    System.out.println(theCountryClub.restaurant.order(foodChoice, quantity));
                    break;
            }
        }
        else {
            System.out.println("Invalid response, Please enter one of the Specfied Numbers.");
            FacilityChoice(member);
        }
    }
    

    public enum Response {
        Gym(1),
        Pool(2),
        RestaurantCheckin(3),
        RestaurantReservation(4),
        OrderTakeout(5);

        private final int value;

        Response(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
        public static Response fromInt(int i) {
            for (Response r : Response.values()) {
                if (r.getValue() == i) {
                    return r;
                }
            }
            return null;
        }
    }
    public static void howMany() {
        System.out.println(howManyInParty);
    }
    public static void reservationDate() {
        System.out.println(reservationDate);
    }
    public static void facilityChoicePrintFunction() {
        System.out.println(faiclityChoicePrint);
    }
    public static void welcomeMessage() {
        System.out.println(welcomeMessage);
    }
    public static void adminLoginFunc() {
        System.out.println(adminLogin);
    }
    public static void adminMessgaeFunc() {
        System.out.println(adminMessgae);
    }
}

