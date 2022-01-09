package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.relationship;

import java.util.Date;

public class Guest {

        private long id;
        private String firstName;
        private String lastName;
        private String email;
        private boolean invited;
        private boolean plusOne;
        private String note;
        private String relationship;

    public Guest(long id, String firstName, String lastName, String email, boolean invited, boolean plusOne, String note, String relationShip) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.invited = invited;
        this.plusOne = plusOne;
        this.note = note;
        this.relationship = relationShip;
    }



    public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
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
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}
