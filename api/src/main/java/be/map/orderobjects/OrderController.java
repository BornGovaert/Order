package be.map.orderobjects;

import be.map.Customer.Customer;
import be.map.CustomerService;
import be.map.Order.Report;
import be.map.OrderService;
import be.map.customerobjects.CustomerDto;
import be.map.customerobjects.CustomerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private OrderService orderService;
    private CustomerService customerService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto createOrder(@RequestBody OrderDto order) {
        return OrderMapper.orderToDto(orderService.createOrder(OrderMapper.dtoToOrder(order)));
    }

    @GetMapping(path = "/report/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ReportDto getReport(@PathVariable String uniqueId) {
        return ReportMapper.reportToDto(orderService.getReport(uniqueId));
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto reorder(@RequestBody String customerUniqueId, String orderUniqueId) {
        return OrderMapper.orderToDto(orderService.reorder(customerUniqueId, orderUniqueId));
    }

}
