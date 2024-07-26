package edu.icet.demo.service;

import edu.icet.demo.model.Rent;

public interface RentService {
    Rent getRentDetailsById(String rentId);

    Rent addRetalDetails(Rent rent);

    Rent updateRentalDetails(String rentId, Rent rent);

    void deleteRentalDetail(String rentId);
}
