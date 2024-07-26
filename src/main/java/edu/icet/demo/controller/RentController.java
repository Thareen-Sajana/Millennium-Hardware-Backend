package edu.icet.demo.controller;

import edu.icet.demo.model.Rent;
import edu.icet.demo.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("rent")
public class RentController {

    private final RentService service;

    @GetMapping("/{rentId}")
    Rent findById(@PathVariable String rentId){
        return service.getRentDetailsById(rentId);
    }

    @PostMapping()
    Rent persist(@RequestBody Rent rent){
        return service.addRetalDetails(rent);
    }

    @PutMapping("/{rentId}")
    Rent update(@RequestBody Rent rent, @PathVariable String rentId){
        return service.updateRentalDetails(rentId, rent);
    }

    @DeleteMapping("/{rentId}")
    void delete(@PathVariable String rentId){
        service.deleteRentalDetail(rentId);
    }
}