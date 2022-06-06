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
        Set<Passenger> set = DataBaseService.getAllPsg();
        set.forEach(System.out::println);
        //System.out.println(set);







        /*
        Set<Passenger> set = DataBaseService.getAllPsg();
        System.out.println(set);
        long l = DataBaseService.getAllPsg().stream().peek(passenger -> {System.out.println(passenger.toString());}).count();

        System.out.println(l);
        Iterator<Passenger> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        for (Passenger p : set) {
            System.out.println(p.toString());
        }

         */


    }
}
