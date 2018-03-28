package be.map.customerobjects;

 import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

 @JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDto {

public String firstName, lastName, eMail, adress;
        public String phoneNumber;

    public CustomerDto withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerDto withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public CustomerDto witheMail(String eMail) {
        this.eMail = eMail;
        return this;
    }

    public CustomerDto withAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public CustomerDto withPhoneNr(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}


