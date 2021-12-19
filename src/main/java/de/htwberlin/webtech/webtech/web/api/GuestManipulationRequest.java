package de.htwberlin.webtech.webtech.web.api;

import java.util.Date;

public class GuestManipulationRequest {

    private String firstName;
    private String lastName;
    private Date wDay;
    private boolean invited;

    public GuestManipulationRequest(long id, String firstName, String lastName, Date wDay, boolean invited) {
        this.firstName = firstName;
        this.wDay = wDay;
        this.lastName = lastName;
        this.invited = invited;
    }
    public GuestManipulationRequest () {}

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

    public Date getWDay() {
        return wDay;
    }

    public void setWDay(Date wDay) {
        this.wDay = wDay;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

}
