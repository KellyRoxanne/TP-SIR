package jpa;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import domain.Concert;

public class ConcertService {

    private EntityManager manager;

    public ConcertService(EntityManager manager) {
        this.manager = manager;
    }

    //  Créer un concert
    public void createConcert(Concert concert) {
        manager.persist(concert);
    }

    // Lister tous les concerts
    public List<Concert> findAllConcerts() {
        TypedQuery<Concert> query =
                manager.createQuery("SELECT c FROM Concert c", Concert.class);
        return query.getResultList();
    }

    //  Trouver un concert par id
    public Concert findConcert(Long id) {
        return manager.find(Concert.class, id);
    }
    
//  Recherche de concert par ville
    public List<Concert> findByLocation(String city) {
        return manager.createQuery("SELECT c FROM Concert c WHERE c.location = :city", Concert.class)
                      .setParameter("city", city)
                      .getResultList();
    }
}
