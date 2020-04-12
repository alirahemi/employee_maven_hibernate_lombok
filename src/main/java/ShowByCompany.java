import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ShowByCompany {
    public static void main(String[] args) {
        // create session FACTORY
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();


        showByCompany(factory, session);
    }

    private static void showByCompany(SessionFactory factory, Session session) {
        try {
            // start the employee object
            session.beginTransaction();

            // search a employee object
            //long id = 2;
            System.out.println("Searching Employees with a given Company...");
            //Employee employee = session.get(Employee.class, id);

            List<Employee> employee = session.createQuery("from Employee where company = 'google'").list();

            // commit transaction
            session.getTransaction().commit();

            // print employee
            for (Employee employeeByCompany: employee
                 ) {
                System.out.println(employeeByCompany);
            }

            System.out.println("Done!");

        }finally {
            factory.close();
        }
    }
}

