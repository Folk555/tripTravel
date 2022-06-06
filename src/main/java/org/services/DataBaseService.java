package org.services;

import org.models.Passenger;
import org.models.Trip;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * Реализация логики работы с абстрактной БД (+ обработка информации полученной из БД
 * или загружаемую в БД, по необходимости) согласно интерфейсу IDAO.
 * Реальная логика работы с конкретной БД реализована в объекте currentDAOImpl.
 * Для работы с конкретной БД необходимо задать переменной currentDAOImpl
 * объекто реализующий работу с конкретной БД.
 */
public class DataBaseService {
    private static IDAO currentDAOImpl = new PostgreDAO();

    public static Set<Passenger> getAllPsg() {
        return currentDAOImpl.getAllPsg();
    }

    public static Set<Trip> getAllTrips() {
        return currentDAOImpl.getAllTrips();
    }
}
