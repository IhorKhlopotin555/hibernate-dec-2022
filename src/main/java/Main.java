import models.Passport;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Passport.class)
                .getMetadataBuilder()
                .build();

        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder()
                .build();

          Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(new User("vasya", new Passport("fwfewfewf")));
        session.save(new User("petya", new Passport("ffwefwef")));
        session.save(new User("kolya", new Passport("fwfewfw")));
//
//
//        session.getTransaction().commit();
        //List<User> users = session.createNativeQuery("select * from user_table", User.class).getResultList();
//        List<User> users = session
//                .createQuery("select u from User u where u.id>:id and u.name=:name", User.class)
//                .setParameter("id", 2)
//                .setParameter("name","petya")
//                .getResultList();
//        System.out.println(users);

//        User user = session.get(User.class, 1);
//        System.out.println(user);
//        user.setName("gijijog");
//
//        session.beginTransaction();
//        //session.update(user);
//        //session.delete(user);
//
//        session.getTransaction().commit();
//
//        List<Passport> resultList = session.createQuery("select u.passport from User u", Passport.class).getResultList();
//        System.out.println(resultList);
//
//        List<User> users = session.createQuery("select u from User u", User.class).getResultList();
//        System.out.println(users.get(0).getPassport());
        session.close();
        sessionFactory.close();
    }
}
