package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.relationship;

import javax.validation.constraints.*;
import java.util.Date;

public class GuestManipulationRequest {

    @Size(min = 3, message = "Please provide a first name with 3 characters or more.")
    private String firstName;

    @NotBlank(message = "The last name must not be empty.")
    private String lastName;

    @Email(message = "Email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Please provide a selection")
    private boolean invited;

    @Pattern(
            regexp = "brideFamily|groomFamily|brideFriends|groomFriends|notRelated",
            message = "Please provide a selection"
    )
    private String  relationship;


    private boolean plusOne;
    private String note;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

    public boolean isPlusOne() {
        return plusOne;
    }

    public void setPlusOne(boolean plusOne) {
        this.plusOne = plusOne;
    }
    public String geNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRelationship(String  relationship) {
        this.relationship = relationship;
    }

    public String  getRelationship() {
        return relationship;
    }
}
