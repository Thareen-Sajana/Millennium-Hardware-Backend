package edu.icet.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Rent {
    private String rentId;
    private String rentalDate;
    private String returnDate;
    private String dueDate;
    private Double totalCost;
}
