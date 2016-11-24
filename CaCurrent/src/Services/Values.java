package Services;

import ex1.Bus;
import ex1.Fare;
import ex1.Route;
import ex1.Timetable;
import java.util.List;
import javax.persistence.*;

public class Values {


    public static void main(String[] args) {
        
        EntityManagerFactory emf;
        EntityManager em;
        
        emf = Persistence.createEntityManagerFactory("CaTestPU");
        em = emf.createEntityManager();
        

        em.getTransaction().begin();



//////////////////////////INSERTING VALUES THROUGH JPA//////////////////////////
        Bus b1 = new Bus();
        b1.setId(1);
        b1.setCapacity(50);
        b1.setBus_type("Comfort");
        em.persist(b1);

        Bus b2 = new Bus();
        b2.setId(2);
        b2.setCapacity(30);
        b2.setBus_type("Express");
        em.persist(b2);

        Route r1 = new Route(1, "Dublin", "Cork", "2hr 45min", 20);
        
        Route r2 = new Route(2, "Dublin", "Kildare", "1hr", 8);
        em.persist(r2);
        
        b1.addRoute(r1);
        b2.addRoute(r1);
        em.persist(b1);
        
        Timetable t1 = new Timetable(1,1,"Mid-week","06:00","22:00","A bus leaves every hour");
        em.persist(t1);
        
        Timetable t2 = new Timetable(2,1,"Weekend","08:00","19:00","A bus leaves every half hour");
        em.persist(t2);
        r1.addTimetable(t1);
        r1.addTimetable(t2);
        
        Fare f1 = new Fare(1,1.75,2.00,1.55,10);
        em.persist(f1);
        r1.setFare(f1);
//        em.persist(r1);
        
        Fare f2 = new Fare(1,2.75,3.00,2.55,10);
        em.persist(f2);
        r1.setFare(f2);
        em.persist(r1);


//        Route1 c3 = new Route1(3, "Dublin", "Belfast", "1hr 30min ", 20);
//        c3.addBus(s1);
//        c3.addBus(s2);

        System.out.println(r1);

//        c3.remove();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}