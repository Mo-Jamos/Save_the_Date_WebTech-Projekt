package de.htwberlin.webtech.webtech.web.api;

import java.util.Date;

public class Guest {

        private long id;
        private String firstName;
        private String lastName;
        private Date wDay;
        private boolean invited;

        public Guest(long id, String firstName, String lastName, Date wDay, boolean invited) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.wDay = wDay;
            this.invited = invited;
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
