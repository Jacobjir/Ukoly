package com.engeto.ukol2Hotel;

import java.time.LocalDate;

public class Booking {

    private int roomNum;
    private String host;
    private LocalDate reservationStart;
    private LocalDate reservationEnd;


    public Booking(int roomNum, String host, LocalDate reservationStart, LocalDate reservationEnd) {
        this.roomNum = roomNum;
        this.host = host;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
    }


    public Booking(int roomNum, String host) {
        this(roomNum, host,LocalDate.now(),LocalDate.now().plusDays(6));
    }


    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public LocalDate getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDate reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDate getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDate reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public String getDescription() {
        return "Room number " + roomNum + " Reserved by: " + host + ". Date of arrival: " + reservationStart + ". Date of departure: " + reservationEnd;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}