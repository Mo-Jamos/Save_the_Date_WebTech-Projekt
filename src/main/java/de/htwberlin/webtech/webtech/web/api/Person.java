package de.htwberlin.webtech.webtech.web.api;

import java.util.Date;

public class Person {

        private long id;
        private String firstName;
        private String lastName;
        private String bDay;
        private boolean invited;

        public Person(long id, String firstName, String lastName, String bDay, boolean invited) {
            this.id = id;
            this.firstName = firstName;
            this.bDay = bDay;
            this.lastName = lastName;
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
