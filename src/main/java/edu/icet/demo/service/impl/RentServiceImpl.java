package edu.icet.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.demo.entity.RentEntity;
import edu.icet.demo.exception.CustomerNotFoundException;
import edu.icet.demo.exception.RentDetailsNotFoundException;
import edu.icet.demo.model.Rent;
import edu.icet.demo.repository.RentRepository;
import edu.icet.demo.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Rent getRentDetailsById(String rentId) {

        Optional<RentEntity> rentEntity = rentRepository.findById(rentId);
        if(rentEntity.isEmpty()){
            throw new RentDetailsNotFoundException("Rent details not available");
        }
        return objectMapper.convertValue(rentEntity, Rent.class);
    }

    @Override
    public Rent addRetalDetails(Rent rent) {
        RentEntity rentEntity = rentRepository.save(objectMapper.convertValue(rent, RentEntity.class));
        return objectMapper.convertValue(rentEntity, Rent.class);
    }

    @Override
    public Rent updateRentalDetails(String rentId, Rent rent) {

        Optional<RentEntity> rentEntity = rentRepository.findById(rentId);
        if(rentEntity.isEmpty()){
            throw new RentDetailsNotFoundException("Rent detail not found");
        }

        rentEntity.get().setRentalDate(rent.getRentalDate());
        rentEntity.get().setDueDate(rent.getDueDate());
        rentEntity.get().setReturnDate(rent.getReturnDate());
        rentEntity.get().setTotalCost(rent.getTotalCost());

        RentEntity rentUpdate = rentRepository.save(rentEntity.get());
        return objectMapper.convertValue(rentUpdate, Rent.class);
    }

    @Override
    public void deleteRentalDetail(String rentId) {
        rentRepository.deleteById(rentId);
    }
}
