package de.htwberlin.webtech.webtech.persistence;


import javax.persistence.*;
import java.util.Date;

@Entity(name = "guests")
public class GuestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "is_invited")
    private Boolean invited;

    @Column(name = "plus_one")
    private Boolean plusOne;

    @Column(name = "note")
    private String note;

    @Column(name = "relationship")
    @Enumerated(value = EnumType.STRING)
    private relationship relationship;

    public GuestEntity(String firstName, String lastName, String email, Boolean invited, Boolean plusOne, String note, relationship relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.invited = invited;
        this.plusOne = plusOne;
        this.note = note;
        this.relationship = relationship;
    }

    protected GuestEntity() { }

    public Long getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getInvited() {
        return invited;
    }

    public void setInvited(Boolean invited) {
        this.invited = invited;
    }

    public boolean getPlusOne() {
        return plusOne;
    }

    public void setPlusOne(boolean plusOne) {
        this.plusOne = plusOne;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setRelationship(relationship relationship) {
        this.relationship = relationship;
    }

    public relationship getRelationship() {
        return relationship;
    }

}
