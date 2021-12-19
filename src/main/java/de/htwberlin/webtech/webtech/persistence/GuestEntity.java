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

    @Column(name = "wedding_Day")
    private Date wDay;

    @Column(name = "is_invited")
    private Boolean invited;

    public GuestEntity(Long id, String firstName, String lastName, Date wDay, Boolean invited) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.wDay = wDay;
        this.invited = invited;
    }

    public GuestEntity(String firstName, String lastName, Date wDay, Boolean invited) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.wDay = wDay;
        this.invited = invited;
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

    public Date getWDay() {
        return wDay;
    }

    public void setWDay(Date bDay) {
        this.wDay = wDay;
    }

    public Boolean getInvited() {
        return invited;
    }

    public void setInvited(Boolean invited) {
        this.invited = invited;
    }


}
