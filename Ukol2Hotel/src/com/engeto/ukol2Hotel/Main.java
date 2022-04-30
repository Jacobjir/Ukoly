package com.engeto.ukol2Hotel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Guest adelaMalikova = new Guest("Adéla", "Malíková", LocalDate.of(1993,3,13));
        Guest janDvoracek = new Guest("Jan","Dvořáček",LocalDate.of(1995,5,5));


        List<Guest> guestList = new ArrayList<>();

        guestList.add(adelaMalikova);
        guestList.add(janDvoracek);


        System.out.println("Available information about guests: " + guestList);


        Room room1 = new Room(1,1,true,true, BigDecimal.valueOf(1000));
        Room room2 = new Room(2,1,true,true,BigDecimal.valueOf(1000));
        Room room3 = new Room(3,3,false,true,BigDecimal.valueOf(2400));


        List<Room> roomList = new ArrayList<>();

        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        System.out.println("All rooms in the hotel:" + roomList);


        Booking booking1 = new Booking(1, adelaMalikova.getName(),
                LocalDate.of(2021,7,19),LocalDate.of(2021,7,26));
        Booking booking2 = new Booking(3, adelaMalikova.getName() + " and " + janDvoracek.getName(),
                LocalDate.of(2021,9,3),LocalDate.of(2021,9,14));


        // Rezervace s automatickým datem ode dneška na 6 dní
        Booking booking3 = new Booking(2,adelaMalikova.getName());

        List<Booking> bookingList = new ArrayList<>();

        bookingList.add(booking1);
        bookingList.add(booking2);
        bookingList.add(booking3);

        System.out.println("List of all bookings:");

        int i = 1;
        for (Booking booking : bookingList) {
            System.out.println(""+i+": "+booking);
            i++;

        }

    }
}