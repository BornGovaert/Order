package be.map.Customer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private CustomerRepository customerRepository = new CustomerRepository();

    @Test
    void getBookInformationISBN_happyPath(){
        Customer expectedCustomer = new Customer("666", "Kaas", );

        List<Customer> actualBooks = customerRepository.getCustomer("666");

        Assertions.assertThat(actualBooks).containsExactly(expectedCustomer);
    }

}