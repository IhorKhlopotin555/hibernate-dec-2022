import models.Card;
import models.Passport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(Card.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

          Session session = sessionFactory.openSession();

        session.beginTransaction();


        session.save(new User("vasya", new Passport("asd2323232"), Arrays.asList(new Card(42343432), new Card(42346432L))));
        session.save(new User("petya", new Passport("a2fdsad3232"), Arrays.asList(new Card(42353432), new Card(42348432L))));
        session.save(new User("anya", new Passport("aqwdq323232"), Arrays.asList(new Card(42363432), new Card(423494432L))));
        session.save(new User("sanya", new Passport("aqwe23232"), Arrays.asList(new Card(4234832), new Card(423430432L))));

        session.getTransaction().commit();
//
//        List<Passport> passports = session.createQuery("select p from Passport p", Passport.class).getResultList();
//        passports.forEach(passport -> System.out.println(passport.getUser()));

        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
        users.forEach(user -> System.out.println(user));

        session.close();
        sessionFactory.close();
    }
}
