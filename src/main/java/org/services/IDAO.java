package org.services;

import org.models.Passenger;
import org.models.Trip;

import java.util.List;
import java.util.Set;

/**
 * Интерфейс Data Access Object
 * От него наследуются классы по обработке БД (в зависимости от конкретной БД).
 * Если мы меняем БД до достаточно сменить соответствующий ей класс. При этом логику проги
 * менять не придется, так как она строится на уровне этого интерфейса.
 */

public interface IDAO {
    Set<Passenger> getAllPsg();
    Set<Trip> getAllTrips();

}
