import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(IdCode.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Car.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

          Session session = sessionFactory.openSession();

        session.beginTransaction();

        List<Car> cars_vasya = new ArrayList<>();
        cars_vasya.add(new Car("Lanos"));
        cars_vasya.add(new Car("Subaru"));

        List<Car> cars_anya = new ArrayList<>();
        cars_anya.add(new Car("Toyota"));
        cars_anya.add(new Car("Tesla"));

        List<Book> books = new ArrayList<>();
        books.add(new Book("Flowers for Eldgernon"));
        books.add(new Book("Fly over Cuckus nest"));

        session.save(new Person("Vasya", "2000.03.09", 0665467456, "vasyaasd@gmail.com", new IdCode(004), cars_vasya, books));
        session.save(new Person("Anya", "1998.01.15", 447737890, "anyaqwe@gmail.com", new IdCode(005), cars_anya, books));



        session.close();
        sessionFactory.close();
    }
}
