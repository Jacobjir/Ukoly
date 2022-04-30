package com.engeto.ukol2Hotel;

import java.math.BigDecimal;

public class Room {

    private int roomNumber;
    private int numOfBeds;
    private boolean hasBalcony;
    private boolean seaView;
    private BigDecimal pricePerNight;


    public Room(int roomNumber, int numOfBeds, boolean hasBalcony, boolean seaView, BigDecimal pricePerNight) {
        this.roomNumber = roomNumber;
        this.numOfBeds = numOfBeds;
        this.hasBalcony = hasBalcony;
        this.seaView = seaView;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        this.numOfBeds = numOfBeds;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }

    public boolean isSeaView() {
        return seaView;
    }

    public void setSeaView(boolean seaView) {
        this.seaView = seaView;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getDescription(){
        return "Room " + roomNumber + " Number of beds: "
                + numOfBeds + ". Has balcony: " + hasBalcony + ". Has sea-view: " + seaView + ". Price per night: " + pricePerNight + " Kč";
    }

    @Override
    public String toString() {
        return getDescription();
    }
}