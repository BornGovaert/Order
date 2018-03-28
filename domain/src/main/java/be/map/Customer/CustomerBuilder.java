package be.map.Customer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerBuilder {
    private String firstName, lastName, eMail, adress, phoneNumber, uniqueId;


    public static final Pattern VALID_EMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);



    //UserBuilder instead of CustomerBuilder
    public static CustomerBuilder buildUser(){
        return new CustomerBuilder();
    }

    public Customer buildCustomer(){
        if (allCustomerFieldsSet()) {
            return new Customer(this);
        } else {
            throw new IllegalArgumentException("Please provide all the necessary arguments");
        }
    }

    private boolean allCustomerFieldsSet() {
        return firstName != null
                && lastName != null && eMail != null
                && adress != null && phoneNumber != null && uniqueId != null;
    }

    public CustomerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }


    public CustomerBuilder withEMail(String eMail) {
        validateEmailAddress(eMail);
        return this;
    }

    public CustomerBuilder withAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public CustomerBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public CustomerBuilder withUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        return this;
    }


    private void validateEmailAddress(String emailAddress) {
        if (isValidEmailAddress(emailAddress)) {
            this.eMail = emailAddress;
        } else {
            throw new IllegalArgumentException("Please provide a valid e-mail address.\nCorrect Format: \"xx@xx.xx\"");
        }
    }

    private static boolean isValidEmailAddress(String email) {
        Matcher matcher = VALID_EMAIL.matcher(email);
        return matcher.find();
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

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public static Pattern getValidEmail() {
        return VALID_EMAIL;
    }
}
