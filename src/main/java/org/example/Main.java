package org.example;

import org.models.Company;
import org.models.Passenger;
import org.models.Trip;
import org.services.DataBaseService;

import javax.persistence.Column;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //DataBaseService.getAllTrips().forEach(System.out::println);
        System.out.println(DataBaseService.getPsgById(2));



    }
}
