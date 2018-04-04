package be.map;

import be.map.Customer.Customer;
import be.map.Customer.CustomerBuilder;
import be.map.customerobjects.CustomerDto;
import be.map.customerobjects.CustomerMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerMapperTEST {

    private CustomerMapper customerMapper;

  //  private CustomerDto customerdto;

    @Before
    public void instantiateMapper(){customerMapper = new CustomerMapper();}

    @Test
    public void toDto_givenCustomer_thenMapAllfieldsToCustomerDto(){
        Customer customer = CustomerBuilder.buildUser().buildCustomer()
                .withLastname("Bob")
                .witheMail("bob@hotmail.com")
                .withAdress("bob street")
                .withPhoneNr("0028644")
                .build();

                CustomerDto customerDto = customerMapper.customerToDto(customer);

        assertThat(customerDto).isEqualToComparingFieldByField(customer);
    }




}

//.withFirstName(customerToMap.getFirstName())
//                .withLastName(customerToMap.getLastName())
//                .witheMail(customerToMap.geteMail())
//                .withAdress(customerToMap.getAdress())
//                .withPhoneNr(customerToMap.getPhoneNumber());

// @Test
//    public void mapToDto_givenUnknownStockWithoutPrice_thenMapIdAndNameToStockDto()  {
//        Stock stock = new Stock("ABC", "AyBeCe");
//
//        StockMapper stockMapper = new StockMapper();
//        StockDto stockDto = stockMapper.mapToDto(stock);
//
//        assertThat(stockDto.getId()).isEqualTo("ABC");
//        assertThat(stockDto.getName()).isEqualTo("AyBeCe");
//        assertThat(stockDto.getPrice()).isEqualTo(new BigDecimal(0));
//        assertThat(stockDto.getCurrency()).isEqualTo("Unknown");
//    }