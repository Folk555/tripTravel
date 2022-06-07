package org.services;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.models.Company;
import org.models.Passenger;
import org.models.Trip;
import utils.HibernateSessionFactoryUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Реализация логики работы с БД Postgre
 */
public class PostgreDAO implements IDAO {
    public Set<Passenger> getAllPsg() {
        Set<Passenger> allPsg;
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        NativeQuery<Passenger> query = session.createNativeQuery("SELECT * FROM passenger", Passenger.class);
        //Ответ получаем как TreeSet так как упорядоченные данные красивее
        allPsg = query.getResultStream().collect(Collectors.toCollection(
                () -> new TreeSet<Passenger>(Comparator.comparingInt(Passenger::getIdPsg))
        ));
        session.close();
        return allPsg;
    }

    public Passenger getPsgById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Passenger> cr = cb.createQuery(Passenger.class);
        Root<Passenger> root = cr.from(Passenger.class);
        cr.select(root).where(cb.equal(root.get("idPsg"), id));

        Query<Passenger> query = session.createQuery(cr);
        Passenger results = query.getSingleResult();
        return results;
    }

    public List<Trip> getAllTrips() {
        List<Trip> allTrips;
        //fetch = FetchType.EAGER не работает. Поэтому прихитися выгружать сначала company потом trip иначе сессия закрывается
        // до тога как выгружается company.
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.createNativeQuery("SELECT * FROM company", Company.class).getResultStream().collect(Collectors.toSet());
        NativeQuery query =
                session.createNativeQuery("SELECT * FROM trip", Trip.class);
        allTrips = query.list();

        session.close();
        return allTrips;
    }

    public void getAllPass() {



    }

}
