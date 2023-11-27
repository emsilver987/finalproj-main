package Interfaces;

import java.util.Date;

import Models.Member;

public interface IReservation {
    public void MakeReservation(Date dateOfReservation, Member member, int partyNum);
}
