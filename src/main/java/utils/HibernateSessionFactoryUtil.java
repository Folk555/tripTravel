package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.models.Company;
import org.models.Passenger;
import org.models.Trip;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {}

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                //Подключаем класс к ORM
                //configuration.addAnnotatedClass(Trip.class);
                configuration.addAnnotatedClass(Company.class);
                configuration.addAnnotatedClass(Passenger.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение подключения к БД!\n" + e);
            }
        }
        return sessionFactory;
    }
}