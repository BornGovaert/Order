package be.map.customerobjects;

import be.map.Customer.Customer;
import be.map.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    //addCustomer
    //getAllCustomers
    //getSingleCustomer

    private CustomerService customerService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customer){
        return CustomerMapper.customerToDto(customerService.addCustomer(CustomerMapper.dtoToCustomer(customer)));
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomers(){
        ArrayList<CustomerDto> customerDto = new ArrayList<>();
        for (Customer customer : customerService.getCustomers()){
            customerDto.add(CustomerMapper.customerToDto(customer));
        }
        return customerDto;
    }

    @GetMapping(path = "/id/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerByUniqueId(@PathVariable String id){
        return CustomerMapper.customerToDto(customerService.getCustomer(id));
}

}
