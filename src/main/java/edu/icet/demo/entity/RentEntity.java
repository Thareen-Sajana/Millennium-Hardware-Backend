package edu.icet.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "rentDetails")
public class RentEntity {

    @Id
    private String rentId;

    private String rentalDate;
    private String returnDate;
    private String dueDate;
    private Double totalCost;
}
