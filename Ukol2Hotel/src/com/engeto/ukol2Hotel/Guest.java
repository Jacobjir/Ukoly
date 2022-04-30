package com.engeto.ukol2Hotel;

import java.time.LocalDate;

public class Guest {

    private String firstName;
    private String surname;
    private LocalDate dateOfBirth;


    public Guest(String firstName, String surname, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDescription() {
        return "Name: " + firstName + " " + surname + ". Born: " + dateOfBirth;
    }

    public String getName() {
        return getFirstName() + " " + getSurname();
    }

    @Override
    public String toString() {
        return getDescription();
    }
}