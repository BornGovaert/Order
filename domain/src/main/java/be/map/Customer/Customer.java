package be.map.Customer;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {

    private String firstName, lastName, eMail, adress, phoneNumber;
    private String uniqueID;

    public Customer (CustomerBuilder customerBuilder) {
        this.firstName = CustomerBuilder.buildUser().getFirstName();
        this.lastName = CustomerBuilder.buildUser().getLastName();
        this.eMail = CustomerBuilder.buildUser().geteMail();
        this.adress = CustomerBuilder.buildUser().getAdress();
        this.phoneNumber = CustomerBuilder.buildUser().getPhoneNumber();
        this.uniqueID = CustomerBuilder.buildUser().getUniqueId();
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", adress='" + adress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", uniqueID='" + uniqueID + '\'' +
                '}';
    }
}


