package de.htwberlin.webtech.webtech.web.api;

import java.util.Date;

public class PersonManipulationRequest {

    private String firstName;
    private String lastName;
    private String bDay;
    private boolean invited;

    public PersonManipulationRequest(long id, String firstName, String lastName, String bDay, boolean invited) {
        this.firstName = firstName;
        this.bDay = bDay;
        this.lastName = lastName;
        this.invited = invited;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBDay() {
        return bDay;
    }

    public void setBDay(String bDay) {
        this.bDay = bDay;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

}