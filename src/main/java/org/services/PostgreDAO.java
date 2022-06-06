package org.services;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.models.Passenger;
import org.models.Trip;
import org.postgresql.core.Query;
import utils.HibernateSessionFactoryUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Реализация логики работы с БД Postgre
 */
public class PostgreDAO implements IDAO {
    public Set<Passenger> getAllPsg() {
        Set<Passenger> allPsg = new HashSet<>();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        NativeQuery<Passenger> query = session.createNativeQuery("SELECT * FROM passenger", Passenger.class);
        allPsg = query.getResultStream().collect(Collectors.toSet());
        session.close();
        return allPsg;
    }

    public Set<Trip> getAllTrips() {
        Set<Trip> allTrips = new HashSet<>();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Trip> list = session.createNativeQuery("SELECT * FROM trip", Trip.class).list();



        session.close();
        return allTrips;
    }
}
