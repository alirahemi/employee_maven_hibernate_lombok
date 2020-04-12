import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DeleteByID {
    public static void main(String[] args) {
        // create session FACTORY
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();


        deleteByID(factory, session);
    }

    private static void deleteByID(SessionFactory factory, Session session) {
        try {
            // start the employee object
            session.beginTransaction();

            // search a employee object
            long id = 1;
            System.out.println("Deleting Employee with ID...");
            Employee employee = session.get(Employee.class, id);

            // delete
            session.delete(employee);

            // commit transactionw
            session.getTransaction().commit();

            // print employee
            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }
}

