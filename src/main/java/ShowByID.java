import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ShowByID {
    public static void main(String[] args) {
        // create session FACTORY
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();


        showByID(factory, session);
    }

    private static void showByID(SessionFactory factory, Session session) {
        try {
            // start the employee object
            session.beginTransaction();

            // search a employee object
            //long id = 2;
            System.out.println("Searching Employee with ID...");
            //Employee employee = session.get(Employee.class, id);

            List<Employee> employee = session.createQuery("from Employee where id = 2").list();

            // commit transaction
            session.getTransaction().commit();

            // print employee
            System.out.println(employee);
            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }
}

