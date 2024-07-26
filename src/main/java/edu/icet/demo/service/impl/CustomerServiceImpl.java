package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.entity.CustomerEntity;
import edu.icet.demo.exception.CustomerNotFoundException;
import edu.icet.demo.model.Customer;
import edu.icet.demo.repository.CustomerRepository;
import edu.icet.demo.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ObjectMapper objectMapper;
    @Override
    public List<Customer> retrive() {

        Iterable<CustomerEntity> customerEntities = customerRepository.findAll();
        List<Customer> customerList = new ArrayList<>();

        for (CustomerEntity customer : customerEntities){
            customerList.add(objectMapper.convertValue(customer, Customer.class));
        }
        return customerList;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        CustomerEntity customerEntity = customerRepository.save(objectMapper.convertValue(customer, CustomerEntity.class));
        return objectMapper.convertValue(customerEntity, Customer.class);
    }

    @Override
    public Customer updateCustomer(String cusID, Customer customer) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(cusID);

        if(customerEntity.isEmpty()){
            throw new CustomerNotFoundException("Invalid Customer");
        }

        customerEntity.get().setName(customer.getName());
        customerEntity.get().setCity(customer.getCity());
        customerEntity.get().setContact(customer.getContact());

        CustomerEntity customerUpdate = customerRepository.save(customerEntity.get());

        return objectMapper.convertValue(customerUpdate, Customer.class);
    }

    @Override
    public void deleteCustomer(String cusId) {
        customerRepository.deleteById(cusId);
    }

    @Override
    public Customer getCustomerById(String cusId) {

        Optional<CustomerEntity> customerEntity = customerRepository.findById(cusId);

        if(customerEntity.isEmpty()){
            throw new CustomerNotFoundException("Customer not Exist");
        }
        return objectMapper.convertValue(customerEntity, Customer.class);
    }
}
