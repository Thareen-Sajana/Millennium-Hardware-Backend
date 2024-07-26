package edu.icet.demo.repository;

import edu.icet.demo.entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity,String> {


}
