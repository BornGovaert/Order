package be.map.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerRepository {


    HashMap<String, Customer> customers;

//   //### Story 7: View all customers
    //    //As an admin user I want to view all customers.
    //    //- List all customers known by the system
    //    //- Prioritization: Must-Have
    //    //

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    //    //### Story 8: View single customers
    //    //As an admin user I want to view the details of a single customers.
    //    //- Based on the customer identifier
    //    //- Prioritization: Nice-To-Have
    //    //

    public Customer getCustomer(String uniqueId) {
        if (uniqueId != null && ifCustomerExists(uniqueId)) {
            return customers.get(uniqueId);
        } else {
            throw new IllegalArgumentException("test");
        }
    }

    public boolean ifCustomerExists(String uniqueId) {
        for (Customer customer : customers.values()) {
            if (customer.getUniqueID().equals(uniqueId)) {
                return true;
            }
        }
        return false;
    }

    // Add Customer

    public Customer addCustomer(Customer customer) {
        customers.put(customer.getUniqueID(), customer);
        return customer;
    }


}
