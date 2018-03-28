package be.map;

import be.map.Customer.Customer;
import be.map.Customer.CustomerRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.addCustomer(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public Customer getCustomer(String id) {
        return customerRepository.getCustomer(id);
    }

}
