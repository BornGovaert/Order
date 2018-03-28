package be.map.customerobjects;

import be.map.Customer.Customer;

public class CustomerMapper {

    public static CustomerDto customerToDto (Customer customerToMap){
        return new CustomerDto()
                .withFirstName(customerToMap.getFirstName())
                .withLastName(customerToMap.getLastName())
                .witheMail(customerToMap.geteMail())
                .withAdress(customerToMap.getAdress())
                .withPhoneNr(customerToMap.getPhoneNumber());
    }

    public static Customer dtoToCustomer(CustomerDto customer){
        return new Customer(customer.firstName, customer.lastName);
    }
}
