import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;

import java.sql.*;

public class DB {
    private static final String URL = "jdbc:mysql://localhost:32769";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static void connect(){
        System.out.println("Direct JDBC start");
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)){

            Statement statement = connection.createStatement();
            statement.execute("DROP SCHEMA IF EXISTS test");
            statement.execute("CREATE SCHEMA test");

        } catch (SQLException e){
            System.out.println("We got error: " + e.getMessage());
        }
        System.out.println("Direct JDBC end");

        System.out.println("Hibernate start");
       StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
               .configure()
               .build();

        SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = sessionFactory.openSession();
        MyTestHibernate myTestHibernate = new MyTestHibernate("first", "second", "third");
        session.beginTransaction();
        session.save(myTestHibernate);
        session.getTransaction().commit();
        session.close();

        System.out.println("Hibernate end");

    }

}
