package edu.icet.demo.repository;

import edu.icet.demo.entity.RentEntity;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<RentEntity, String> {
}
