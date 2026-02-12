package jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import domain.Concert;
import domain.Ticket;

public class JpaTest {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("example");
        EntityManager manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();

        Concert concert = new Concert("Drake Tour", "Paris", 90);

        Ticket t1 = new Ticket("Standard", 90, concert);
        Ticket t2 = new Ticket("VIP", 150, concert);

        concert.getTickets().add(t1);
        concert.getTickets().add(t2);

        manager.persist(concert);

        // ==================================
        tx.commit();

        manager.close();
        factory.close();

        System.out.println("Concert et tickets persistés !");
    }
}
