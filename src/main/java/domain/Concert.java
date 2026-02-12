package domain;

import java.util.ArrayList; // Ajouté
import java.util.List;
import jakarta.persistence.CascadeType; // Ajouté
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany; // Ajouté

@Entity
public class Concert {

    private Long id;
    private String title;
    private String location;
    private double price;
    private List<Ticket> tickets = new ArrayList<>(); // Initialisation de la liste

    public Concert() {}

    public Concert(String title, String location, double price) {
        this.title = title;
        this.location = location;
        this.price = price;
    }

    @Id
    @GeneratedValue
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    
    @OneToMany(mappedBy = "concert", cascade = CascadeType.PERSIST)
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}