import models.Car;
import models.Owner;
import models.Type;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(Owner.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

          Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(new Owner("vasya", new Car( "lanos", Type.OFFROAD, 120, 4000, 2007)));

        session.getTransaction().commit();
        session.createQuery("select c from Owner c", Owner.class).getResultList().forEach(owner -> {
                    System.out.println(owner);
                    System.out.println(owner.getCar());
                });
        session.close();
        sessionFactory.close();
    }
}
