package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;
import domain.Concert;
import domain.Ticket;

public class JpaTest {

    private EntityManager manager;

    public JpaTest(EntityManager manager) {
        this.manager = manager;
    }

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();
        
        JpaTest test = new JpaTest(manager);
        EntityTransaction tx = manager.getTransaction();

        try {
            tx.begin();
            
            test.populateData();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        }

        
        test.listConcerts();

        manager.close();
        factory.close();
        System.out.println(".. done");
    }

    private void populateData() {
        ConcertService service = new ConcertService(manager);
        
        
        if (service.findAllConcerts().isEmpty()) {
            Concert concert1 = new Concert("Drake Tour", "Paris", 90);
            Ticket t1 = new Ticket("Standard", 90, concert1);
            Ticket t2 = new Ticket("VIP", 150, concert1);
            
            
            manager.persist(concert1);
            manager.persist(t1);
            manager.persist(t2);

            service.createConcert(new Concert("Aya Nakamura", "Paris", 70));
            service.createConcert(new Concert("Davido", "Londres", 85));
        }
    }

    private void listConcerts() {
        ConcertService service = new ConcertService(manager);
        List<Concert> concerts = service.findAllConcerts();
        System.out.println("Nombre de concerts : " + concerts.size());
        for (Concert c : concerts) {
            System.out.println("Concert: " + c.getTitle() + " à " + c.getLocation());
        }
    }
}