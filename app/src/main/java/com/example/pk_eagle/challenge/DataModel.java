package com.example.pk_eagle.challenge;

/**
 * Created by PK_Eagle on 9/28/2016.
 */

public class DataModel {


    private String FirstName;
    private String LastName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 0)
            LastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
        else
            LastName=lastName;
    }
}
