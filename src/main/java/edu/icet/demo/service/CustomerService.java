package edu.icet.demo.service;

import edu.icet.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> retrive();

    Customer addCustomer(Customer customer);

    Customer updateCustomer(String cusID, Customer customer);

    void deleteCustomer(String cusId);

    Customer getCustomerById(String cusId);
}
