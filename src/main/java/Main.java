import models.Car;
import models.DriverLicense;
import models.Owner;
import models.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .addAnnotatedClass(DriverLicense.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

          Session session = sessionFactory.openSession();

        session.beginTransaction();

        Owner owner = new Owner("petya", Arrays.asList(new Car("daewoo", Type.B, 75, 2000, 2007), new Car ("Subaru", Type.B, 300, 7000, 2004)), new DriverLicense("f3323423"));
        session.save(owner);


        session.close();
        sessionFactory.close();
    }
}
