package edu.icet.demo.controller;

import edu.icet.demo.model.Customer;
import edu.icet.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService service;
    @GetMapping()
    List<Customer> all(){
        return service.retrive();
    }

    @GetMapping("/{cusId}")
    Customer findById(@PathVariable String cusId){
        return service.getCustomerById(cusId);
    }

    @PostMapping()
    Customer persist(@RequestBody Customer customer){
        return service.addCustomer(customer);
    }

    @PutMapping("/{cusId}")
    Customer update(@RequestBody Customer customer,@PathVariable String cusId){
        return service.updateCustomer(cusId, customer);
    }

    @DeleteMapping("/{cusId}")
    void delete(@PathVariable String cusId){
        service.deleteCustomer(cusId);
    }

}
