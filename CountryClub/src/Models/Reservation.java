package Models;

import java.util.Date;
import java.io.Serializable;

public class Reservation implements Serializable{
    private Date dateOfReservation;
    private Member member;
    private int NumberOfGuests;
}
