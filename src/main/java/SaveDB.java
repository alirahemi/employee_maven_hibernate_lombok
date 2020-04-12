import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveDB {
    public static void main(String[] args) {
        // create session FACTORY
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();

        saveDB(factory, session);
    }

    private static void saveDB(SessionFactory factory, Session session) {
        try {
            // create a employee object
            System.out.println("Creating new Employee object...");
            Employee employee = new Employee("reza","mehrabi", "google");
            // start the employee object
            session.beginTransaction();
            // save the employee object
            System.out.println("Saving the Employee...");
            session.save(employee);
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        }finally {
            factory.close();
        }
    }
}

