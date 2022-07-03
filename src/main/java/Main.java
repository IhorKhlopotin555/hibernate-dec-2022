import models.Card;
import models.Passport;
import models.SunGlass;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Card.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .addAnnotatedClass(SunGlass.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

          Session session = sessionFactory.openSession();

        session.beginTransaction();
List<SunGlass> sunGlasses = Arrays.asList(new SunGlass("okoban"), new SunGlass("raybane"));
       User user1 = new User("vasya", sunGlasses);
       User user2 = new User("Sonya", sunGlasses);
        session.save(user1);
        session.save(user2);

        session.close();
        sessionFactory.close();
    }
}
