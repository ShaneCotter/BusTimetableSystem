package Services;

import javax.persistence.*;
import ex1.*;

public class Values {

 
    public static void main(String[] args) {
        
        EntityManagerFactory emf;
        EntityManager em;
        
        emf = Persistence.createEntityManagerFactory("CaTestPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();

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

        Bus b3 = new Bus();
        b3.setId(3);
        b3.setCapacity(50);
        b3.setBus_type("Comfort");
        em.persist(b3);
        
        Bus b4 = new Bus();
        b4.setId(4);
        b4.setCapacity(30);
        b4.setBus_type("Express");
        em.persist(b4);
        
        Bus b5 = new Bus();
        b5.setId(5);
        b5.setCapacity(50);
        b5.setBus_type("Comfort");
        em.persist(b5);
        
        Bus b6 = new Bus();
        b6.setId(6);
        b6.setCapacity(30);
        b6.setBus_type("Express");
        em.persist(b6);
        
        Bus b7 = new Bus();
        b7.setId(7);
        b7.setCapacity(50);
        b7.setBus_type("Comfort");
        em.persist(b7);
        
        Bus b8 = new Bus();
        b8.setId(8);
        b8.setCapacity(30);
        b8.setBus_type("Express");
        em.persist(b8);
        
        Bus b9 = new Bus();
        b9.setId(9);
        b9.setCapacity(50);
        b9.setBus_type("Comfort");
        em.persist(b9);
        
        Bus b10 = new Bus();
        b10.setId(10);
        b10.setCapacity(30);
        b10.setBus_type("Express");
        em.persist(b10);
        
        Bus b11 = new Bus();
        b11.setId(11);
        b11.setCapacity(50);
        b11.setBus_type("Comfot");
        em.persist(b11);
        
        Bus b12 = new Bus();
        b12.setId(12);
        b12.setCapacity(30);
        b12.setBus_type("Express");
        em.persist(b12);
        
        Route r1 = new Route(1, "Dublin", "Cork", "3hr", 20);
        
        Route r2 = new Route(2, "Cork", "Dublin", "3hr", 20);
        
        Route r3 = new Route(3, "Galway", "Dublin", "2hr 42min", 15);
        
        Route r4 = new Route(4, "Dublin", "Galway", "2hr 42min", 15);
        
        Route r5 = new Route(5, "Dublin", "Belfast", "2hr 30min", 9);
        
        Route r6 = new Route(6, "Belfast", "Dublin", "2hr 30min", 9);
       
        
        b1.addRoute(r1);
        b2.addRoute(r1);
        b3.addRoute(r2);
        b4.addRoute(r2);
        b5.addRoute(r3);
        b6.addRoute(r3);
        b7.addRoute(r4);
        b8.addRoute(r4);
        b9.addRoute(r5);
        b10.addRoute(r5);
        b11.addRoute(r6);
        b12.addRoute(r6);
        
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        em.persist(b4);
        em.persist(b5);
        em.persist(b6);
        em.persist(b7);
        em.persist(b8);
        em.persist(b9);
        em.persist(b10);
        em.persist(b11);
        em.persist(b12);
                     
        Timetable t1 = new Timetable(1, 1,"Mid-week","06:00","22:00","A bus leaves every hour");
        em.persist(t1);
        
        Timetable t2 = new Timetable(2, 1,"Weekend","08:00","19:00","A bus leaves every half hour");
        em.persist(t2);
        
        Timetable t3 = new Timetable(3, 1, "Bank Holiday", "10:00", "17:00", "A bus leaves every hour");
        em.persist(t3);
        
        r1.addTimetable(t1);
        r1.addTimetable(t2);
        r1.addTimetable(t3);
        
        Timetable t4 = new Timetable(4, 2,"Mid-week","06:00","22:00","A bus leaves every hour");
        em.persist(t4);
        
        Timetable t5 = new Timetable(5, 2,"Weekend","08:00","19:00","A bus leaves every half hour");
        em.persist(t5);
        
        Timetable t6 = new Timetable(6, 2, "Bank Holiday", "10:00", "17:00", "A bus leaves every hour");
        em.persist(t6);
        
        r2.addTimetable(t4);
        r2.addTimetable(t5);
        r2.addTimetable(t6);
        
        Timetable t7 = new Timetable(7, 3,"Mid-week","08:00","20:00","A bus leaves every hour");
        em.persist(t7);
        
        Timetable t8 = new Timetable(8, 3,"Weekend","10:00","18:00","A bus leaves every half hour");
        em.persist(t8);
        
        Timetable t9 = new Timetable(9, 3, "Bank Holiday", "12:00", "16:00", "A bus leaves every hour");
        em.persist(t9);
        
        r3.addTimetable(t7);
        r3.addTimetable(t8);
        r3.addTimetable(t9);
        
        Timetable t10 = new Timetable(10, 4,"Mid-week","08:00","20:00","A bus leaves every hour");
        em.persist(t10);
        
        Timetable t11 = new Timetable(11, 4,"Weekend","10:00","18:00","A bus leaves every half hour");
        em.persist(t11);
        
        Timetable t12 = new Timetable(12, 4, "Bank Holiday", "12:00", "16:00", "A bus leaves every hour");
        em.persist(t12);
        
        r4.addTimetable(t10);
        r4.addTimetable(t11);
        r4.addTimetable(t12);
        
        Timetable t13 = new Timetable(13, 5,"Mid-week","06:00","21:00","A bus leaves every hour");
        em.persist(t13);
        
        Timetable t14 = new Timetable(14, 5,"Weekend","09:00","19:00","A bus leaves every half hour");
        em.persist(t14);
        
        Timetable t15 = new Timetable(15, 5, "Bank Holiday", "10:00", "16:00", "A bus leaves every hour");
        em.persist(t15);
        
        r5.addTimetable(t13);
        r5.addTimetable(t14);
        r5.addTimetable(t15);
        
        Timetable t16 = new Timetable(16, 6,"Mid-week","06:00","21:00","A bus leaves every hour");
        em.persist(t16);
        
        Timetable t17 = new Timetable(17, 6,"Weekend","09:00","19:00","A bus leaves every half hour");
        em.persist(t17);
        
        Timetable t18 = new Timetable(18, 6, "Bank Holiday", "10:00", "16:00", "A bus leaves every hour");
        em.persist(t18);
        
        r6.addTimetable(t16);
        r6.addTimetable(t17);
        r6.addTimetable(t18);
        
        Fare f1 = new Fare(1,5.00,6.50,10,5.75);
        em.persist(f1);
        r1.setFare(f1);
        
        Fare f2 = new Fare(2,5.00,6.50,10,5.75);
        em.persist(f2);
        r1.setFare(f2);
        
        Fare f3 = new Fare(3,4.75,5.90,9.50,5.45);
        em.persist(f3);
        r1.setFare(f3);
        
        Fare f4 = new Fare(4,4.75,5.90,9.50,5.45);
        em.persist(f4);
        r1.setFare(f4);
        
        Fare f5 = new Fare(5,8.00,8.50,12.00,8.25);
        em.persist(f5);
        r1.setFare(f5);
        
        Fare f6 = new Fare(6,8.00,8.50,12.00,8.25);
        em.persist(f6);
        r1.setFare(f6);
        
        em.persist(r1);
        em.persist(r2);
        em.persist(r3);
        em.persist(r4);
        em.persist(r5);
        em.persist(r6);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}